package com.example.almspringprova;

import java.util.Arrays;
import java.util.List;

public class Person {

    String name;
    String age;
    String gender;
    final static List<String> GENDERLIST = Arrays.asList("male", "female", "other");

    public Person() {}

    public Person(String name, String age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
