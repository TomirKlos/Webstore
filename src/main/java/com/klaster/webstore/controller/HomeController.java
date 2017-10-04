package com.klaster.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by MSI DRAGON on 2017-09-08.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String welcome() {
        return "forward:/products";
    }
}
