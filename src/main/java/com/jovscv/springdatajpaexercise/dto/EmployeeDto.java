package com.jovscv.springdatajpaexercise.dto;

import com.jovscv.springdatajpaexercise.model.Address;
import com.jovscv.springdatajpaexercise.model.Contact;
import com.jovscv.springdatajpaexercise.model.Employee;


import java.util.List;

public record EmployeeDto(
        Long id,
        String firstName,
        String lastName,
        String middleName,
        List<AddressDto> address,
        List<ContactDto> contact,
        EmployeeDto employee
) {
}
