package com.example.frontservice.controller;

import com.example.frontservice.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class MainPageController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/main", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("answer", new Answer());
        return "main";
    }

    @RequestMapping(value="/main", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Answer answer, Model model) {
        model.addAttribute("greeting", answer);
        return "main";
    }
}
