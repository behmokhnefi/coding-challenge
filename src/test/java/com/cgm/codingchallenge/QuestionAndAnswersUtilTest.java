package com.cgm.codingchallenge;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class QuestionAndAnswersUtilTest {


    @Test(expected = NullPointerException.class)
    public void extractQuestion_null_input(){
        QuestionAndAnswersUtil.extractQuestion(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void extractQuestion_empty_enput(){
        QuestionAndAnswersUtil.extractQuestion("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void extractQuestion_question_is_larger_than_255(){
        char [] test = new char[Constants.MAX_CHARS_OF_Expression + 3];
        Arrays.fill(test , 'T');
        test[Constants.MAX_CHARS_OF_Expression+1] = '?';
        test[Constants.MAX_CHARS_OF_Expression+2] = 't';

        QuestionAndAnswersUtil.extractQuestion(new String(test));
    }

    @Test(expected = IllegalArgumentException.class)
    public void extractQuestion_IncorrectInput(){
        QuestionAndAnswersUtil.extractQuestion("questionasdassd");
    }

    @Test
    public void extractQuestion_CorrectInput(){
        String result = QuestionAndAnswersUtil.extractQuestion("what is your name? \"behzad\" ");
        Assert.assertEquals("what is your name", result);
    }


    @Test(expected = NullPointerException.class)
    public void extractAnswers_null_input(){
        QuestionAndAnswersUtil.extractAnswers(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void extractAnswers_empty_input(){
        QuestionAndAnswersUtil.extractAnswers("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void extractAnswers_answer_is_larger_than_255(){
        char [] test = new char[Constants.MAX_CHARS_OF_Expression + 3];
        Arrays.fill(test , 'T');
        test[0] = 'Q';
        test[1] = '?';
        test[2] = '\"';
        test[3] = 'A';
        test[Constants.MAX_CHARS_OF_Expression + 1] = 'A';
        test[Constants.MAX_CHARS_OF_Expression + 2] = '\"';
        QuestionAndAnswersUtil.extractAnswers(new String(test));
    }

    @Test
    public void extractAnswers_CorrectInput() {
        List<String> result = QuestionAndAnswersUtil.extractAnswers("What is Peters favorite food? \"Pizza\" \"Spaghetti\" \"Ice cream\"");
        Assert.assertEquals(Arrays.asList("Pizza", "Spaghetti", "Ice cream"), result);
    }


}
