package com.furama.controller;


import com.furama.model.Customer.Customer;
import com.furama.model.Customer.CustomerDto;
import com.furama.model.Customer.CustomerType;
import com.furama.service.Customer.CustomerServiceImpl;
import com.furama.service.Customer.CustomerTypeSerivceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.tools.jconsole.JConsole;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/customer")
//@SessionAttributes("customer")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private CustomerTypeSerivceImpl typeService;

    @GetMapping("/customer")
    public String view(Model model, CustomerDto customer, BindingResult bindingResult, @RequestParam(defaultValue = "") String q, @PageableDefault(value = 5)Pageable pageable) {
        model.addAttribute("res", customerService.find(q, pageable));
        model.addAttribute("cate", typeService.findAll());
        model.addAttribute("customer", customer);
        model.addAttribute("q", q);
        model.addAttribute("sort", pageable.getSort());
        model.addAttribute("isError", bindingResult.hasErrors());
        return "customer";
    }
    @GetMapping("/api/customer")
    public ResponseEntity<Page<Customer>> view(@RequestParam(defaultValue = "") String q, @PageableDefault(value = 5)Pageable pageable) {
        Page<Customer> customers= customerService.find(q, pageable);
        System.out.println(customers);
        return new  ResponseEntity<>(customers,HttpStatus.OK);
    }
    @PostMapping("/customer")
    public String save(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult,@RequestParam(defaultValue = "") String q, @PageableDefault(value = 5)Pageable pageable, RedirectAttributes redirect,Model model){
//        new CustomerDto().validate(customerDto,bindingResult);

        if(bindingResult.hasErrors()){
//            return view(model,customer,bindingResult,"",pageable);
            model.addAttribute("res", customerService.find(q, pageable));
            model.addAttribute("cate", typeService.findAll());
            model.addAttribute("customer", customerDto);
            model.addAttribute("q", q);
            model.addAttribute("sort", pageable.getSort());
            model.addAttribute("isError", bindingResult.hasErrors());
            return "customer";
        }
        Customer customer1=new Customer();
        BeanUtils.copyProperties(customerDto,customer1);

        customer1.setBirthday(customerDto.getBirthday().toString());
        CustomerType customerType=new CustomerType();
        customerType=typeService.findById(customerDto.getCustomerTypeId()).get();
        customer1.setCustomerType(customerType);
        customerService.save(customer1);
        redirect.addFlashAttribute("msg","Create/Update Succesfully");

        return "redirect:/customer";
    }
//    @DeleteMapping
//    public String delete(@RequestParam String id,RedirectAttributes redirect){
//        System.out.println(id);
//        customerService.delete(id);
//        redirect.addFlashAttribute("msg","Delete Succesfully");
//        return "redirect:/customer";
//    }
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<String> delete(@PathVariable String id,RedirectAttributes redirect){
        System.out.println(id);
        Optional<Customer> customer=customerService.findById(id);
        if (!customer.isPresent()){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        customerService.delete(id);
        redirect.addFlashAttribute("msg","Delete Succesfully");
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/customer/edit/{id}")
    public ResponseEntity<Customer> findCustomer(@PathVariable String id){
        Optional<Customer> customer=customerService.findById(id);
        if (!customer.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println(customer.get());
        return new ResponseEntity<>(customer.get(),HttpStatus.OK);
    }
}