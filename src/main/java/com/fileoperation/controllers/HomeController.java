package com.fileoperation.controllers;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pradeep on 9/1/17.
 */

@RestController
@RequestMapping(value = "/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String sendRedirectHome(ModelMap model) {
        model.addAttribute("message", "File Uploader");
        return "home";
    }
}
