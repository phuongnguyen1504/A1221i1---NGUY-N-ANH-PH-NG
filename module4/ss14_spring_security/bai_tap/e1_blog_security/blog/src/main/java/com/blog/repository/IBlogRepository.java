package com.blog.repository;

import com.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog b join category c on b.category_id=c.category_id where c.category_id like ?1",nativeQuery = true)
    List<Blog> findAllByCategory(String category);
    @Query(value = "select * from blog b join category c on b.category_id=c.category_id where b.author like ?1 or b.body like ?1",nativeQuery = true)
    List<Blog> findAllByKey(String key);

//    List<Blog> findByName(String name);
//    List<Blog> findByNameContaining(String name);
    /*Tìm tương đối theo tên và id lớn hơn 2*/
//    List<Blog> findByNameContainingAndIdGreaterThan(String name, int id);

//    @Query(value = "select * from Blog where author=:keyword", nativeQuery = true)
//    List<Blog> searchByName(@Param("keyword") String keyword);
}
