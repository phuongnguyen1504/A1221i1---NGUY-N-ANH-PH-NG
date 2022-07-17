package controller;

import model.Currency;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CurrencyController {
    @GetMapping("")
    public String home(){
        return "home";
    }
    @PostMapping("convert")
    public ModelAndView convert(Currency currency){
        ModelAndView modelAndView=new ModelAndView("detail");
            double result=currency.getUsd()*currency.getRate();
            modelAndView.addObject("result",String.format("%.2f",result));//dinh dang 2 chu so thap phan
            return modelAndView;
    }
}
