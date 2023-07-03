package com.jovscv.springdatajpaexercise.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jovscv.springdatajpaexercise.dto.EmployeeDto;
import com.jovscv.springdatajpaexercise.model.Address;
import com.jovscv.springdatajpaexercise.model.Employee;
import com.jovscv.springdatajpaexercise.projection.AddressMobileCountProjection;
import com.jovscv.springdatajpaexercise.repository.EmployeeRepository;
import com.jovscv.springdatajpaexercise.service.AppService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MainController {
    private final AppService service;
    private final EmployeeRepository employeeRepository;

    @PostMapping
    public String createEmployee(@RequestBody Employee employee) throws JsonProcessingException {
        return service.createEmployee(employee);
    }

    @GetMapping
    public Employee getEmployeeAddressByFirstnameAndLastname(@RequestBody EmployeeDto emp) {
        return service.getEmployeeAddressByFirstnameAndLastname(emp.firstName(), emp.lastName());
    }

    @GetMapping("/all")
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public AddressMobileCountProjection getAddressAndMobileCountByEmployeeId(@PathVariable("id") Long id) {
        return service.getAddressAndMobileCountByEmployeeId(id);
    }

    @PatchMapping("/{id}")
    public String updateAddressByEmployeeId(@PathVariable("id") Long id, @RequestBody Address address) {
        return service.updateAddressByEmployeeId(id, address);
    }

}
