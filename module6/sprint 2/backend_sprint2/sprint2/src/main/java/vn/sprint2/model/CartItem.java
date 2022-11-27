package vn.sprint2.model;


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
    private Book book;
    @ManyToOne
    @MapsId("cartId")
    private Cart cart;
    private Integer amount;

}
