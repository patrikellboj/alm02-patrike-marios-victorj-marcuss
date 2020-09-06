
package com.example.almspringprova;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Random;

@Component
public class Translator {


    private String separator = System.getProperty("file.separator");
    private String propertiesPath = "src" + separator + "main" + separator + "resources" + separator + "fortune.properties";

    public String selectMsgAccordingToRule(Person person){
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
        File propertiesFile = new File(propertiesPath);

        try {
            if(propertiesFile.exists()) {
                properties.load(new FileInputStream(propertiesPath));
            }
            else {
                properties.load(new FileInputStream("alm-spring-prova-0.0.1-SNAPSHOT.jar" + separator + "BOOT-INF" + separator + "classes" + separator + "fortune.properties"));
            }
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
