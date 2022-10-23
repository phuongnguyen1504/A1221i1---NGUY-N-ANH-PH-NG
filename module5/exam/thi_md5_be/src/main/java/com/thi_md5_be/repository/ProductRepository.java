package com.thi_md5_be.repository;

import com.thi_md5_be.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
//    @Query(value = "select p.* from product p\n"+
//    " where concat(p.dest_in,' ',p.dest_out,' ',p.end_date,' ',p.start_date,' ',p.mail,' ',p.name_station,' ',p.phone,' ',p.type) like ?1 ",
//    countQuery ="select p.* from product p\n"+
//            " where concat(p.dest_in,' ',p.dest_out,' ',p.end_date,' ',p.start_date,' ',p.mail,' ',p.name_station,' ',p.phone,' ',p.type) like ?1 ",nativeQuery = true)
//    List<Product> findAllByValue(String concat, Pageable pageable);
    @Query(value = "select p.* from product p\n"+
            " where concat(p.dest_in,' ',p.dest_out,' ',p.end_date,' ',p.start_date,' ',p.mail,' ',p.name_station,' ',p.phone,' ',p.type) like ?1 ",
            countQuery ="select p.* from product p\n"+
                    " where concat(p.dest_in,' ',p.dest_out,' ',p.end_date,' ',p.start_date,' ',p.mail,' ',p.name_station,' ',p.phone,' ',p.type) like ?1 ",nativeQuery = true)
    List<Product> findAllByValue(String concat);
}
