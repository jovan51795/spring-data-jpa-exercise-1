package com.jovscv.springdatajpaexercise.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> address = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Contact> contact = new ArrayList<>();

    public Employee(Long employeeId) {
        this.id = employeeId;
    }
}
