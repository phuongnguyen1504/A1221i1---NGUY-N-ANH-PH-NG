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
@RequestMapping("")
class SongController {
    @Autowired
    private SongService songService;
    @GetMapping
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("customers/list");
        List<Song> customers = songService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

}
