package com.forum.forum.service;

import com.forum.forum.entity.Company;
import com.forum.forum.entity.Problem;
import com.forum.forum.entity.Solution;
import com.forum.forum.entity.User;
import com.forum.forum.repository.ProblemRepository;
import com.forum.forum.repository.SolutionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolutionService {
    @Autowired
    private SolutionRepository solutionRepository;
    public Solution createSolution(Solution solution) throws Exception{
//        Solution local = this.solutionRepository.findById(solution.getSolutionId()).get();

        Solution   local = this.solutionRepository.save(solution);

        return local;
    }

    public void deleteSolution(Long solutionId) {
        this.solutionRepository.deleteById(solutionId);
    }

    public Solution updateSolution(Solution solution){
        return (Solution)this.solutionRepository.save(solution);
    }
    public Solution getSolution(Long solutionId) {
        return this.solutionRepository.findById(solutionId).get();
    }
    public List<Solution> getAllSolution() {
        return this.solutionRepository.findAll();
    }

    public List<Solution> getAllProblemSolutions(Problem problem) {
        return this.solutionRepository.findByQuestion(problem);
    }

    public List<Solution> getAllUserSolutions(User user) {
        return this.solutionRepository.findBySolver(user);
    }

    public void deleteSolutionsByProblemId(Problem problem) {
        List<Solution> solutions = solutionRepository.findByQuestion(problem);
        solutionRepository.deleteAll(solutions);
    }
}
