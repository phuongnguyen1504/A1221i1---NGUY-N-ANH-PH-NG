package com.phone.controller;

import com.phone.model.Smartphone;
import com.phone.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;
    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhones(){
        return new ResponseEntity<>(smartphoneService.findAll(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Smartphone> createSmartPhone(@RequestBody Smartphone smartphone){
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Smartphone> updateSmartPhone(@RequestBody Smartphone smartphone){
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public ModelAndView getAllSmartPhonePages(){
        ModelAndView modelAndView=new ModelAndView("/list");
        modelAndView.addObject("smartphones",smartphoneService.findAll());
        return modelAndView;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id){
        Optional<Smartphone> smartphone=smartphoneService.findById(id);
        if (!smartphone.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphone.get(),HttpStatus.NO_CONTENT);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Smartphone> findSmartPhone(@PathVariable Long id){
        Optional<Smartphone> smartphone=smartphoneService.findById(id);
        if (!smartphone.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(smartphone.get(),HttpStatus.OK);
    }
}
