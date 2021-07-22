package com.cgm.codingchallenge;


public class Main {

    public static void main(String[] args) {
        int choice;

        Universe universe = new Universe();

        while (true) {

            choice = Console.getUserChoice();

            switch (choice) {
                case 1:
                    universe.answerToAQuestion(Console.getQuestionFromUser());
                    break;
                case 2:
                    universe.addNewQuestionAndAnswers(Console.getQuestionAndAnswersFromUser());
                    Console.ideaAddedConfirmation();
                    Console.nextLine();
                    break;
            }
        }
    }
}