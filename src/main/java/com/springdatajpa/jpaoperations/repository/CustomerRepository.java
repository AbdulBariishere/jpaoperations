package com.springdatajpa.jpaoperations.repository;

import com.springdatajpa.jpaoperations.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    public List<Customer> findByAddress(String Address);
    public List<Customer> findByName(String Name);
    public int countByAddress(String Address);
    @Transactional
    public void deleteByName(String Name);
    @Transactional
    public void deleteByNameAndAddress(String Name,String Address);


}
