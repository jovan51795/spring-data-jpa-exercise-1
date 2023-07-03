package com.jovscv.springdatajpaexercise.repository;

import com.jovscv.springdatajpaexercise.model.Employee;
import com.jovscv.springdatajpaexercise.projection.AddressMobileCountProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

   @Query("SELECT e FROM Employee e JOIN FETCH e.address a WHERE e.firstName = ?1 AND e.lastName = ?2")
    Optional<Employee> findEmployeeWithAddressByFullName(String firstName, String lastName);

    @Query(value = "SELECT COUNT(*) as addressCount, " +
            "(SELECT COUNT(*) FROM Contact c WHERE c.employee_id = ?1 AND c.type = 'Mobile') as mobileCount " +
            "FROM Address a WHERE a.employee_id = ?1", nativeQuery = true)
    AddressMobileCountProjection getAddressAndMobileCountByEmployeeId(Long employeeId);
}
