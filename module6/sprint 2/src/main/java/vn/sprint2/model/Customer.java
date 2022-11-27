package vn.sprint2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date birthday;
    private String email;
    private boolean gender;
    private String img_url;
    private String phone;
    private String address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="account")
    private Account account;
    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Cart> carts;



}
