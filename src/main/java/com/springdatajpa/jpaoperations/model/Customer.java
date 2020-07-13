package com.springdatajpa.jpaoperations.model;

import com.springdatajpa.jpaoperations.controller.EmployeeController;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table
@Entity
public class Customer {
    @Id
    @GeneratedValue
    public int id;
    public String name;
    public String address;
    public String pincode;
}
