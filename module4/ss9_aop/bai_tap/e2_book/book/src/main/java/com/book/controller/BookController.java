package com.book.controller;

import com.book.model.Book;
import com.book.model.Cart;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class BookController {
    @Autowired
    private BookService bookService;

    @ModelAttribute("cart")
    private Cart setupBook() {
        return new Cart();
    }

    @GetMapping("/book")
    public ModelAndView showBook() {
        ModelAndView modelAndView = new ModelAndView("/book");
        modelAndView.addObject("books", bookService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String rentBook(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action, Model model) {
        Optional<Book> bookOptional = bookService.findById(id);
        if (!bookOptional.isPresent()) {
            return "error-404";
        }
        if(bookOptional.get().getQuantity()<1) {
            model.addAttribute("detailname",bookOptional.get().getName());
            return "error-item";
        }
        if (action.equals("show")) {
            cart.addBook(bookOptional.get());
            Book book= bookOptional.get();
            book.setQuantity(book.getQuantity()-1);
            bookService.save(book);
            return "redirect:/book";
        }
        cart.addBook(bookOptional.get());
        Book book= bookOptional.get();
        book.setQuantity(book.getQuantity()-1);
        bookService.save(book);
        return "redirect:/book";
    }
    @PostMapping("/backbook")
    public String backbook(@RequestParam("id_back") int code,@ModelAttribute Cart cart,Model model) {
            if (cart.getBooks().containsKey(code)){
                Book book=bookService.findById(cart.getBookObject(code).getId()).orElse(null);
                book.setQuantity(book.getQuantity()+1);
                bookService.save(book);
                cart.backBook(code);
                return "redirect:/book";
            }
            else {
                model.addAttribute("detailcode",code);
                return "error-item";
            }


    }
}
