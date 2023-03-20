package main;


import model.Question;
import service.QuestionService;

import java.util.Scanner;

public class ChooseMenu {
    public static int chooseAction(Scanner reader) {
        System.out.println("---Choose your action---");
        System.out.println("---Save new question           ___enter 1---");
        System.out.println("---Delete   question           ___enter 2---");
        System.out.println("---Get random question         ___enter 3---");
        System.out.println("---Get random question by topic___enter 4---");
        System.out.println("---          EXIT              ___enter 0---");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        return reader.nextInt();
    }

    public static void saveAction(Scanner reader, QuestionService questionService) {
        System.out.println("---Save action---");
        System.out.println("Enter question id : ");
        Question toSave = new Question();
        toSave.setId(reader.nextInt());
        System.out.println("Enter question text : ");
        toSave.setText(reader.next());
        System.out.println("Enter question topic : ");
        toSave.setTopic(reader.next());
        questionService.saveQuestion(toSave);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
    }
    public static void deleteAction(Scanner reader, QuestionService questionService) {
        System.out.println("---Delete action---");
        System.out.println("Enter question id : ");
        Question toDelete = new Question();
        toDelete.setId(reader.nextInt());
        System.out.println("Enter question text : ");
        toDelete.setText(reader.next());
        System.out.println("Enter question topic : ");
        toDelete.setTopic(reader.next());
        questionService.deleteQuestion(toDelete);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
    }
    public static void getRandomQuestion(QuestionService questionService) {
        System.out.println("---Get random questios action---");
        System.out.println(questionService.getRandomQuestion().getText());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
    }
    public static void getRandomQuestionByTopic(Scanner reader, QuestionService questionService) {
        System.out.println("---Get random questios action---");
        System.out.println("Enter question topic : ");
        System.out.println(questionService.getRandomQuestionByTopic(reader.next()).getText());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
    }

}
