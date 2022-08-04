package com.validatesong.controller;

import com.validatesong.model.Song;
import com.validatesong.model.SongDto;
import com.validatesong.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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


        model.addAttribute("song", new SongDto());
        return "create";
    }
    @GetMapping("/delete/id={id}")
    public String deleteStudent(@PathVariable("id") int id,RedirectAttributes redirectAttributes){
        songService.delete(id);
        redirectAttributes.addFlashAttribute("message","Delete song: OK!");
        return "redirect:song/list";
    }

    @PostMapping("/create")
    public String createStudent(@Validated @ModelAttribute("song") SongDto songDto, BindingResult bindingResult,
                                RedirectAttributes redirectAttributes){
        if(bindingResult.hasFieldErrors()){
            return "create";
        }
        else {
            Song song=new Song();
            BeanUtils.copyProperties(songDto,song);
            System.out.println(song);
            songService.save(song);
            redirectAttributes.addFlashAttribute("message",
                    "Create song: " + song.getName() + " OK!");
//        return "forward:/song/list";
            return "redirect:/song/list";
        }

    }
    @GetMapping("/edit/")
    public String editSong(@RequestParam("id")int id,Model model){
        Song song=songService.findById(id).get();
        SongDto songDto=new SongDto();
        BeanUtils.copyProperties(song,songDto);
        model.addAttribute("song", songDto);
        return "create";
        //loi Resolved [org.springframework.web.HttpRequestMethodNotSupportedException: Request method 'POST' not supported]
    }
}
