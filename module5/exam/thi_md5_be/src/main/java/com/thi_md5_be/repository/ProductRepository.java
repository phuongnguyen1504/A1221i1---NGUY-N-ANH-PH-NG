package com.thi_md5_be.repository;

import com.thi_md5_be.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "select p.* from product p\n"+
    " join category c on c.category_id=p.category_id\n"+
    " where concat(p.date_in,' ',p.date_out,' ',p.end_date,' ',p.start_date,' ',p.mail,' ',p.name_station,' ',p.phone,' ',p.type,' ',c.name) like ?1 ",
    countQuery ="select c.* from product p\n"+
            " join category c on c.category_id=p.category_id\n"+
            " where concat(p.date_in,' ',p.date_out,' ',p.end_date,' ',p.start_date,' ',p.mail,' ',p.name_station,' ',p.phone,' ',p.type,' ',c.name) like ?1 ",nativeQuery = true)
    Page<Product> findAllByValue(String concat, Pageable pageable);
}
