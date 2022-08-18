package com.blog.controller.RestfullWebService;

import com.blog.model.Blog;
import com.blog.model.Category;
import com.blog.service.IBlogService;
import com.blog.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private CategoryService categoryService;
    //    show list category
    @GetMapping("/category")
    public ResponseEntity<Iterable<Category>> findAllCategory(){
        List<Category> categories= (List<Category>) categoryService.findAll();
        if (categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }
    //    Xem danh sach cac bai viet
    @GetMapping("/blog")
    public ResponseEntity<Iterable<Blog>> findAllBlog(){
        List<Blog> blogs=blogService.findAll();
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
    //Xem danh sách các bài viết của một category
    @GetMapping("/blog/show")
    public ResponseEntity<Iterable<Blog>> showAllBlogByCategory(@RequestParam("category") String category){
        List<Blog> blogs=blogService.findAllByCategory(category);
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    // Xem chi tiet 1 bai viet
    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable int id){
        Optional<Blog> blogOptional=blogService.findById(id);
        if (!blogOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogOptional.get(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog){
        blogService.save(blog);
        return new ResponseEntity<>(blog,HttpStatus.CREATED);
    }

}