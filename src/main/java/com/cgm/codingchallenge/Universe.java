package com.cgm.codingchallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Universe {

    private static Map<String, List<String>> ideas;

    public Universe() {
        ideas = new HashMap<>();
    }

    public void addNewQuestionAndAnswers(String input) {

        if (input == null || input.isEmpty())
            throw new IllegalArgumentException("Input should not be null or Empty");

        if (!QuestionAndAnswersUtil.isCorrectQuestionAndAnswersFormat(input))
            throw new IllegalArgumentException("Incorrect Input Format!!");

        String question = QuestionAndAnswersUtil.extractQuestion(input);

        List<String> answers = QuestionAndAnswersUtil.extractAnswers(input);

        ideas.put(question, answers);
    }

    public List<String> getAnswers(String question) {

        if (question == null || question.length() == 0)
            throw new IllegalArgumentException("Question should not be null or Empty");

        List<String> answers = ideas.get(question);

        if (answers == null)
            answers = Arrays.asList(Console.ULTIMATE_ANSWER_TO_LIFE);

        return answers;
    }

    public void answerToAQuestion(String input) {

        List<String> answers = getAnswers(input);

        printAnswers(answers);

        Console.nextLine();
    }

    private void printAnswers(List<String> answers) {
        if (answers != null && answers.size() > 1)
            System.out.println("\nAnswers will be\n");
        else if (answers != null && answers.size() == 1)
            System.out.println("\nAnswer will be\n");

        for (String answer : answers) {
            System.out.println("\t" + "\u2023" + answer);
        }
    }

    public Map<String, List<String>> getIdeas() {
        return ideas;
    }
}
