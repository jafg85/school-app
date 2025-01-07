package com.school_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "teachers", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name cannot be blank")
    @Size(max = 50, message = "First name cannot be longer than 50 characters")
    @Column(nullable = false, length = 50)
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(max = 50, message = "Last name cannot be longer than 50 characters")
    @Column(nullable = false, length = 50)
    private String lastName;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email must be valid")
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "^[+]?[0-9]{10,15}$", message = "Phone number must be valid")
    @Column(nullable = false, length = 15)
    private String phone;

    @NotNull(message = "Hire date cannot be null")
    @PastOrPresent(message = "Hire date must be in the past or present")
    @Column(nullable = false)
    private LocalDate hireDate;

    @NotNull(message = "Salary cannot be null")
    @PositiveOrZero(message = "Salary must be a positive number or zero")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal salary;

    @NotNull(message = "Status cannot be null")
    @Column(nullable = false)
    private Boolean isActive = true;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}