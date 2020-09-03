package com.example.almspringprova;

import org.junit.Test;

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
}