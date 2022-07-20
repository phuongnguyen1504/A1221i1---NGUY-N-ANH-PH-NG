package controller;

import model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.SongService;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("")
    public String viewhome(){

        return "home";
    }
    @Autowired
    private SongService songService;
    @GetMapping("home")
    public ModelAndView home(){
        List<Song> songs=songService.getAll();
        return new ModelAndView("home","result",songs);
    }
}
