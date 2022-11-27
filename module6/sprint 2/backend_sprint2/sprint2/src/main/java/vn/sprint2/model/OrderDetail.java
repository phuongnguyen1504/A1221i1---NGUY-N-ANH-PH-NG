package vn.sprint2.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "order_detail")
@Data
public class OrderDetail implements Serializable {
    @EmbeddedId
    private BookOrderId bookOrderId;
    @ManyToOne
    @MapsId("orderId")
    private Order order;
    @ManyToOne
    @MapsId("bookId")
    private Book book;
    private Double price;
    private Integer amount;
}
