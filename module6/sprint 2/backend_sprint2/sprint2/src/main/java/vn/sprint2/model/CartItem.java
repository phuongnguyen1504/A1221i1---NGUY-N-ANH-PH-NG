package vn.sprint2.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
@Data
public class CartItem {
    @EmbeddedId
    private BookCartId bookCartId;
    @ManyToOne
    @MapsId("bookId")
    @JsonBackReference
    private Book book;
    @ManyToOne
    @MapsId("cartId")
    @JsonBackReference
    private Cart cart;
    private Integer quantity;

}
