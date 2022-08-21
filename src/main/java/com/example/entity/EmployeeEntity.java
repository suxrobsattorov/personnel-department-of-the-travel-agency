package com.example.entity;

import com.example.enums.Gender;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Suxrob Sattorov, Thu 9:15 AM. 8/18/2022
 */
@Data
@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;
    private String name;
    private String surname;
    private String birthdate;
    @Column( unique = true )
    private String email;
    @Enumerated( EnumType.STRING )
    private Gender gender;
    private Boolean isDeleted = false;
    private LocalDateTime createdAt = LocalDateTime.now();
}
