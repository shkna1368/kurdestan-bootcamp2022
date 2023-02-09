package com.kurdestan.dboptimize;


import com.github.javafaker.Faker;
import com.kurdestan.dboptimize.application.Company;
import com.kurdestan.dboptimize.application.CompanyRepository;

import com.kurdestan.dboptimize.cm.Cm;
import com.kurdestan.dboptimize.cm.CmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController

@SpringBootApplication
public class Application  implements CommandLineRunner {

@Autowired
CompanyRepository companyRepository;



@Autowired
CmRepository cmRepository;




    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/testCP")
    public List<Company> testCP()  {


        Random random = new Random();

       int x= random.nextInt((10 - 1) + 1) + 1;
        //System.out.println(x);
        // return companyRepository.findAll(PageRequest.of(0,100)).getContent();
      return  companyRepository.findAll(PageRequest.of(x,100)).getContent();
       /* companyRepository.findAll(PageRequest.of(1,100)).getContent();
        cmRepository.findAll(PageRequest.of(1,100)).getContent();
        cmRepository.findAll(PageRequest.of(2,100)).getContent();
        companyRepository.findAll(PageRequest.of(2,100)).getContent();
        companyRepository.findAll(PageRequest.of(3,100)).getContent();
        cmRepository.findAll(PageRequest.of(0,100)).getContent();

        cmRepository.findAll(PageRequest.of(3,100)).getContent();
*/








    }



    @GetMapping("/test")
    public void run()  {


        Instant start=Instant.now();
//for(int i=0;i<10;i++){
       //insert
        Faker faker = new Faker();

        List<Company> companyList=new ArrayList<>();
        List<Cm> companyList2=new ArrayList<>();

            for (int j=0;j<100000;j++) {

                Company company = new Company();
                company.setEmail(faker.internet().emailAddress());
                company.setName(faker.company().name());
                companyList.add(company);

                   Cm company2 = new Cm();
                company2.setEmail(faker.internet().emailAddress());
                company2.setName(faker.company().name());
                companyList2.add(company2);





            }
            companyRepository.saveAll(companyList);
            cmRepository.saveAll(companyList2);
//}
            Instant end=Instant.now();
            System.out.println("Time elapsed:"+ Duration.between(start,end));


}

    @Override
    public void run(String... args) throws Exception {
     //  run();

    }
}
