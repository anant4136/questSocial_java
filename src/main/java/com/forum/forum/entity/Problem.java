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
@Table(name="Problems")
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long problemId ;
    @Column(length = 1000)
    private String title;
    @Column(length = 3000)
    private String description;
    private String imageUrl1;
    private String imageUrl2;
    private boolean answered = false;
    private Long likes = 0L;
    private Long dislikes = 0L;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "creator_id")
    private User creator;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Solution> answers;



}