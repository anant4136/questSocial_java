package com.forum.forum.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Solutions")
public class Solution{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long solutionId ;
    @Column(length = 1000)
    private String title;
    @Column(length = 3000)
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "solver_id")
    private User solver;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    private Problem question;
}