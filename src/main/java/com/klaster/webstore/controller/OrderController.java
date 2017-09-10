package com.klaster.webstore.controller;

import com.klaster.webstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by MSI DRAGON on 2017-09-10.
 */
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("/order/{productId}/{count}")
    public String process(@PathVariable(value = "productId") long productId, @PathVariable(value = "count") int count) {
        orderService.processOrder(productId, count);
        return "redirect:/products";
    }
}
