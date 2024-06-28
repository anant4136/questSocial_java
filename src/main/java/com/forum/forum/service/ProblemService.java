package com.forum.forum.service;

import com.forum.forum.entity.Problem;
import com.forum.forum.entity.User;
import com.forum.forum.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemService {
    @Autowired
    private ProblemRepository problemRepository;
    public Problem createProblem(Problem problem) throws Exception{
//        Problem local = this.problemRepository.findById(problem.getProblemId()).get();

         Problem local = this.problemRepository.save(problem);

        return local;
    }

    public void deleteProblem(Long problemId) {
        this.problemRepository.deleteById(problemId);
    }

    public Problem updateProblem(Problem problem){
        return (Problem)this.problemRepository.save(problem);
    }
    public Problem getProblem(Long problemId) {
        return this.problemRepository.findById(problemId).get();
    }
    public List<Problem> getAllProblem() {
        return this.problemRepository.findAll();
    }

    public List<Problem> getAllUserProblems(User user) {
        return this.problemRepository.findByCreator(user);
    }
}