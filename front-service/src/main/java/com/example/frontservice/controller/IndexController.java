package com.example.frontservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class IndexController {

//    @Autowired
//    private MessageRepo messageRepo;

    @GetMapping("/")
    //   public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model/*Model model*/) {
    public String greeting(Map<String, Object> model/*Model model*/) {

        //model.addAttribute("name", name);
        //model.put("name", name);
        return "main";
    }

}
