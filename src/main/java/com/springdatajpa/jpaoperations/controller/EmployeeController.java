package com.springdatajpa.jpaoperations.controller;

import com.springdatajpa.jpaoperations.model.Customer;
import com.springdatajpa.jpaoperations.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    Logger logger= LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    CustomerService customerService;
    @GetMapping("/getdata")
    public List<Customer> getdatamethod() {
        logger.info("getdatamethod has been called");
        return  customerService.getAllCustomer();
    }

    @GetMapping("/getaddress/{address}")
    public  List<Customer> getcustomerbyaddress(@PathVariable("address")  String address){
        logger.info("getcustomerbyaddress has been called");
        return  customerService.getcustomerByAddress(address);

    }

    @GetMapping("/getname/{name}")
    public List<Customer> getCustomerByName(@PathVariable("name") String name){
        logger.info("getCustomerByName has been called");
        return  customerService.getCustomerByName(name);
    }

    @GetMapping("/getaddressbycount/{address}")
    public  Map getcountbyaddress(@PathVariable("address")  String address){
        logger.info("getcountbyaddress has been called");
        Map map = new HashMap();
        map.put("count",customerService.getcountbyAddress(address));
       return  map;
    }
    @GetMapping("/deletecustomerbyname/{name}/{address}")
    public void deletecustomerbyname(@PathVariable("name")  String name,@PathVariable("address")  String address){
        logger.info("deletecustomerbyname has been called");
        customerService.deletebyName(name,address);
    }
    @GetMapping("/getpagination")
public Page<Customer> getpagination(){
      return   customerService.getPagination();
}
}
