package vn.sprint2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookCartId implements Serializable {
    @Column(name="book_id")
    private Long bookId;
    @Column(name = "cart_id")
    private Long cartId;
}
