package com.klaster.webstore.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by MSI DRAGON on 2017-09-17.
 */

@Controller
@RequestMapping("/DODALEMALEUSUNTOWPRZYSZLOSCI")
public class LoginController {
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login() {return "login";}

    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public String loginerror(Model model) {
        model.addAttribute("error", "true");
        return "login";
    }
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(Model model) {
        return "login";
    }

    @RequestMapping(value="/testt", method = RequestMethod.GET)
    public String testt(Model model) {
        return "testt";
    }


}
