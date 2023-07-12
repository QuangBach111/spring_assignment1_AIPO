package com.example.spring_assignment1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @NotBlank(message = "This field is required!")
    @Column(name = "login_name", length = 50, nullable = false, unique = true)
    private String loginName;

    @NotBlank(message = "This field is required!")
    @Column(name = "password_value", length = 50, nullable = false)
    private String passwordValue;

    @NotBlank(message = "This field is required!")
    @Column(name = "confirm_password_value", length = 50, nullable = false)
    private String confirmPasswordValue;

    @NotBlank(message = "This field is required!")
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @NotBlank(message = "This field is required!")
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @NotBlank(message = "This field is required!")
    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @NotBlank(message = "This field is required!")
    @Column(name = "phone", length = 10, nullable = false, unique = true)
    private String phone;

    @CreationTimestamp
    @Column(name = "created_date")
    private LocalDate createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    private LocalDate updatedDate;

    @Column(name = "last_login")
    @UpdateTimestamp
    private LocalDate lastLogin;

    private boolean disable;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "department_id")
    private Department department;
}