package com.example.dto.request;

import com.example.enums.Gender;
import lombok.Data;

/**
 * @author Suxrob Sattorov, Thu 9:05 AM. 8/18/2022
 */
@Data
public class EmployeeRequest {
    private String name;
    private String surname;
    private String birthdate;
    private String email;
    private Gender gender;
}
