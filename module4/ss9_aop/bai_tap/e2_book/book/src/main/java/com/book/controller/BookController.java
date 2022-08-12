package com.book.controller;

import com.book.model.Book;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;

@Controller
@SessionAttributes("book")
public class BookController {
    @Autowired
    private BookService bookService;
    @ModelAttribute("book")
    private Book setupBook(){
        return new Book();
    }
    @GetMapping("/book")
    public ModelAndView showBook(){
        ModelAndView modelAndView=new ModelAndView("/book");
        modelAndView.addObject("books",bookService.findAll());
        Cookie cookie=new Cookie("a","a");
        cookie.setMaxAge(i);

        return modelAndView;
    }
}
