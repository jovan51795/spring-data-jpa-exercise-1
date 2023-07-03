package com.jovscv.springdatajpaexercise.dto;

public record AddressDto(
        Long id,
        String houseNumber,
        String streetName,
        String city,
        String country,
        String postalCode,
        String type,
        EmployeeDto employee
) {
}
