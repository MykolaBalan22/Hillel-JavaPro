package service;

import model.Question;
import repository.dao.QuestionRepository;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class QuestionService {
    private QuestionRepository repository;

    public QuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    public Question getRndQuestionByTopic(String topic) {
        List<Question> topics = repository.getByTopic(topic);
        int randomNum = ThreadLocalRandom.current().nextInt(0, topics.size());
        return topics.get(randomNum);
    }
}
