package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = {"", "/home"})
@Controller
public class HomeController {

    @GetMapping
    public String showHomepage(){
        return "home";
    }
}
