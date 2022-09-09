package com.furama.repository.Customer;

import com.furama.model.Customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
//    @Query(value = "SELECT * FROM customer c join customer_type ct on c.customer_type_id=ct.customer_type_id WHERE is_delete=false",
//            countQuery = "SELECT count(*) FROM customer c join customer_type ct on c.customer_type_id=ct.customer_type_id WHERE is_delete=false",
//            nativeQuery = true)
    Page<Customer> findAll(Pageable pageable);
//    @Query(value = "SELECT * FROM customer c join customer_type ct on c.customer_type_id=ct.customer_type_id WHERE is_delete=false and c.name like ?1",
//            countQuery = "SELECT count(*) FROM customer c join customer_type ct on c.customer_type_id=ct.customer_type_id WHERE is_delete=false and c.name like ?1",
//            nativeQuery = true)
    Page<Customer> findByNameContaining(String name, Pageable pageable);
//    @Query(value = "SELECT * FROM customer WHERE is_delete=false and birthday like ?1",
//            countQuery = "SELECT count(*) FROM customer WHERE is_delete=false and birthday like ?1",
//            nativeQuery = true)

    Page<Customer> findByBirthdayContaining(String searchVal, Pageable pageable);

    Page<Customer> findByGender(String searchVal, Pageable pageable);

//    @Query(value = "select * from customer where id_card like ?1",
//            countQuery = "select count(*) from customer where id_card like ?1", nativeQuery = true)
//    Page<Customer> findByIdCardContaining(String val, Pageable pageable);

    Page<Customer> findByIdcardContaining(String searchVal, Pageable pageable);
    Page<Customer> findByPhoneContaining(String searchVal, Pageable pageable);

    Page<Customer> findByMailContaining(String searchVal, Pageable pageable);

    Page<Customer> findByAddressContaining(String searchVal, Pageable pageable);

    @Query(value = "select c.* from customer c\n" +
            " join customertype ct on c.customer_type_id=ct.customer_type_id\n" +
            " where c.name like ?1 or c.birthday like ?1 or c.genger like ?1 or c.id_card like ?1 or c.phone like ?1 or c.mail like ?1 or c.address like ?1",
            countQuery = "select c.* from customer c\n" +
                    " join customertype ct on c.customer_type_id=ct.customer_type_id\n" +
                    " where c.name like ?1 or c.birthday like ?1 or c.genger like ?1 or c.id_card like ?1 or c.phone like ?1 or c.mail like ?1 or c.address like ?1", nativeQuery = true)
    Page<Customer> findAllByValue(String concat, Pageable pageable);
@Query(value = "delete from customer where customer_id=?1",nativeQuery = true)
    void deleteById(String id);
}