package service;

import model.Question;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repositoryMock.QuestionRepositoryImpMock;

public class QuestionServiceTest {
    private QuestionRepositoryImpMock localRepository;
    private QuestionService questionService;
    private final Question toSave = Question.builder()
            .id(78)
            .text("save message")
            .topic("test Save")
            .build();

    @Before
    public void init() {
        localRepository = new QuestionRepositoryImpMock();
        questionService = new QuestionService(localRepository);
    }

    @Test
    public void getRandomQuestionByTopic() {
        String topic = "Incapsulation";
        Question randomQuestion = questionService.getRandomQuestionByTopic(topic);
        Assert.assertTrue(localRepository.getTemporaryStorage().contains(randomQuestion));
    }

    @Test
    public void getRandomQuestion() {
        Question randomQuestion = questionService.getRandomQuestion();
        Assert.assertTrue(localRepository.getTemporaryStorage().contains(randomQuestion));
    }

    @Test
    public void saveQuestion() {
        questionService.saveQuestion(toSave);
        Assert.assertTrue(localRepository.getTemporaryStorage().contains(toSave));
    }

    @Test
    public void deleteQuestion() {
        questionService.saveQuestion(toSave);
        questionService.deleteQuestion(toSave);
        Assert.assertFalse(localRepository.getTemporaryStorage().contains(toSave));
    }
}
