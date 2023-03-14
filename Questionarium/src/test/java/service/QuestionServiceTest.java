package service;

import model.Question;
import org.junit.Assert;
import org.junit.Test;
import repository.QuestionRepositoryImp;
import repository.dao.QuestionRepository;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class QuestionServiceTest {
    private String user = "root";
    private String password = "root";
    private String url = "jdbc:mysql://localhost:3306/nikola_base";


    @Test
    public void getRndQuestionByTopicTest() throws SQLException {
        String topic = "OOP";
        QuestionRepositoryImp impl = new QuestionRepositoryImp(DriverManager.getConnection(url, user, password));
        QuestionService testService = new QuestionService(impl);
        Question rndQuestionByTopic = testService.getRndQuestionByTopic(topic);
        Assert.assertTrue(impl.getByTopic(topic).contains(rndQuestionByTopic));
    }
}
