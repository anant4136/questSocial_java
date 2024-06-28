package com.forum.forum.service;

import com.forum.forum.entity.Company;
import com.forum.forum.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public Company createCompany(Company company) throws Exception{
        Company local = this.companyRepository.findByName(company.getName());
        if(local!=null)
        {
            System.out.println("company already present");
            throw new Exception("company already present");
        }
        else{
            local = this.companyRepository.save(company);
        }
        return local;
    }

    public void deleteCompany(Long companyId) {
        this.companyRepository.deleteById(companyId);
    }


    public Company getCompany(String name) {
        return this.companyRepository.findByName(name);
    }
    public List<Company> getAllCompanies() {
        return this.companyRepository.findAll();
    }



}