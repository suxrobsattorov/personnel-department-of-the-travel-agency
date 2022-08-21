package com.example.dto.request;

import com.example.enums.Gender;
import lombok.Data;

/**
 * @author Suxrob Sattorov, Sun 10:13 AM. 8/21/2022
 */

@Data
public class EmployeeEditRequest {
    private Long id;
    private String name;
    private String surname;
    private String birthdate;
    private String email;
    private Gender gender;
}
