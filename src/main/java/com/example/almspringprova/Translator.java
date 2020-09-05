
package com.example.almspringprova;

import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Random;

@Component
public class Translator {

    private String propertiesPath = "src\\main\\resources\\fortune.properties";

    public String selectMsgAccordingToRule(Person person){
        String selectedList = "";
        if (person.getGender().equalsIgnoreCase("female"))
            selectedList="female_msg";
        else
            selectedList="male_msg";
        int element = getRandomValue();
        String rightList= getPropertiesRightListAsString(selectedList);
        String result = splitStringAndGetRightElement(rightList,element);
        return result;
    }


    public int getRandomValue() {
        Random random = new Random();
        int randomValue = random.nextInt(5);
        return randomValue; //
    }


    public String getPropertiesRightListAsString(String selectedList) { // we have many list fortune we have to select the right one!
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(propertiesPath));
        }
        catch (Exception e){
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

    public void setPropertiesPath(String propertiesPath) {
        this.propertiesPath = propertiesPath;
    }
}
