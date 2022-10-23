package com.thi_md5_be.controller;



import com.thi_md5_be.model.Category;
import com.thi_md5_be.model.Product;
import com.thi_md5_be.service.CategoryService;
import com.thi_md5_be.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/product")
    public ResponseEntity<Iterable<Product>> findAllProduct(){
        List<Product> products=productService.findAll();
        if(products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
    @GetMapping("/product/search")
    public ResponseEntity<Iterable<Product>> findAllProduct(@RequestParam(name = "q",required = false,defaultValue = "")String q){
            List<Product> products=productService.find(q);
            if(products.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products,HttpStatus.OK);
        }

//    @GetMapping("/product/search")
//    public ResponseEntity<Iterable<Product>> findAllProduct(@RequestParam(name = "page",required = false,defaultValue = "0")Integer page,
//                                                            @RequestParam(name = "q",required = false,defaultValue = "")String q,
//                                                            @RequestParam(name = "size",required = false,defaultValue = "2")Integer size,
//                                                            @RequestParam(name="sortby",required = false,defaultValue = "id")String sortBy,
//                                                            @RequestParam(name = "sortdir",required = false,defaultValue = "ASC")String sortDir){
//        if (q!=null){
//            List<Product> products=productService.findAll();
//            if(products.isEmpty()){
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(products,HttpStatus.OK);
//        }
//        else{
//            Sort sortable=null;
//            sortable=sortDir.equals("ASC")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
//            Pageable pageable= PageRequest.of(page,size,sortable);
//            Page<Product> products=productService.find(q,pageable);
//            System.out.println("Product"+products);
//            System.out.println("pageable"+pageable);
//            if (products.isEmpty()){
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(products,HttpStatus.OK);
//        }
//
//    }

    @GetMapping("/category")
    public ResponseEntity<Iterable<Category>> findAllCategory(){
        List<Category> categories=categoryService.findAll();
        if(categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable int id){
        Optional<Product> product=productService.findById(id);
        if (!product.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product.get(),HttpStatus.OK);
    }
    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        productService.save(product);
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity <Product> delete(@PathVariable("id") int id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/product/{id}")
    public ResponseEntity<Product> update(@PathVariable int id,@RequestBody Product product){
        productService.update(id,product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
