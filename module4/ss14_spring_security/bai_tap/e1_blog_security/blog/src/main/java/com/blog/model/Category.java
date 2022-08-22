package com.blog.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer category_id;
    private String name;
    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private Set<Blog> blog;
    public Category() {
    }

    public Set<Blog> getBlog() {
        return blog;
    }

    public void setBlog(Set<Blog> blog) {
        this.blog = blog;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
