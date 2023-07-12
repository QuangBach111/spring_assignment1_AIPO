package com.example.spring_assignment1.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"departmentId", "name"})
@EqualsAndHashCode
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long departmentId;

    @NotBlank(message = "This field is required!")
    @Column(length = 70, nullable = false)
    private String name;

    @NotBlank(message = "This field is required!")
    @Column(length = 70, nullable = false)
    private String email;

    @NotBlank(message = "This field is required!")
    @Column(length = 10, nullable = false)
    private String phone;

    @Column(name = "create_date")
    @CreationTimestamp
    private LocalDate createDate;

    @Column(name = "update_date")
    @UpdateTimestamp
    private LocalDate updateDate;

    @OneToMany(mappedBy = "department", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<User> users;

    @ManyToMany
    @JoinTable(name = "department_position",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "position_id"))
    private Set<Position> positions;
}