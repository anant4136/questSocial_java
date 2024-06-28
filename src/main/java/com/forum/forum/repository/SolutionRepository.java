package com.forum.forum.repository;

import com.forum.forum.entity.Problem;
import com.forum.forum.entity.Solution;
import com.forum.forum.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolutionRepository extends JpaRepository<Solution,Long> {
    public Solution findByTitle(String title);

    List<Solution> findBySolver(User user);

    List<Solution> findByQuestion(Problem problem);

}
