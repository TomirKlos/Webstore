package com.klaster.webstore.controller;

import com.klaster.webstore.domain.Product;
import com.klaster.webstore.domain.repository.ProductRepository;
import com.klaster.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
    public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
        model.addAttribute("products", productService.getProductsByCategory(productCategory));
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
    public String getProductByCategoryPriceManufacturer(Model model, @PathVariable("category") String productCategory, @MatrixVariable(pathVar = "price") int low, @MatrixVariable(pathVar = "price") int high, @RequestParam("manufacturer") String manufacturer){
        model.addAttribute("products", productService.getProductByCategoryPriceManufacturer(productCategory, low, high, manufacturer));
        return "products";
    }

}
