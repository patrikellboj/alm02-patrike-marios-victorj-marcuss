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

    public String selectMsgAccordingToRule(Person person){
        String selectedList = "";
        if (person.getGender().equals("female"))
            selectedList="female_msg";
        else
            selectedList="male_msg";
        int element = getRandomValue();
        String result = person.getName() + " " + getMsgFromProperties(selectedList, element);
        return result;
    }


    public int getRandomValue() {
        Random random = new Random();
        int randomValue = random.nextInt(5);
        return randomValue; //
    }


    public String getMsgFromProperties(String selectedList, int element) {
        Properties properties = new Properties();
        String separator = System.getProperty("file.separator");

        try {
            properties.load(new FileInputStream("src" + separator + "main" + separator + "resources" + separator +  "fortune.properties"));
        }
        catch (Exception e){
            System.out.println("File not found");
        }
        //take the properties string (it's just a one long string), splitter it by "," and then get the right msg
        String list = properties.getProperty(selectedList);
        List<String> elements = Arrays.asList(list.split(","));
        return elements.get(element);
    }

}
