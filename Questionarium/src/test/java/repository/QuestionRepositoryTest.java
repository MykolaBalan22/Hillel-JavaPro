package repository;

import model.Question;
import org.junit.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class QuestionRepositoryTest {
    private static Connection connection;
    private  QuestionRepositoryImp imp;
    private static String user = "root";
    private static String password = "root";
    private static String url = "jdbc:mysql://localhost:3306/nikola_base";

    private int testId = 100;
    private String testText = "test question";
    private String testTopic = "Test topic";
    private Question questionToSave = Question.builder()
            .id(testId)
            .text(testText)
            .topic(testTopic)
            .build();

    @BeforeClass
    public static void createConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Before
    public void saveTestEntity() {
        this.imp = new QuestionRepositoryImp(connection);
        this.imp.save(questionToSave);
    }

    @Test
    public void getTest() {
        Question actual = this.imp.get(testId);
        this.imp.delete(testId);
        Assert.assertEquals(questionToSave, actual);
    }

    @Test
    public void saveTest() {
        Question actual = this.imp.get(testId);
        this.imp.delete(testId);
        Assert.assertEquals(questionToSave, actual);
    }

    @Test
    public void updateTest() {
        String updateText = "Update question";
        Question questionToUpdate = Question.builder().id(testId).text(updateText).topic(testTopic).build();
        this.imp.update(questionToUpdate);
        Question actual = this.imp.get(testId);
        this.imp.delete(testId);
        Assert.assertEquals(questionToUpdate, actual);
    }

    @Test
    public void deleteTest() {
        this.imp.delete(testId);
        int actual = this.imp.getByTopic(this.testTopic).size();
        Assert.assertEquals(0, actual);
    }

    @Test
    public void getByTopicTest() {
        List<Question> actual = this.imp.getByTopic(testTopic);
        List<Question> expected = List.of(questionToSave);
        this.imp.delete(testId);
        Assert.assertEquals(expected, actual);
    }
}
