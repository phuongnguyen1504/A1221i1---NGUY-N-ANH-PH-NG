package com.blog.controller;

import com.blog.model.Blog;
import com.blog.model.BlogForm;
import com.blog.model.Category;
import com.blog.service.IBlogService;
import com.blog.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping({"/blog","/home"})
public class BlogController {
    @Value("${file-upload}")
    private String uploadFolder;
//    @Qualifier("studentServiceImpl")
    @Autowired
    private IBlogService blogService;
    @Autowired
    private CategoryService categoryService;
    @RequestMapping(value = "/list",
                    method = RequestMethod.GET)
//                    consumes = "text/html",
//                    produces = "text/html")
    public ModelAndView showBlogList(@PageableDefault(value = 2)Pageable pageable){
//        model.addAttribute("blog",new BlogForm());
        ModelAndView modelAndView=new ModelAndView("blog");
        modelAndView.addObject("blog",new BlogForm());
        modelAndView.addObject("category",categoryService.findAll());
        modelAndView.addObject("BlogList", blogService.findAll(pageable));
        return modelAndView;
    }

    @PostMapping("/list")
    public ModelAndView showStudentList1(Model model,@PageableDefault(value = 2) Pageable pageable){
        model.addAttribute("blog",new BlogForm());
        return new ModelAndView("blog",
                "BlogList", blogService.findAll(pageable));
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage(){
        ModelAndView model=new ModelAndView("create");
        model.addObject("blog", new BlogForm());
        model.addObject("popup",3);
        model.addObject("category",categoryService.findAll());
        return model;
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
        Category category=categoryService.findById(blog.getCategory_id()).get();
        insertBlog.setCategory(category);
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
    public  String deleteBlog(@RequestParam("id") int id,RedirectAttributes redirectAttributes) throws IOException {
        Blog blog=blogService.findById(id).get();
        if (blog!=null){
            blogService.delete(id);
            Files.deleteIfExists(Path.of(uploadFolder + blog.getImage()));
        }



        redirectAttributes.addFlashAttribute("message",
                "Delete blog: " + " OK!");
//        return "forward:/blog/list";
        return "redirect:/blog/list";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showeditBlog(@PathVariable("id") int id,RedirectAttributes redirectAttributes,@PageableDefault(value = 2)Pageable pageable){
        ModelAndView model=new ModelAndView("blog");
        model.addObject("blog",blogService.findById(id).get());
        model.addObject("popup",2);
        model.addObject("BlogList", blogService.findAll(pageable));
        redirectAttributes.addFlashAttribute("message","Edit blog. Please!");

        return model;
    }
    @GetMapping("/list/detail/{id}")
    public ModelAndView viewDetail(@PathVariable("id") int id,@PageableDefault(value = 2)Pageable p){
        ModelAndView modelAndView=new ModelAndView("blog");
        modelAndView.addObject("blog",blogService.findById(id).get());
        modelAndView.addObject("popup",1);
        modelAndView.addObject("BlogList", blogService.findAll(p));
//        redirectAttributes.addFlashAttribute("message","Detail blog!");
        return modelAndView;
    }
}
