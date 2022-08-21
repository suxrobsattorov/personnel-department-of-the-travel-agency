package com.example.service;

import com.example.dto.request.EmployeeEditRequest;
import com.example.dto.request.EmployeeRequest;
import com.example.dto.response.EmployeeResponse;
import com.example.repository.EmployeeRepository;

import java.util.Collection;

/**
 * @author Suxrob Sattorov, Thu 9:22 AM. 8/18/2022
 */
public interface EmployeeService {

    EmployeeResponse save( EmployeeRequest request );

    EmployeeResponse edit( EmployeeEditRequest editRequest );

    EmployeeResponse getById( Long id );

    Collection<EmployeeResponse> getAll();

    EmployeeResponse delete( Long id );
}
