package com.blog.controller;

import com.blog.model.Blog;
import com.blog.model.BlogForm;
import com.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping({"/blog","/home"})
public class BlogController {
    @Value("${file-upload}")
    private String uploadFolder;
//    @Qualifier("studentServiceImpl")
    @Autowired
    private IBlogService blogService;


    @RequestMapping(value = "/list",
                    method = RequestMethod.GET)
//                    consumes = "text/html",
//                    produces = "text/html")
    public ModelAndView showBlogList(Model model){
        model.addAttribute("blog",new BlogForm());
        return new ModelAndView("blog",
                "BlogList", blogService.findAll());
    }

    @PostMapping("/list")
    public ModelAndView showStudentList1(Model model){
        model.addAttribute("blog",new BlogForm());
        return new ModelAndView("blog",
                "BlogList", blogService.findAll());
    }

    @GetMapping("/create")
    public String showCreatePage(Model model){

        model.addAttribute("blog", new BlogForm());
        return "create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute BlogForm blog,
                                RedirectAttributes redirectAttributes){
        MultipartFile file=blog.getImage();
        String fileName=file.getOriginalFilename();
        try{
            FileCopyUtils.copy(file.getBytes(),new File(uploadFolder+fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Blog insertBlog=new Blog();
        insertBlog.setAuthor(blog.getAuthor());
        insertBlog.setBody(blog.getBody());
        insertBlog.setCreateTime(LocalDate.now().toString());
        insertBlog.setImage(fileName);
        blogService.save(insertBlog);
        redirectAttributes.addFlashAttribute("message",
                "Create blog: " + " OK!");
//        return "forward:/blog/list";
        return "redirect:/blog/list";
    }

//    @GetMapping("/search")
//    public ModelAndView search(@RequestParam("kq") String keyword){
//        return new ModelAndView("blog", "BlogList", blogService.searchByName(keyword));
//    }
    @GetMapping("/delete")
    public  String deleteBlog(@RequestParam("id") int id,RedirectAttributes redirectAttributes){
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("message",
                "Delete blog: " + " OK!");
//        return "forward:/blog/list";
        return "redirect:/blog/list";
    }
    @GetMapping("/edit/{id}")
    public String showeditBlog(@PathVariable("id") int id,RedirectAttributes redirectAttributes,Model model){
        Optional<Blog> blog= blogService.findById(id);
        model.addAttribute("blog",blog.get());
        model.addAttribute("BlogList", blogService.findAll());
        redirectAttributes.addFlashAttribute("message","Edit blog. Please!");

        return "blog";
    }
    @GetMapping("/list/detail/{id}")
    public String viewDetail(@PathVariable("id") int id,Model model,RedirectAttributes redirectAttributes){
        model.addAttribute("blog",blogService.findById(id));
        model.addAttribute("popup",1);
        redirectAttributes.addFlashAttribute("message","Detail blog!");
        return "redirect:/blog/list";
    }
}
