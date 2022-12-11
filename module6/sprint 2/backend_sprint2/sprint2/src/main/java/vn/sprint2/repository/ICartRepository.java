package vn.sprint2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.sprint2.dto.CartItemResponse;
import vn.sprint2.model.Cart;
import vn.sprint2.model.CartItem;
import vn.sprint2.model.Customer;

import java.util.Optional;


@Repository
public interface ICartRepository extends JpaRepository<Cart,Long>{
    @Query(value = "select * from cart c join cart_item ci on c.id=ci.cart_id join book b on ci.book_id=b.id where c.id=1;",nativeQuery = true)
    Optional<Cart> findById(Long id);
}
