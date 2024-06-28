package com.forum.forum.controller;

import com.forum.forum.entity.Company;
import com.forum.forum.entity.Problem;
import com.forum.forum.entity.Solution;
import com.forum.forum.entity.User;
import com.forum.forum.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/solution")
@CrossOrigin("*")
public class SolutionController {
    @Autowired
    private SolutionService solutionService;



    @PostMapping("/")
    public Solution createSolution(@RequestBody Solution solution) throws Exception {return this.solutionService.createSolution(solution);}
    @GetMapping("/{solutionId}")
    public Solution getSolution(@PathVariable ("solutionId") Long solutionId)
    {
        return this.solutionService.getSolution(solutionId);
    }
    @DeleteMapping("/{solutionId}")
    public void deleteSolution (@PathVariable ("solutionId") Long solutionId)
    {
        this.solutionService.deleteSolution(solutionId);
    }
    @GetMapping("/")
    public List<Solution> getAllSolution ()
    {
        return this.solutionService.getAllSolution();
    }
    @GetMapping("/solutions_problem/{problemId}")
    public List<Solution> getProblemSolution (@PathVariable ("problemId") Long problemId)
    {
        Problem problem = new Problem();
        problem.setProblemId(problemId);
        return this.solutionService.getAllProblemSolutions(problem);
    }

    @GetMapping("/solutions_user/{userId}")
    public List<Solution> getUserSolution (@PathVariable ("userId") Long userId)
    {
        User user = new User();
        user.setId(userId);
        return this.solutionService.getAllUserSolutions(user);
    }
    @DeleteMapping("/problem/{problemId}")
    public void deleteSolutionsByProblemId(@PathVariable Long problemId) {
        Problem problem = new Problem();
        problem.setProblemId(problemId);
        solutionService.deleteSolutionsByProblemId(problem);
    }
}
