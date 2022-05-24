package com.codeup.springblog;

import com.codeup.springblog.services.StringService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimpleTest {
    private StringService stringService;

    @Before
    public void setUp(){
        this.stringService = new StringService();
    }

    @Test //Sanity Test
    public void testServiceNotNull(){
        assertNotNull(stringService);
    }

    @Test
    public void testGetWordsInCaps(){
        // define a string with a word
        String word = "Hello!";

        String upperCasedWord = stringService.getWordInCaps(word);
        // set string to use string service class
        // to run get words in caps

        assertEquals(upperCasedWord, word.toUpperCase());
        // compare the two values, all letters shoud be caps
        //assert that the word is in all caps
    }

    @Test
    public void testLimitLength(){
        //should return the full string without the dot if string
        // length is less than the limit
        String words = "Hello I am a longer piece of text";


        String limitedWords = stringService.limitLength(words, 5);

        //test case
        assertEquals(limitedWords, "Hello...");

        String longLimit = stringService.limitLength(words, 100);

        assertEquals(longLimit, words);


        //Should return
    }
}
