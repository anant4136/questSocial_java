package com.forum.forum.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name="Users")
@Table(name="Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private int phone;
    private int score;
    private String imageUrl;


    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;

    private boolean enabled = true;
    private boolean admin = false;

    @OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Problem> createdProblems;

    @OneToMany(mappedBy = "solver", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Solution> createdSolutions;

    @OneToMany(mappedBy = "sender" , fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Message> sentMessages;

    @OneToMany(mappedBy = "receiver" , fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Message> receivedMessages;

    @Override
    public String getPassword(){return password;}
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
