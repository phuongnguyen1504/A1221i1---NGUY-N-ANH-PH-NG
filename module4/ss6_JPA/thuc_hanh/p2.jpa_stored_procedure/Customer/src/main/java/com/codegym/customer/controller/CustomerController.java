package com.codegym.customer.controller;


import com.codegym.customer.model.Customer;
import com.codegym.customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/customers")
    public ModelAndView listCustomer(){
        List<Customer> customers=customerService.findAll();
        ModelAndView modelAndView=new ModelAndView("/customer/list");
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }
    @GetMapping("/create-customer")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView=new ModelAndView("/customer/create");
        modelAndView.addObject("customer",new  Customer());
        return modelAndView;
    }
    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer){
//        customerService.save(customer);
        customerService.insertWithStoredProcedure(customer);
        ModelAndView modelAndView=new ModelAndView("/customer/create");
        modelAndView.addObject("customer",new  Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }
}
