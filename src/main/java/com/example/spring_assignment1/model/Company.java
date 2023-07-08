package com.example.spring_assignment1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 70, nullable = false)
    private String name;
    @Column(length = 10, nullable = false)
    private String telephone;
    @Column(name = "create_date")
    @CreationTimestamp
    private LocalDate createDate;
    @Column(name = "update_date")
    @UpdateTimestamp
    private LocalDate updateDate;
    @OneToMany(mappedBy = "company")
    private Set<User> users;
}