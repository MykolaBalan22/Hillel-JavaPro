package repository;

import exception.SqlQueryException;
import model.Question;
import repository.dao.QuestionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class QuestionRepositoryImp implements QuestionRepository {
    private final Connection connection;
    private final String saveQuestion = "INSERT INTO questions VALUE(?,?,?)";
    private final String deleteQuestion = "DELETE FROM questions WHERE id=?";
    private final String randomQuestion = "SELECT * FROM questions ORDER BY RAND() LIMIT 1";

    public QuestionRepositoryImp() {
        this.connection = ConnectionSingelton.getConnection();
    }

    public QuestionRepositoryImp(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Question toSave) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(saveQuestion);
            statement.setInt(1, toSave.getId());
            statement.setString(2, toSave.getText());
            statement.setString(3, toSave.getTopic());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SqlQueryException(e);
        }
    }

    @Override
    public void delete(Question toDelete) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(deleteQuestion);
            statement.setInt(1, toDelete.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SqlQueryException(e);
        }
    }

    @Override
    public Question getRandomQuestion() {
        try {
            PreparedStatement statement = this.connection.prepareStatement(randomQuestion);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return Question.builder()
                    .id(resultSet.getInt("id"))
                    .text(resultSet.getString("text"))
                    .topic(resultSet.getString("topic"))
                    .build();
        } catch (SQLException e) {
            throw new SqlQueryException(e);
        }
    }
}
