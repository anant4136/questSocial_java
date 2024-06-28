package com.forum.forum.controller;

import com.forum.forum.entity.Company;
import com.forum.forum.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@CrossOrigin("*")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @PostMapping("/")
    public Company createCompany(@RequestBody Company company) throws Exception {return this.companyService.createCompany(company);}
    @GetMapping("/{name}")
    public Company getCompany (@PathVariable("name") String name)
    {
        return this.companyService.getCompany(name);
    }
    @DeleteMapping("/{companyId}")
    public void deleteCompany (@PathVariable ("companyId") Long companyId)
    {
        this.companyService.deleteCompany(companyId);
    }
    @GetMapping("/")
    public List<Company> getAllCompanies ()
    {
        return this.companyService.getAllCompanies();
    }


}