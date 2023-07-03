package com.jovscv.springdatajpaexercise.repository;

import com.jovscv.springdatajpaexercise.model.Address;
import com.jovscv.springdatajpaexercise.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("UPDATE Address a SET a.houseNumber = :#{#address.houseNumber}, a.streetName = :#{#address.streetName}, " +
            "a.city = :#{#address.city}, a.country = :#{#address.country}, a.postalCode = :#{#address.postalCode}, " +
            "a.type = :#{#address.type} WHERE a.employee.id = :employeeId")
    void updateAddressByEmployeeId(@Param("employeeId") Long employeeId, @Param("address") Address address);

    default void createOrUpdateAddressByEmployeeId(Long employeeId, Address address) {
        if (address.getId() == null) {
            address.setEmployee(new Employee(employeeId));
            save(address);
        } else {
            updateAddressByEmployeeId(employeeId, address);
        }
    }
}
