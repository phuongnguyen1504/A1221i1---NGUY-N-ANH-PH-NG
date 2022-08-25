package com.furama.controller;


import com.furama.model.Customer.Customer;
import com.furama.model.Customer.CustomerDto;
import com.furama.service.Customer.CustomerServiceImpl;
import com.furama.service.Customer.CustomerTypeSerivceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
//@SessionAttributes("customer")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private CustomerTypeSerivceImpl typeService;

    @GetMapping
    public String view(Model model, CustomerDto customer, BindingResult bindingResult, @RequestParam(defaultValue = "") String q, @PageableDefault(value = 5)Pageable pageable) {
        model.addAttribute("res", customerService.find(q, pageable));
        model.addAttribute("cate", typeService.findAll());
        model.addAttribute("customer", customer);
        model.addAttribute("q", q);
        model.addAttribute("sort", pageable.getSort());
        model.addAttribute("isError", bindingResult.hasErrors());
        return "customer";
    }
    @PostMapping
    public String save(@Validated CustomerDto customer, BindingResult bindingResult, @PageableDefault(value = 5)Pageable pageable, RedirectAttributes redirect,Model model){
        if(bindingResult.hasErrors()){
            return view(model,customer,bindingResult,"",pageable);
        }
        Customer customer1=new Customer();
        BeanUtils.copyProperties(customer,customer1);
        customerService.save(customer1);
        return "redirect:/";
    }
    @DeleteMapping
    public String delete(@RequestParam int id,RedirectAttributes redirect){
        customerService.delete(id);
        redirect.addFlashAttribute("msg","Delete Succesfully");
        return "redirect:/";
    }
}
