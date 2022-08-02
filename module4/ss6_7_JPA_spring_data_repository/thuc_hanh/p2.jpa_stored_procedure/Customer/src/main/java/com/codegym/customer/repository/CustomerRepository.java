package com.codegym.customer.repository;

import com.codegym.customer.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CustomerRepository implements ICustomerRepository{
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query=em.createQuery("select c from Customer c",Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        TypedQuery<Customer> query=em.createQuery("select c from Customer c where c.id=:id",Customer.class);
        return query.getSingleResult();
    }

    @Override
    public void save(Customer customer) {
        if(customer.getId()!=null){
            em.merge(customer);
        }
        else {
            em.persist(customer);
        }
    }

    @Override
    public void remove(Long id) {
        Customer customer=findById(id);
        if(customer!=null){
            em.remove(customer);
        }

    }

    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
        String sql="call insert_Customer(:firstName,:lastName)";
        Query query= em.createNativeQuery(sql);
        query.setParameter("firstName",customer.getFirstName());
        query.setParameter("lastName",customer.getLastName());
        return query.executeUpdate()==0;
    }
}
