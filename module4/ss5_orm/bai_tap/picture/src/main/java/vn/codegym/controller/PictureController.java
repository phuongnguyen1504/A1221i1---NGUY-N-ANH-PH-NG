package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Feedback;
import vn.codegym.service.IPictureService;

@Controller
@RequestMapping({"/picture","/home"})
public class PictureController {

//    @Qualifier("studentServiceImpl")
    @Autowired
    private IPictureService pictureService;


    @RequestMapping(value = "/list",
                    method = RequestMethod.GET)
//                    consumes = "text/html",
//                    produces = "text/html")
    public ModelAndView showFeedbackList(){
        ModelAndView modelAndView=new ModelAndView("list");
        modelAndView.addObject("feedback",new Feedback());
        modelAndView.addObject("FeedbackList", pictureService.findAll());
        return modelAndView;
    }

    @PostMapping("/list")
    public ModelAndView showStudentList1(){

        return new ModelAndView("list",
                "FeedbackList", pictureService.findAll());
    }

//    @GetMapping("/create")
//    public String showCreatePage(Model model){
//
//
//        model.addAttribute("feedback", new Feedback());
//        return "create";
//    }
//    @GetMapping("/delete/id={id}")
//    public String deleteStudent(@PathVariable("id") int id,RedirectAttributes redirectAttributes){
//        pictureService.delete(id);
//        redirectAttributes.addFlashAttribute("message","Delete song: OK!");
//        return "redirect:/picture/list";
//    }

    @PostMapping("/create")
    public String createFeedBack(@ModelAttribute Feedback feedback,
                                 RedirectAttributes redirectAttributes){

        System.out.println(feedback);
        pictureService.save(feedback);
        redirectAttributes.addFlashAttribute("message",
                "Create feedback: "  + " OK!");
//        return "forward:/song/list";
        return "redirect:/picture/list";
    }
}
