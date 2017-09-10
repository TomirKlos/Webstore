package com.klaster.webstore.controller;

import com.klaster.webstore.domain.Product;
import com.klaster.webstore.domain.repository.ProductRepository;
import com.klaster.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
        productService.create(new Product("Produkt1", (BigDecimal.valueOf(22.0)),"Produkt jaki jest kazdy widzi", "Corpo", "Laptop", 5, 0, false, "nowy"));
        productService.create(new Product("Produkt2", (BigDecimal.valueOf(22.0)),"Produkt jaki jest kazdy widzi", "Corpo", "Laptop", 5, 0, false, "nowy"));
        productService.create(new Product("Produkt3", (BigDecimal.valueOf(22.0)),"Produkt jaki jest kazdy widzi", "Corpo", "Laptop", 5, 0, false, "nowy"));

        return "redirect:/products";
    }

    @RequestMapping(value="/put", method= RequestMethod.GET)
    public String insertByCriteria(@RequestParam("name") String productName) {
        productService.create(new Product(productName));
        return "redirect:/products";
    }

    @RequestMapping(value="/read", method= RequestMethod.GET)
    public String insertByCriteria(@RequestParam("id") long productId, Model model) {

        return "products";
    }
}
