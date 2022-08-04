package com.validateform.controller;

import com.validateform.model.User;
import com.validateform.model.UserDto;
import com.validateform.service.IFormService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/form", "/home"})
public class FormController {
    @Autowired
    private IFormService formService;
    @GetMapping("/list")
    public String showForm(Model model){
        model.addAttribute("User",new UserDto());

        return "index";
    }

    @PostMapping("/create")
    public String createUser(@Validated @ModelAttribute("User") UserDto userDto, BindingResult bindingResult, Model model){
        new UserDto().validate(userDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("User",userDto);
            return "index";
        }
        else {
            User user=new User();
            BeanUtils.copyProperties(userDto,user);
            formService.save(user);
            return "result";
        }
    }

}
