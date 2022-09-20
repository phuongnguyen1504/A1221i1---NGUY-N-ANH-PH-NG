package com.furama.repository.Contract;

import com.furama.model.Contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, String> {
//    @Query(value = "SELECT * FROM customer c join customer_type ct on c.customer_type_id=ct.customer_type_id WHERE is_delete=false",
//            countQuery = "SELECT count(*) FROM customer c join customer_type ct on c.customer_type_id=ct.customer_type_id WHERE is_delete=false",
//            nativeQuery = true)


    //SET foreign_key_checks = 0;
    //DELETE FROM table_name WHERE {conditions};
    //SET foreign_key_checks = 1;

}
