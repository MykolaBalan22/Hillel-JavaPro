package service;

import model.Question;
import repository.dao.QuestionRepository;

public class QuestionService {
    private final QuestionRepository repository;

    public QuestionService(QuestionRepository repository) {
        this.repository = repository;
    }
    public Question getRandomQuestionByTopic(String topic){
        Question randomQuestion=repository.getRandomQuestion();
        while (!randomQuestion.getTopic().equals(topic)){
            randomQuestion =this.repository.getRandomQuestion();
        }
        return randomQuestion;
    }
    public Question getRandomQuestion(){
        return this.repository.getRandomQuestion();
    }
    public void saveQuestion(Question toSave){
        this.repository.save(toSave);
    }
    public void deleteQuestion(Question toDelete){
        this.repository.delete(toDelete);
    }
}
