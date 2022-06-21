package com.kurdestan.testmaven;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Runner {

    public static void main(String[] args) {
        Student student=new Student();

        student.setName("ali");
        student.setFamily("rezaee");
        student.setAge(16);


        Faker faker=new Faker(new Locale("fa")) ;
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        faker.address().streetAddress();
        System.out.println(firstName);
        System.out.println(lastName);

    }
}
