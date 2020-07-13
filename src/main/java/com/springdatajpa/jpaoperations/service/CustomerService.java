package com.springdatajpa.jpaoperations.service;

import com.springdatajpa.jpaoperations.model.Customer;
import com.springdatajpa.jpaoperations.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    Logger logger = LoggerFactory.getLogger(CustomerService.class);
    
    @Autowired
    CustomerRepository customerRepository;

    @PostConstruct
    public void autoInsert(){
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1,"abdul bari","bhopal","462001"));
        customers.add(new Customer(2,"ajay batham","gwalior","486525"));
        customers.add(new Customer(3,"rohindra","panna","462056"));
        customers.add(new Customer(4,"naman","bhopal","462441"));
        customers.add(new Customer(5,"aashish","ranchi","426531"));
        customers.add(new Customer(6,"anas","bhopal","452301"));
        customers.add(new Customer(7,"aamir","bhopal","466001"));
        customers.add(new Customer(8,"ankit","bhopal","469234"));
        customers.add(new Customer(9,"apoorv","bhopal","469653"));
        customerRepository.saveAll(customers);
        logger.info("Data Inserted in Customer Table");
    }

    public List<Customer> getAllCustomer(){

        return customerRepository.findAll();

    }
    public List<Customer> getcustomerByAddress(String address){
        return customerRepository.findByAddress(address);
    }
    public List<Customer> getCustomerByName(String Name){
        return  customerRepository.findByName(Name);
    }
    public int getcountbyAddress(String address){
        return  customerRepository.countByAddress(address);
    }
 public void deletebyName(String name,String address){
        customerRepository.deleteByNameAndAddress(name,address);
 }

 public Page<Customer> getPagination(){
        return customerRepository.findAll(PageRequest.of(0, 3));
 }
}
