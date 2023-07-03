package com.jovscv.springdatajpaexercise.dto;

public record ContactDto(
        Long id,
        String mobile,
        String home,
        String type

) {
}
