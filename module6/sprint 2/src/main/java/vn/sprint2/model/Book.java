package vn.sprint2.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "book")
@Data
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    @Column(name = "year_publish")
    private Date yearPublish;
    private String img_url;
    private Double price;
    private Integer amount;
    private String publisher;
    private String language;
    @Column(name = "number_rating")
    private Integer numberRating;
    @Column(name = "total_pages")
    private Integer totalPages;
    private Double weight;
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    @JsonBackReference
    private Category category;
    @Column(columnDefinition = "TEXT")
    private String description;
    @OneToMany(mappedBy = "book")
    private List<CartItem> carts;

}
