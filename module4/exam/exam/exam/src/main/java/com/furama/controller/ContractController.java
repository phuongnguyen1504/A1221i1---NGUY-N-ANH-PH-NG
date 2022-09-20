package com.furama.controller;


import com.furama.model.Contract.Contract;
import com.furama.model.Contract.ContractDto;
import com.furama.model.Contract.Room;
import com.furama.service.Contract.ContractServiceImpl;
import com.furama.service.Contract.RoomServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/customer")
//@SessionAttributes("customer")
public class ContractController {
    @Autowired
    private ContractServiceImpl contractService;
    @Autowired
    private RoomServiceImpl roomService;

    @GetMapping("/contract")
    public String view(Model model, ContractDto contractDto, BindingResult bindingResult) {
        model.addAttribute("res", contractService.findAll());
        model.addAttribute("cate", roomService.findAll());
        model.addAttribute("customer", contractDto);
        model.addAttribute("isError", bindingResult.hasErrors());
        return "contract";
    }

    @PostMapping("/contract")
    public String save(@Validated @ModelAttribute ContractDto contractDto, BindingResult bindingResult, RedirectAttributes redirect, Model model){
//        new ContractDto().validate(customerDto,bindingResult);

        if(bindingResult.hasErrors()){
            model.addAttribute("res", contractService.findAll());
            model.addAttribute("cate", roomService.findAll());
            model.addAttribute("customer", contractDto);
            model.addAttribute("isError", bindingResult.hasErrors());
            return "contract";
        }
        Contract customer1=new Contract();
        BeanUtils.copyProperties(contractDto,customer1);

        customer1.setDateContract(contractDto.getDateContract().toString());
        Room room=new Room();
        int cmnd= Integer.parseInt(contractDto.getCmnd());
        customer1.setCmnd(cmnd);
        room= roomService.findById(contractDto.getRoomcode()).get();
        customer1.setRoom(room);

        contractService.save(customer1);
        redirect.addFlashAttribute("msg","Create/Update Succesfully");

        return "redirect:/contract";
    }
    @GetMapping("/contract/delete")
    public String delete(@RequestParam("id") String id,RedirectAttributes redirect){
        System.out.println(id);
        contractService.delete(id);
        redirect.addFlashAttribute("msg","Delete Succesfully");
        return "redirect:/delete";
    }
//    @DeleteMapping("/contract/{id}")
//    public ResponseEntity<String> delete(@PathVariable String id,RedirectAttributes redirect){
//        System.out.println(id);
//        Optional<Contract> contract= contractService.findById(id);
//        if (!contract.isPresent()){
//            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        }
//        contractService.delete(id);
//        redirect.addFlashAttribute("msg","Delete Succesfully");
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//    @GetMapping("/contract/edit/{id}")
//    public ResponseEntity<Contract> findContract(@PathVariable String id){
//        Optional<Contract> contract= contractService.findById(id);
//        if (!contract.isPresent()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        System.out.println(contract.get());
//        return new ResponseEntity<>(contract.get(),HttpStatus.OK);
//    }
}
