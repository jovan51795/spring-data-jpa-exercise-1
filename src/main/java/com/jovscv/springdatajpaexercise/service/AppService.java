package com.jovscv.springdatajpaexercise.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jovscv.springdatajpaexercise.dto.EmployeeDto;
import com.jovscv.springdatajpaexercise.model.Address;
import com.jovscv.springdatajpaexercise.model.Employee;
import com.jovscv.springdatajpaexercise.projection.AddressMobileCountProjection;
import com.jovscv.springdatajpaexercise.repository.AddressRepository;
import com.jovscv.springdatajpaexercise.repository.ContactRepository;
import com.jovscv.springdatajpaexercise.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppService {

    private final AddressRepository addressRepository;
    private final EmployeeRepository employeeRepository;
    private final ContactRepository contactRepository;
    private final ObjectMapper mapper;

    public String createEmployee(Employee employee) throws JsonProcessingException {
        employeeRepository.save(employee);
        return "success";
    }

    public Employee getEmployeeAddressByFirstnameAndLastname(String firstname, String lastname) {
        return employeeRepository.findEmployeeWithAddressByFullName(firstname, lastname).get();
    }

    public AddressMobileCountProjection getAddressAndMobileCountByEmployeeId(Long id) {
        return employeeRepository.getAddressAndMobileCountByEmployeeId(id);
    }

    public String  updateAddressByEmployeeId(Long employeeId, Address address) {
        addressRepository.updateAddressByEmployeeId(employeeId, address);
        return "success";
    }
}
