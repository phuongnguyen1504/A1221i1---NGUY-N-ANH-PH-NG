package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Song;
import vn.codegym.service.ISongService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"/song","/home"})
public class SongController {

//    @Qualifier("studentServiceImpl")
    @Autowired
    private ISongService songService;


//    @Autowired
//    public void setStudentService(IStudentService studentService) {
//        this.studentService = studentService;
//    }


//    public StudentController(IStudentService studentService) {
//        this.studentService = studentService;
//    }

    @RequestMapping(value = "/list",
                    method = RequestMethod.GET)
//                    consumes = "text/html",
//                    produces = "text/html")
    public ModelAndView showSongList(){
        return new ModelAndView("song",
                "songList", songService.findAll());
    }

    @PostMapping("/list")
    public ModelAndView showStudentList1(){
        return new ModelAndView("song",
                "songList", songService.findAll());
    }

    @GetMapping("/create")
    public String showCreatePage(Model model){


        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Song song,
                                RedirectAttributes redirectAttributes){
//        int id = Integer.parseInt(request.getParameter("studentId"));
//        String name = request.getParameter("studentName");
//        System.out.println(id + "---------" + name);
        System.out.println(song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("message",
                "Create song: " + song.getName() + " OK!");
//        return "forward:/song/list";
        return "redirect:/song/list";
    }
}
