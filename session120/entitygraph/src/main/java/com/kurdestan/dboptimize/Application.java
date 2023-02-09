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


import java.time.Duration;
import java.time.Instant;


@SpringBootApplication
public class Application implements ApplicationRunner {

@Autowired
CompanyRepository companyRepository;


@Autowired
ClientRepository clientRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {


        Instant start=Instant.now();

        if(clientRepository.count()==0){
       //insert
        Faker faker = new Faker();

            for (int j=0;j<200;j++) {

                Company company = new Company();
                company.setEmail(faker.internet().emailAddress());
                company.setName(faker.company().name());
                var savedCompany = companyRepository.save(company);


                    Client client = new Client();
                    client.setName(faker.name().firstName());
                    client.setFamily(faker.name().lastName());
                    client.setEmail(faker.internet().emailAddress());
                    client.setCompany(savedCompany);
                    clientRepository.save(client);

            }
            Instant end=Instant.now();
            System.out.println("Time elapsed:"+ Duration.between(start,end));
    }
        System.out.println("----");

        companyRepository.findAll(PageRequest.of(0,5));
        System.out.println("-----------");
        clientRepository.findAll(PageRequest.of(0,5));
}
}
