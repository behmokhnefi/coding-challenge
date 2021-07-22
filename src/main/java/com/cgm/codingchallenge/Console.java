package com.cgm.codingchallenge;


import java.util.Scanner;


public class Console {

    static final String ULTIMATE_ANSWER_TO_LIFE = "the answer to life, universe and everything is 42";

    private static final String MENU_TEXT = "Please select one option:\n 1-Ask a question:\n 2-Add question and answers:\n";

    private static final String INPUT_PROMPT = "Enter question and Answers in the format of: <question>? \"<answer1>\" \"<answer2>\" \"<answerX>\"";

    private static final String INPUT_QUESTION_PROMPT = "Enter question in the format of: <question>?";

    private static final String SELECT_MENU_PROMPT = "Please Enter 1 or 2!!";

    private static final String CONTINUE_PROMPT = "\nPress Enter to continue...";

    private static final String SUCCESS_PROMPT = "\nSuccessfully added...";

    private static Scanner scanner = new Scanner(System.in);

    public static void showOptionsToUser() {
        System.out.println(MENU_TEXT);
    }

    public static int getUserChoice() {
        showOptionsToUser();
        int ch = 0;
        while (true) {
            try {
                String inp = scanner.nextLine();
                ch = Integer.parseInt(inp);
                if (ch == 1 || ch == 2) {
                    break;
                } else
                    invalidInputError();

            } catch (Exception e) {
                invalidInputError();
            }
        }
        return ch;
    }

    public static String getQuestionAndAnswersFromUser() {
        showCorrectFormatOfQuestionAndAnswersToUser();
        String input;
        while (true) {
            try {
                input = scanner.nextLine();
                if (QuestionAndAnswersUtil.isCorrectQuestionAndAnswersFormat(input))
                    break;
                else
                    showCorrectFormatOfQuestionAndAnswersToUser();

            } catch (Exception e) {
                showCorrectFormatOfQuestionAndAnswersToUser();
            }
        }
        return input;
    }

    public static String getQuestionFromUser() {
        showCorrectFormatOfQuestionToUser();
        String input;
        while (true) {
            try {
                input = scanner.nextLine();
                if (QuestionAndAnswersUtil.isCorrectQuestionFormat(input))
                    break;
                else
                    showCorrectFormatOfQuestionToUser();
            } catch (Exception e) {
                showCorrectFormatOfQuestionToUser();
            }
        }
        input = input.split("\\?")[0];

        return input;
    }

    public static void showCorrectFormatOfQuestionAndAnswersToUser() {
        System.out.println(INPUT_PROMPT);
    }

    public static void showCorrectFormatOfQuestionToUser() {
        System.out.println(INPUT_QUESTION_PROMPT);
    }

    public static void invalidInputError() {
        System.out.println(SELECT_MENU_PROMPT);
    }

    public static void nextLine() {
        System.out.println(CONTINUE_PROMPT);
        scanner.nextLine();
    }

    public static void ideaAddedConfirmation() {
        System.out.println(SUCCESS_PROMPT);
    }

}
