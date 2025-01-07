package com.example.schoolapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "subjects", uniqueConstraints = {
        @UniqueConstraint(columnNames = "code")
})
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Subject name cannot be blank")
    @Size(max = 100, message = "Subject name cannot be longer than 100 characters")
    @Column(nullable = false, length = 100)
    private String name;

    @NotBlank(message = "Subject code cannot be blank")
    @Pattern(regexp = "^[A-Z]{3}\\d{3}$", message = "Subject code must follow the pattern: 3 uppercase letters followed by 3 digits (e.g., MAT101)")
    @Column(nullable = false, unique = true, length = 6)
    private String code;

    @NotNull(message = "Credits cannot be null")
    @Positive(message = "Credits must be a positive number")
    @Column(nullable = false)
    private Integer credits;

    @Size(max = 500, message = "Description cannot be longer than 500 characters")
    @Column(length = 500)
    private String description;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}