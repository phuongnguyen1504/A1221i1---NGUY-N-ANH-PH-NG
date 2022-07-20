package controller;

import model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailController {
    private static Email email=new Email();
    private static List<String> languages=new ArrayList<>();
    private static List<Integer> pageSize=new ArrayList<>();
    static {
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(25);
        pageSize.add(50);
        pageSize.add(100);
    }
    @GetMapping
    public ModelAndView home(){
        ModelAndView modelAndView=new ModelAndView("home");
        return modelAndView;
    }
    @GetMapping("config")
    public ModelAndView config(){

        ModelAndView modelAndView=new ModelAndView("config");
        modelAndView.addObject("email",email);
        modelAndView.addObject("languageList",languages);
        modelAndView.addObject("pageSizeList",pageSize);
        return modelAndView;
    }
    @PostMapping("save")
    public String save(Email e){
        email=e;
        return "home";
    }
}
