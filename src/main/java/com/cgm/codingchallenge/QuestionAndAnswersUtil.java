package com.cgm.codingchallenge;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuestionAndAnswersUtil {

    private static final String QUESTION_AND_ANSWERS_REGEX = "(.*)\\?(\\s*\"\\w+\"\\s*)";

    static final String ANSWERS_REGEX = "\\s*\"[\\w|\\s]+\"\\s*";

    private static final String QUESTION_REGEX = "\\w\\?$";

    public static String extractQuestion(String input) {

        Objects.requireNonNull(input);

        String[] parts = getParts(input);

        if (parts[0].length() > Constants.MAX_CHARS_OF_Expression)
            throw new IllegalArgumentException("Question should be a String with max 255 chars");

        return parts[0];
    }

    public static List<String> extractAnswers(String input) {

        Objects.requireNonNull(input);

        String[] parts = getParts(input);

        String combinedAnswers = parts[1];

        Pattern p = Pattern.compile(ANSWERS_REGEX);

        Matcher m = p.matcher(combinedAnswers);

        List<String> answers = new ArrayList<>();

        while (m.find()) {

            if(m.group().length()> Constants.MAX_CHARS_OF_Expression)
                throw new IllegalArgumentException("Answer should be a String with max 255 chars");

            answers.add(m.group().replaceAll("\"", "").trim());
        }

        return answers;
    }

    private static String[] getParts(String input) {
        String[] parts = input.split("\\?");
        if (parts.length != 2)
            throw new IllegalArgumentException("the format of input is Incorrect!");
        return parts;
    }

    public static boolean isCorrectQuestionFormat(String input) {
        Pattern p = Pattern.compile(QUESTION_REGEX);
        Matcher m;
        m = p.matcher(input);
        if (m.find())
            return true;
        else
            return false;
    }

    public static boolean isCorrectQuestionAndAnswersFormat(String input) {
        Pattern p = Pattern.compile(QUESTION_AND_ANSWERS_REGEX);
        Matcher m;
        m = p.matcher(input);
        if (m.find())
            return true;
        else
            return false;

    }
}
