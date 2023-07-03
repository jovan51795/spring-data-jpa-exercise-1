package com.jovscv.springdatajpaexercise.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mobile;
    private String home;
    private String type;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;
}
