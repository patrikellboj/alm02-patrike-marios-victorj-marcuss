
package com.example.almspringprova;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Random;

@Component
public class Translator {

    String propertiesPath = "/fortune.properties";

    public String selectMsgAccordingToRule(Person person) {
        String selectedList = "";
        if (person.getGender().equalsIgnoreCase("female"))
            selectedList="female_msg";
        else
            selectedList="male_msg";
        int element = getRandomValue();
        String rightList= getPropertiesRightListAsString(selectedList);
        return person.getName() + " " + splitStringAndGetRightElement(rightList,element);
    }


    public int getRandomValue() {
        Random random = new Random();
        int randomValue = random.nextInt(5);
        return randomValue; //
    }


    public String getPropertiesRightListAsString(String selectedList) { // we have many list fortune we have to select the right one!
        Properties properties = new Properties();
        InputStream in = getClass().getResourceAsStream(propertiesPath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        try {
            properties.load(reader);
        }
        catch (Exception e) {
            System.out.println("Properties file not found");
        }
        //take the properties string (it's just a one long string), splitter it by "," and then get the right msg
        String rightList = properties.getProperty(selectedList);
        return rightList;

    }

    public String splitStringAndGetRightElement (String rightList, int element) {
        List<String> elements = Arrays.asList(rightList.split(","));
        return elements.get(element);
    }

}
