package vn.sprint2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import vn.sprint2.dto.CartItemResponse;
import vn.sprint2.model.Cart;
import vn.sprint2.model.CartItem;
import vn.sprint2.model.Customer;
import vn.sprint2.service.ICartService;
import vn.sprint2.service.ICustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/cart")
public class CartController {
    @Autowired
    private ICartService cartService;
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/{username}")
    public ResponseEntity<Cart> findBookById(@PathVariable("username") String username){
        Customer customer=this.customerService.findByUsername(username);
        Optional<Cart> cartItem=cartService.findById(customer.getId());
        if(!cartItem.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cartItem.get(),HttpStatus.OK);
    }

}
