package com.klaster.webstore.controller;

import com.klaster.webstore.domain.Customer;
import com.klaster.webstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by MSI DRAGON on 2017-09-10.
 */
@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping
    public String list(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }

    @RequestMapping(value="/insert", method= RequestMethod.GET)
    public String insert() {
        customerService.create(new Customer("John Cena", "Uek kampus", "666555444"));
        customerService.create(new Customer("Johhny Walkier", "Muzeum lotnictwa", "999000999"));
        customerService.create(new Customer("Janusz Grazyna", "Skawina", "123123123"));
        return "redirect:/customers";
    }
}
