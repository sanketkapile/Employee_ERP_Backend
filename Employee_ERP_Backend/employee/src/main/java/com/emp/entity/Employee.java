package com.emp.entity;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Validated
@Data
public class Employee {

    @Id
    private String empId;

    @Field("Employee_Name")
    @NotNull
    private String empName;

    @Field("Email_Id")
    @NotNull
    @Pattern(
            regexp = "^[A-Za-z0-9]+([._-]?[A-Za-z0-9]+)*@[A-Za-z0-9-]+(\\.[A-Za-z]{2,})+$",
            message = "Email must contain exactly one '@', a '.' after it, no consecutive dots, and no invalid characters"
    )
    private String empEmail;

    @Field("Password")
    @NotNull
    private String empPassword;

    @Field("Role")
    @NotNull
    private String empRole;

    @Field("Salary")
    @NotNull
    @Digits(integer = 10, fraction = 2, message = "Salary must be a number with up to 2 decimal places")
    @Min(value = 0, message = "Salary cannot be negative")
    private Double empSalary;

    @Field("Contact_Number")
    @NotNull
    @Min(value = 1000000000L, message = "Contact number must have at least 10 digits")
    @Max(value = 999999999999999L, message = "Contact number can have up to 15 digits")
    private Long empContactNumber;

    @Field("Department")
    @NotNull(message = "Department name is mandatory")
    private String department;

    @Field("Is_Employed")
    @NotNull
    private boolean isEmployed;

    @CreatedDate
    @Field("Created_At")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Field("Updated_At")
    private LocalDateTime updatedAt;

}
