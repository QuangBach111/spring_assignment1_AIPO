package com.example.spring_assignment1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login_name", length = 50, nullable = false, unique = true)
    private String loginName;

    @Column(name = "password_value", length = 50, nullable = false, unique = true)
    private String passwordValue;
    @Column(name = "first_name", length = 50, nullable = false, unique = true)
    private String firstName;
    @Column(name = "last_name", length = 50, nullable = false, unique = true)
    private String lastName;
    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;
    @UpdateTimestamp
    private LocalDate modified;
    @CreationTimestamp
    private LocalDate created;
    @Column(name = "last_login")
    @CreationTimestamp
    private LocalDate lastLogin;
    private Boolean disable;
    @Column(name = "photo_url")
    private String photoUrl;
    @Column(name = "create_user_id")
    private Long createUserId;
    @Column(name = "update_user_id")
    private Long updateUserId;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "position_id")
    private Position position;
}