package com.example.almspringprova;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Random;

@Component
public class Translator {
    Person person = new Person();
    int randomValue;
    String result;


    public Translator() {}

    public Translator(Person Person) {
        getInputFromUser();                 //  creates this.person
        this.randomValue = getRandomValue();                   //  create this.randomValue
        //this.result =  selectMsgAccordingToRule();         //  create this.result through getMsgFromProperties
    }


    public void getInputFromUser(){
        String name = JOptionPane.showInputDialog("Name? ");
        String age = JOptionPane.showInputDialog("Age? ");
        String gender = JOptionPane.showInputDialog("Gender? ");

        this.person = new Person(name, age, gender);
    }


    public int getRandomValue() {
        Random random = new Random();
        int randomValue = random.nextInt(10);
        return randomValue; //
    }


    public String selectMsgAccordingToRule(Person person){
        String selectedList = "";
        if (person.getGender().equals("female"))
            selectedList="female_msg";
        else
            selectedList="male_msg";
        int element = getRandomValue();
        String result= getMsgFromProperties(selectedList, element);
        return result;
    }


    private String getMsgFromProperties(String selectedList, int element) {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream("src\\main\\resources\\fortune.properties"));
        }
        catch (Exception e){
            System.out.println("File not found");
        }
      //take the properties string (it's just a one long string), splitter it by "," and then get the right msg
        String list = properties.getProperty(selectedList);
        List<String> elements = Arrays.asList(list.split(","));
        return elements.get(element);

    }

    public String getResult() {
        return result;
    }
}
