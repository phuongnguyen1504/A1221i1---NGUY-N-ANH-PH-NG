package controller;

import model.HealthForm;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class Declare {
    private static  HealthForm input=new HealthForm();
    private static List<String> status=new ArrayList<>();
    private static List<String> historySick=new ArrayList<>();
    private static List<String> variable=new ArrayList<>();

    @GetMapping("")
    public String home(){
        return "home";
    }
    @GetMapping("/create")
    public String showCreatePage(Model model){
        model.addAttribute("form",input);
        return "list";
    }
    @PostMapping("/create")
    public String createDeclare(@ModelAttribute HealthForm form, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message","Create declare: "+form.getName()+" OK!");
        input=form;
        return "redirect:/list";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
