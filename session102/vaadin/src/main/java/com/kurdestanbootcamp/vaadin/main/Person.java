package com.kurdestanbootcamp.vaadin.main;


import java.util.ArrayList;
import java.util.List;

public class Person {

    private String firstName;
    private String lastName;
    private String email;
    private String profession;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }


    public Person(String firstName, String lastName, String email, String profession) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.profession = profession;
    }


    public static List<Person> seed(){
        Person p1=new Person("ali","ahmadi1","ahmadi@gmail.com","Allergist");
        Person p2=new Person("ali3","ahmadi3","ahmadi@gmail.com","Allergist");
        Person p3=new Person("ali4","ahmadi4","ahmadi@gmail.com","Allergist");
        Person p4=new Person("ali5","ahmadi5","ahmadi@gmail.com","Allergist");
        Person p5=new Person("ali6","ahmadi6","ahmadi@gmail.com","Allergist");
        Person p6=new Person("ali7","ahmadi7","ahmadi@gmail.com","Allergist");
        Person p7=new Person("ali8","ahmadi8","ahmadi@gmail.com","Allergist");
        Person p8=new Person("ali9","ahmadi9","ahmadi@gmail.com","Allergist");
        Person p9=new Person("ali10","ahmadi10","ahmadi@gmail.com","Allergist");
        Person p10=new Person("ali11","ahmadi11","ahmadi@gmail.com","Allergist");

        List<Person> list=new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.add(p7);
        list.add(p8);
        list.add(p9);
        list.add(p10);

        return list;

    }
}