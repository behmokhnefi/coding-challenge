package com.cgm.codingchallenge;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * unit tests for Class_Universe
 */
public class UniverseTest {

    private final Universe universe = new Universe();


    @Test(expected = IllegalArgumentException.class)
    public void addNewQuestionAndAnswers_null_input(){
        universe.addNewQuestionAndAnswers(null);

    }

    @Test(expected = IllegalArgumentException.class)
    public void addNewQuestionAndAnswers_IncorrectFormatException1(){
        universe.addNewQuestionAndAnswers("what is my name?");
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNewQuestionAndAnswers_IncorrectormatException2(){
        universe.addNewQuestionAndAnswers("what is my name? asdasd ");
    }

    @Test
    public void addNewQuestionAndAnswers_test(){

        universe.addNewQuestionAndAnswers("What is Peters favorite food? \"Pizza\" \"Spaghetti\" \"Ice cream\"");

        universe.addNewQuestionAndAnswers("What is Peters favorite city? \"Linz\" \"Steyr\" \"Kaufbeuren\" ");

        Map<String, List<String>> ideas = universe.getIdeas();

        Assert.assertEquals(2, ideas.size());

        Assert.assertEquals(3, ideas.get("What is Peters favorite food").size());

        Assert.assertEquals(3, ideas.get("What is Peters favorite city").size());

        Assert.assertNull(ideas.get("WHAT IS PETERS FAVORITE CITY"));

        Assert.assertNull(ideas.get("What is Peters favorite film"));


    }

    @Test(expected = IllegalArgumentException.class)
    public void getAnswers_EmptyQuestion(){
        List<String> answers = universe.getAnswers(null);
    }

    @Test
    public void getAnswers_NotStoredQuestion(){

        List<String> answers = universe.getAnswers("is this question stored?!!");

        Assert.assertEquals(Arrays.asList("the answer to life, universe and everything is 42"),answers);
    }

    @Test
    public void getAnswers_CorrectAnswer(){

        universe.addNewQuestionAndAnswers("What is Peters favorite food? \"Pizza\" \"Spaghetti\" \"Ice cream\"");

        List<String> answers = universe.getAnswers("What is Peters favorite food");

        Assert.assertEquals(Arrays.asList("Pizza", "Spaghetti", "Ice cream"),answers);
    }










}
