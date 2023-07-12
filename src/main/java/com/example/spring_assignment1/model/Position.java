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
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"positionId", "name"})
@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Long positionId;

    @NotBlank(message = "This field is required!")
    @Column(length = 70, unique = true, nullable = false)
    private String name;

    @CreationTimestamp
    private LocalDate createDate;

    @UpdateTimestamp
    private LocalDate updateDate;

    @OneToMany(mappedBy = "position", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<User> users;

    @ManyToMany(mappedBy = "positions")
    private Set<Department> departments;
}