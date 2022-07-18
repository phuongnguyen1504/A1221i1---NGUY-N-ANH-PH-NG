package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
 @GetMapping("/")
 public String home(){
  return "index";
 }
 @PostMapping("/calculate")
    public ModelAndView calculate(@RequestParam int num1,int num2,String operator){
  Float result = 0F;
  switch (operator){
   case "+":
    result= Float.valueOf(num1+num2);
    break;
   case "-":
    result= Float.valueOf(num1-num2);
    break;
   case "*":
    result= Float.valueOf(num1*num2);
    break;
   case "/":
    if(num2==0) {
     return new ModelAndView("index","result","Infinity");
    }
     else {
      result= Float.valueOf(num1/num2);
     }
     break;
  }
     ModelAndView modelAndView=new ModelAndView("index","result",result);
     return modelAndView;
 }
}
