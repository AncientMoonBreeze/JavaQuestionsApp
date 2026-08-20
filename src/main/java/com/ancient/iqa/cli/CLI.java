package com.ancient.iqa.cli;

import com.ancient.iqa.controller.QuestionController;
import com.ancient.iqa.dto.InterviewQuestionDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CLI implements CommandLineRunner {
    private final QuestionController controller;
    private final Scanner scanner = new Scanner(System.in);
    public static final String TEXT = """
            ========== МЕНЮ ==========
            1. list - показать все вопросы
            2. add  - добавить вопрос
            3. exit - выйти
            ==========================
            """;

    public CLI(QuestionController controller) {
        this.controller = controller;
    }

    @Override
    public void run(String... args){
        while(true){
            System.out.println(CLI.TEXT);
            System.out.print("Ввведите команду: ");
            String command = scanner.nextLine().trim().toLowerCase();

            switch(command){
                case "add" -> handleAdd();
                case "list" -> handleList();
                case "exit" -> {
                    System.out.println("Выход из программы...\n");
                    return;
                }
                default -> System.out.println("Неизвестная команда!\n");
            }
        }
    }

    private void handleAdd(){
        System.out.print("Введите вопрос(или 'menu' для выхода): ");
        String question = scanner.nextLine();
        if(question.equalsIgnoreCase("menu")) return;

        System.out.print("Введите ответ(или 'menu' для выхода): ");
        String answer = scanner.nextLine();
        if(answer.equalsIgnoreCase("menu")) return;

        InterviewQuestionDto created = controller.createQuestion(question, answer);
        System.out.println("Успешно добавлено: " + created.id() + "/n");
    }

    private void handleList() {
        var question = controller.getQuestions();
        if(question.isEmpty()){
            System.out.println("Список вопросов пуст.\n");
            return;
        }
        System.out.println("=== Список вопросов ===");
        for(InterviewQuestionDto q : question){
            String line = """
                ID: %d
                Вопрос: %s
                Ответ: %s
                ------------------------""".formatted(q.id(), q.question(), q.answer());

            System.out.println(line);
        }
    }
}
