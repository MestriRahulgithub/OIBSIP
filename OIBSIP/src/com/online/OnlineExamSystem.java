package com.online;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class MCQ {
    private String question;
    private String[] options;
    private int correctOption;

    public MCQ(String question, String[] options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

public class OnlineExamSystem {
    private static String currentUser;
    private static Map<Integer, MCQ> questions;
    private static int selectedAnswer;
    private static boolean isTimeUp;

    public static void main(String[] args) {
        
        initializeQuestions();
        login();
        takeMCQs();
        Timing();
       
    }

    private static void initializeQuestions() {
        questions = new HashMap<>();
        questions.put(1, new MCQ("What is the capital of France?", new String[]{"A. Berlin", "B. Paris", "C. Rome", "D. Madrid"}, 1));
        questions.put(2, new MCQ("Which programming language is used for Android development?", new String[]{"A. Java", "B. C++", "C. Python", "D. Ruby"}, 0));
        
    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String currentUser = scanner.nextLine();
        System.out.print(currentUser);
        System.out.print("Enter password: ");
        String currentPassword = scanner.nextLine();
        System.out.print(currentPassword);

        
    }



    private static void takeMCQs() {
        Scanner scanner = new Scanner(System.in);

        for (int questionNumber : questions.keySet()) {
            MCQ mcq = questions.get(questionNumber);

            System.out.println("\nQuestion " + questionNumber + ": " + mcq.getQuestion());
            for (int i = 0; i < mcq.getOptions().length; i++) {
                System.out.println(mcq.getOptions()[i]);
            }

            System.out.print("Select your answer (0-3): ");
            selectedAnswer = scanner.nextInt();

            if (selectedAnswer == mcq.getCorrectOption()) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is: " + mcq.getCorrectOption());
            }
        }
    }

    private static void Timing() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        executorService.schedule(() -> {
            System.out.println("\nTime's up! Auto-submitting answers...");
            isTimeUp = true;
        }, 5, TimeUnit.SECONDS);

        while (!isTimeUp) {

        }

        executorService.shutdown();
    }

    
}

