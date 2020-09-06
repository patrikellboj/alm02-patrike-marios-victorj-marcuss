package com.example.almspringprova;

import org.junit.Test;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.*;

public class TranslatorTest {
    Translator translator = new Translator();



    @Test
    public void testGetRandomValue(){
        int result;
        for (int i = 0; i < 100; i++) {
            result = translator.getRandomValue();
            System.out.print(result + " ") ;
            assertTrue(result >= 0 && result <= 9);
        }
    }

    @Test
    public void getPropertiesRightListAsString() {
        assertNotNull(translator.getPropertiesRightListAsString("female_msg"));
        assertNotNull(translator.getPropertiesRightListAsString("male_msg"));
        assertNull(translator.getPropertiesRightListAsString("igelkottar_msg"));

        translator.setPropertiesPath("somethingElse");

        assertNull(translator.getPropertiesRightListAsString("female_msg"));
        assertNull(translator.getPropertiesRightListAsString("male_msg"));
    }

    @Test
    public void splitStringAndGetRightElement() {
        String unsplittedString = "zero,one,two,three,four";
        List<String> splittedString = Arrays.asList("zero", "one", "two", "three", "four");

        System.out.println(unsplittedString);
        for (int i=0; i<5; i++ ) {
            assertEquals(translator.splitStringAndGetRightElement(unsplittedString, i), splittedString.get(i));
            System.out.println(splittedString.get(i));
        }



    }

    @Test
    public void selectMsgAccordingToRule() {
        Person sofia = new Person("Sofia", "3", "female");
        Person alexander = new Person("Alexander", "1", "male");

        System.out.println("Sofia:");
        for (int i = 0; i < 10; i++) {
            assertNotNull(translator.selectMsgAccordingToRule(sofia));
            System.out.println(translator.selectMsgAccordingToRule(sofia));
        }

        System.out.println("Alexander:");
        for (int i = 0; i < 10; i++) {
            assertNotNull(translator.selectMsgAccordingToRule(alexander));
            System.out.println(translator.selectMsgAccordingToRule(alexander));
        }


    }
}