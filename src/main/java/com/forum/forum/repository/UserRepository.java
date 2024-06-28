package com.forum.forum.repository;

import com.forum.forum.entity.Company;
import com.forum.forum.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public User findByUsername(String username);

    public List<User> findByCompany(Company company);
}
