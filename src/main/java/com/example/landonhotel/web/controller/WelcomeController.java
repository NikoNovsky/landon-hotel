package com.example.landonhotel.web.controller;

import io.micrometer.common.util.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping()
public class WelcomeController {

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
//    @ResponseBody
    public String getWelcome(@RequestParam(value = "name", required = false) String name, Model model) {
        String greeting = "Welcome ";
        greeting += StringUtils.isNotBlank(name) ? name : "guest";
        model.addAttribute("greeting", greeting);
        return "index";
    }


}
