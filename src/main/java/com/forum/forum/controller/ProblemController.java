package com.forum.forum.controller;

import com.forum.forum.entity.Problem;
import com.forum.forum.entity.Solution;
import com.forum.forum.entity.User;
import com.forum.forum.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/problem")
@CrossOrigin("*")
public class ProblemController {
    @Autowired
    private ProblemService problemService;



    @PostMapping("/")
    public Problem createProblem(@RequestBody Problem problem) throws Exception {return this.problemService.createProblem(problem);}
    @GetMapping("/{problemId}")
    public Problem getProblem (@PathVariable ("problemId") Long problemId)
    {
        return this.problemService.getProblem(problemId);
    }
    @DeleteMapping("/{problemId}")
    public void deleteProblem (@PathVariable ("problemId") Long problemId)
    {
        this.problemService.deleteProblem(problemId);
    }
    @GetMapping("/")
    public List<Problem> getAllProblem ()
    {
        return this.problemService.getAllProblem();
    }

    @GetMapping("/problems/{userId}")
    public List<Problem> getUserProblem (@PathVariable ("userId") Long userId)
    {
        User user = new User();
        user.setId(userId);
        return this.problemService.getAllUserProblems(user);
    }
    @PostMapping("/update")
    public Problem updateUser(@RequestBody Problem problem) {

        Problem updatedProblem = problemService.updateProblem(problem);
        return updatedProblem;

    }
}
