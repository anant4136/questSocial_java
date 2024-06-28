package com.forum.forum.repository;

import com.forum.forum.entity.Problem;
import com.forum.forum.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProblemRepository extends JpaRepository<Problem,Long> {
    public Problem findByTitle(String title);

    List<Problem> findByCreator(User user);
}
