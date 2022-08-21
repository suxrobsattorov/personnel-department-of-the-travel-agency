package com.example.dto.response;

import com.example.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Suxrob Sattorov, Thu 9:08 AM. 8/18/2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {
    private Long id;
    private String name;
    private String surname;
    private String birthdate;
    private String email;
    private Gender gender;
    private LocalDateTime createdAt;
}
