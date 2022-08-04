package com.picture.controller;

import com.picture.model.Feedback;
import com.picture.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    public ModelAndView showFeedbackList(@PageableDefault(value = 5)Pageable pageable){
        ModelAndView modelAndView=new ModelAndView("list");
        modelAndView.addObject("feedback",new Feedback());
        modelAndView.addObject("FeedbackList", pictureService.findAll(pageable));
        return modelAndView;
    }

    @PostMapping("/list")
    public ModelAndView showStudentList1(@PageableDefault(value = 5)Pageable pageable){

        return new ModelAndView("list",
                "FeedbackList", pictureService.findAll(pageable));
    }


    @PostMapping("/create")
    public String createFeedBack(@ModelAttribute Feedback feedback,
                                 RedirectAttributes redirectAttributes){

        feedback.setDate(LocalDate.now().toString());
        pictureService.save(feedback);
        redirectAttributes.addFlashAttribute("message",
                "Create feedback: "  + " OK!");
//        return "forward:/song/list";
        return "redirect:/picture/list";
    }
    @GetMapping("/like")
    public String likeFeedBack(@RequestParam("id") int id){
        pictureService.like(id);
        return "redirect:/picture/list";

    }
}
