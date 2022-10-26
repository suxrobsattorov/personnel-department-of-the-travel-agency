package com.example.controller;

import com.example.dto.Response;
import com.example.dto.request.EmployeeEditRequest;
import com.example.dto.request.EmployeeRequest;
import com.example.dto.response.EmployeeResponse;
import com.example.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.*;

/**
 * @author Suxrob Sattorov, Sun 10:42 AM. 8/21/2022
 */

@RestController
@RequestMapping( "/employee" )
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping( "/save" )
    public ResponseEntity<Response> save( @RequestBody EmployeeRequest request ) {
        Map<String, EmployeeResponse> m=new HashMap<>();
        m.put("employee", employeeService.save(request));
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(m)
                        .message("Employee created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping( "/get/{id}" )
    public ResponseEntity<Response> getById( @PathVariable( "id" ) Long id ) {
        Map<String, EmployeeResponse> m=new HashMap<>();
        m.put("employee", employeeService.getById(id));
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(m)
                        .message("Employee retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping( "/get" )
    public ResponseEntity<Response> getAll() {
        Map<String, Collection<EmployeeResponse>> m=new HashMap<>();
        m.put("employees", employeeService.getAll());
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(m)
                        .message("Employees retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PutMapping( "/edit" )
    public ResponseEntity<Response> edit( @RequestBody EmployeeEditRequest editRequest ) {
        Map<String, EmployeeResponse> m=new HashMap<>();
        m.put("employee", employeeService.edit(editRequest));
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(m)
                        .message("Employee edited")
                        .status(NON_AUTHORITATIVE_INFORMATION)
                        .statusCode(NON_AUTHORITATIVE_INFORMATION.value())
                        .build()
        );
    }

    @DeleteMapping( "/delete/{id}" )
    public ResponseEntity<Response> delete( @PathVariable("id") Long id ) {
        Map<String, EmployeeResponse> m=new HashMap<>();
        m.put("employee", employeeService.delete(id));
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(m)
                        .message("Employee deleted")
                        .status(NO_CONTENT)
                        .statusCode(NO_CONTENT.value())
                        .build()
        );
    }
}
