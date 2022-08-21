package com.example.repository;

import com.example.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Suxrob Sattorov, Thu 9:21 AM. 8/18/2022
 */
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
