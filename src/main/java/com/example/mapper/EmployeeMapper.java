package com.example.mapper;

import com.example.dto.request.EmployeeRequest;
import com.example.dto.response.EmployeeResponse;
import com.example.entity.EmployeeEntity;
import org.mapstruct.Mapper;

/**
 * @author Suxrob Sattorov, Thu 9:19 AM. 8/18/2022
 */
@Mapper( componentModel = "spring" )
public interface EmployeeMapper {

    EmployeeEntity toEntity( EmployeeRequest request );

    EmployeeResponse toResponse( EmployeeEntity entity );
}
