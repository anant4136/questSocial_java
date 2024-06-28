package com.forum.forum.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
    private String name;
    @Column(length = 3000)
    private String description;
    private String location;
    private int no_of_employees;
    private String companyImageUrl;
    @OneToMany(mappedBy = "company",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.ALL})
    @JsonIgnore
    private List<User> users;


}