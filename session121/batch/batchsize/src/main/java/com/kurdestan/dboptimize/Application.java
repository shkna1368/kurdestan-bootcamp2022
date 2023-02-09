package com.kurdestan.dboptimize;


import com.github.javafaker.Faker;
import com.kurdestan.dboptimize.application.Company;
import com.kurdestan.dboptimize.application.CompanyRepository;
import com.kurdestan.dboptimize.clients.Client;
import com.kurdestan.dboptimize.clients.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController

@SpringBootApplication
public class Application  {

@Autowired
CompanyRepository companyRepository;


@Autowired
ClientRepository clientRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/test")
    public void run()  {


        Instant start=Instant.now();
//for(int i=0;i<10;i++){
       //insert
        Faker faker = new Faker();

        List<Company> companyList=new ArrayList<>();

            for (int j=0;j<100000;j++) {

                Company company = new Company();
                company.setEmail(faker.internet().emailAddress());
                company.setName(faker.company().name());
                companyList.add(company);


            }
            companyRepository.saveAll(companyList);
//}
            Instant end=Instant.now();
            System.out.println("Time elapsed:"+ Duration.between(start,end));


}
}
