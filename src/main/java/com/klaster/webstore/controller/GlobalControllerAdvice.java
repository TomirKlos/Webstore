package com.klaster.webstore.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by MSI DRAGON on 2017-09-29.
 */
@ControllerAdvice
public class GlobalControllerAdvice {

        @ModelAttribute
        public void globalAttributes(Model model) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String name = auth.getName(); //get logged in username
            model.addAttribute("username", name);
        }

}

