package main;

import repository.QuestionRepositoryImp;
import service.QuestionService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuestionService questionService = new QuestionService(new QuestionRepositoryImp());
        Scanner readerFromKeyboards = new Scanner(System.in);
        do{
            int action = ChooseMenu.chooseAction(readerFromKeyboards);
            switch (action){
                case 0 :
                    System.out.println("---Buy---");
                    System.exit(1);
                    break;
                case 1 :
                    ChooseMenu.saveAction(readerFromKeyboards,questionService);
                    break;
                case 2 :
                    ChooseMenu.deleteAction(readerFromKeyboards,questionService);
                    break;
                case 3 :
                    ChooseMenu.getRandomQuestion(questionService);
                    break;
                case 4 :
                    ChooseMenu.getRandomQuestionByTopic(readerFromKeyboards,questionService);
                    break;
            }
        }while (true);
    }
}
