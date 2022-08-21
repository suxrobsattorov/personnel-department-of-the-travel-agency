package com.example.service.impl;

import com.example.dto.request.EmployeeEditRequest;
import com.example.dto.request.EmployeeRequest;
import com.example.dto.response.EmployeeResponse;
import com.example.entity.EmployeeEntity;
import com.example.mapper.EmployeeMapper;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * @author Suxrob Sattorov, Thu 9:30 AM. 8/18/2022
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeResponse save( EmployeeRequest request ) {
        return employeeMapper.toResponse(
                employeeRepository.save(employeeMapper.toEntity(request))
        );
    }

    @Override
    public EmployeeResponse edit( EmployeeEditRequest editRequest ) {

        EmployeeEntity entity = get(editRequest.getId());

        if ( !entity.getName().equals(editRequest.getName()) && editRequest.getName() != null )
            entity.setName(editRequest.getName());

        if ( !entity.getSurname().equals(editRequest.getSurname()) && editRequest.getSurname() != null )
            entity.setSurname(editRequest.getSurname());

        if ( !entity.getBirthdate().equals(editRequest.getBirthdate()) && editRequest.getBirthdate() != null )
            entity.setBirthdate(editRequest.getBirthdate());

        if ( !entity.getEmail().equals(editRequest.getEmail()) && editRequest.getEmail() != null )
            entity.setEmail(editRequest.getEmail());

        if ( !entity.getGender().equals(editRequest.getGender()) && editRequest.getGender() != null )
            entity.setGender(editRequest.getGender());

        return employeeMapper.toResponse(employeeRepository.save(entity));
    }

    @Override
    public EmployeeResponse getById( Long id ) {
        return employeeMapper.toResponse(get(id));
    }

    @Override
    public Collection<EmployeeResponse> getAll() {
        return employeeRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse delete( Long id ) {
        EmployeeEntity entity = get(id);
        entity.setIsDeleted(true);
        return employeeMapper.toResponse(entity);
    }

    public EmployeeResponse toDto( EmployeeEntity employee ) {
        return employeeMapper.toResponse(employee);
    }

    public EmployeeEntity get( Long id ) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }
}


