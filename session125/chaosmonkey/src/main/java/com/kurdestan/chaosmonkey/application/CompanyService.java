package com.kurdestan.chaosmonkey.application;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;


    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAll() {
      return companyRepository.findAll();
       /* List<Company> companies = null;
        try {
            companies = companyRepository.findAll();
        } catch (Exception e) {
            System.out.println("STackTrace: " + Arrays.toString(e.getStackTrace()));
            System.out.println("Caught an Exception....");
            companies = new ArrayList<>();
        }
        return companies;*/

    }
}