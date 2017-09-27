package com.klaster.webstore.controller;

import com.klaster.webstore.domain.Product;
import com.klaster.webstore.domain.ProductImage;
import com.klaster.webstore.domain.repository.ProductRepository;
import com.klaster.webstore.exception.NoProductsFoundUnderCategoryException;
import com.klaster.webstore.exception.ProductNotFoundException;
import com.klaster.webstore.service.ProductService;
import com.klaster.webstore.validator.ProductValidator;
import com.klaster.webstore.validator.UnitsInStockValidator;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by MSI DRAGON on 2017-09-08.
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductValidator productValidator;

    @RequestMapping
    public String list(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping(value="/insert", method= RequestMethod.GET)
    public String insert() {
        productService.create(new Product("Laptop1", (BigDecimal.valueOf(22.0)),"Produkt jaki jest kazdy widzi", "Corpo", "Laptop", 5, 0, false, "nowy"));
        productService.create(new Product("Telefon2", (BigDecimal.valueOf(22.0)),"Produkt jaki jest kazdy widzi", "Corpo", "Telefon", 5, 0, false, "nowy"));
        productService.create(new Product("Tablet3", (BigDecimal.valueOf(22.0)),"Produkt jaki jest kazdy widzi", "Corpo", "Tablet", 5, 0, false, "nowy"));

        return "redirect:/products";
    }

    @RequestMapping(value="/put", method= RequestMethod.GET)
    public String insertByCriteria(@RequestParam("name") String productName) {
        productService.create(new Product(productName));
        return "redirect:/products";
    }

    @RequestMapping(value="/read", method= RequestMethod.GET)
    public String insertByCriteria(@RequestParam("id") long productId, Model model) {
        //todo strona produktu
        return "products";
    }

    @RequestMapping("/{category}")
    public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) throws NoProductsFoundUnderCategoryException {
        List<Product> products = new ArrayList<Product>();
        try{
            products = productService.getProductsByCategory(productCategory);
        } catch(IllegalArgumentException e) {
            throw new NoProductsFoundUnderCategoryException();
        }
        model.addAttribute("products", products);
        return "products";
    }

    @RequestMapping("/filter/{ByCriteria}")
    public String getProductsByFilter(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams, Model model) {
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        return "products";
    }
    @RequestMapping("/product")
    public String getProductById(@RequestParam("id") long productId, Model model) {
        model.addAttribute("product", productService.read(productId));
        return "product";
    }

    //http://localhost:8080/webstore/products/tablet/price;low=200;high=400?manufacturer=Google

    @RequestMapping("/{category}/{price}")
    public String getProductByCategoryPriceManufacturer(
            Model model, @PathVariable("category") String productCategory, @MatrixVariable(pathVar = "price") int low, @MatrixVariable(pathVar = "price") int high, @RequestParam("manufacturer") String manufacturer){
        model.addAttribute("products", productService.getProductByCategoryPriceManufacturer(productCategory, low, high, manufacturer));
        return "products";
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(Model model) {
        Product newProduct = new Product();
        ProductImage productImage = new ProductImage();
        model.addAttribute("newProduct", newProduct);
        model.addAttribute("productImage", productImage);
        return "addProduct";
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product newProduct, BindingResult result, @ModelAttribute("productImage") ProductImage image, HttpServletRequest request) throws IOException {
        if(result.hasErrors()) {
            return "addProduct";
        }
        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Próba wiązania niedozwolonych pól: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }
        MultipartFile productImage = image.getProductImage();
       // String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        if (productImage!=null && !productImage.isEmpty()) {
            try {
                newProduct.setImage(productImage.getBytes()); //todo to w sumie nie potrzebne
                byte[] encoded = Base64.getEncoder().encode(newProduct.getImage());
                newProduct.setBase64Image(new String(encoded));
               // productImage.transferTo(new File(rootDirectory+"resources\\images\\"+ newProduct.getProductId() + ".png"));
            } catch (Exception e) {
                throw new RuntimeException("Niepowodzenie podczas próby zapisu obrazka produktu", e);
            }
        }

      //  img = Thumbnails.of(img)
         //       .size(200,200)
         //       .asBufferedImage();

        productService.create(newProduct);
        return "redirect:/products";
        //todo dodac miniatury zdjec zamiast plenych obrazkow do strony products
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String index(){
        return "index";
    }


    @RequestMapping(value = "/search/search", method = RequestMethod.GET) //, produces = "application/json"
    @ResponseBody
    public List<String> search(Model model, HttpServletRequest request){
        return productService.search(request.getParameter("term"));
    }


    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("invalidProductId", exception.getProductId());
        mav.addObject("exception", exception);
        mav.addObject("url", req.getRequestURL()+"?"+req.getQueryString());
        mav.setViewName("productNotFound");
        return mav;
    }

    @RequestMapping("/invalidPromoCode")
    public String invalidPromoCode() {
        return "invalidPromoCode";
    }

    @InitBinder("product")
    public void initialiseBinder(WebDataBinder binder) {
        binder.setDisallowedFields("unitsInOrder", "discontinued");
        binder.setValidator(productValidator);
    }

  //  @InitBinder("Product")
  //  public void initBinder(WebDataBinder binder) {
   //
  //  }

}
