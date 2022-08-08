package com.kurdestan.bootcamp;

import com.kurdestan.bootcamp.employee.Employee;
import com.kurdestan.bootcamp.employee.EmployeeRepository;
import com.kurdestan.bootcamp.employee.Gender;
import com.kurdestan.bootcamp.employee.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling
@Slf4j
public class EmployeeApplication implements ApplicationRunner {

    @Autowired
    EmployeeRepository repository;


    @Autowired
    IEmployeeService service;


    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

      log.info("in seeder info");
      log.error("in seeder error");


if (repository.count()==0) {
    Employee emp1 = new Employee();
    emp1.setName("Awin");
    emp1.setFamily("Mariwani");
    emp1.setGender(Gender.FEMALE);
    emp1.setIsMarried(true);
    emp1.setChildCount(4);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-M-dd");
    String date = "1979-4-22";
    Date birthDay = simpleDateFormat.parse(date);
    emp1.setBirthDay(birthDay);
    emp1.setNationalCode("3730136981");

    Employee emp1Saved = repository.save(emp1);

  /*  emp1Saved.setChildCount(5);
    repository.save(emp1Saved);*/
     //repository.delete(emp1Saved);


    Employee emp2 = new Employee();
    emp2.setName("Rebwar");
    emp2.setFamily("KURDESTANi");
    emp2.setGender(Gender.MALE);
    emp2.setIsMarried(true);
    emp2.setChildCount(2);
    String date2 = "1989-4-22";
    Date birthDay2 = simpleDateFormat.parse(date2);
    emp2.setBirthDay(birthDay2);
    emp2.setNationalCode("3730136983");
    Employee emp2Saved = repository.save(emp2);


    Employee emp3 = new Employee();
    emp3.setName("Zhikan");
    emp3.setFamily("ahmadi");
    emp3.setGender(Gender.FEMALE);
    emp3.setIsMarried(true);
    emp3.setChildCount(1);
    String date3 = "1999-3-22";
    Date birthDay3 = simpleDateFormat.parse(date3);
    emp3.setBirthDay(birthDay3);
    emp3.setNationalCode("3730136984");
    Employee emp3Saved = repository.save(emp3);

    Employee emp4 = new Employee();
    emp4.setName("Ala");
    emp4.setFamily("Sanandaji");
    emp4.setGender(Gender.FEMALE);
    emp4.setIsMarried(false);

    String date4 = "2000-3-22";
    Date birthDay4 = simpleDateFormat.parse(date4);
    emp4.setBirthDay(birthDay4);
    emp4.setNationalCode("3730136995");
    Employee emp4Saved = repository.save(emp4);
}


        List<Employee> employeeList= (List<Employee>) repository.findAll();
        List<Employee> employeeList2= repository.findAllByIsMarried(true);
        List<Employee> employeeList3= repository.findAllByChildCountGreaterThan(1);

        System.out.println("finish");

List<Employee> all=service.getAll();
        System.out.println();


    }
}
