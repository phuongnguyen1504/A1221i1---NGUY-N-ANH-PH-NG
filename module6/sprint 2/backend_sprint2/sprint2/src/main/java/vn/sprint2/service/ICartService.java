package vn.sprint2.service;

import org.springframework.data.domain.Page;
import vn.sprint2.dto.CartItemResponse;
import vn.sprint2.model.Cart;
import vn.sprint2.model.CartItem;
import vn.sprint2.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICartService {
    Optional<Cart> findById(Long id);


}
