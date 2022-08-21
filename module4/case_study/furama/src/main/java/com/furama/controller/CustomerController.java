package com.furama.controller;


import com.furama.model.Customer.Customer;
import com.furama.model.Customer.CustomerDto;
import com.furama.service.Customer.CustomerServiceImpl;
import com.furama.service.Customer.CustomerTypeSerivceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/customer")
@SessionAttributes("customer")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private CustomerTypeSerivceImpl typeService;

    @GetMapping
    public String view(Model model, CustomerDto customer, BindingResult bindingResult, @RequestParam(defaultValue = "") String q, Pageable pageable) {
        model.addAttribute("res", customerService.find(q, pageable));
        model.addAttribute("cate", typeService.findAll());
        model.addAttribute("customer", customer);
        model.addAttribute("q", q);
        model.addAttribute("sort", pageable.getSort());
        model.addAttribute("isError", bindingResult.hasErrors());
        return "customer";
    }


}
