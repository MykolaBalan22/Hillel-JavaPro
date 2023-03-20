package repository.dao;

import model.Question;

public interface QuestionRepository {
    void save(Question toSave);
    void delete (Question toDelete);
    Question getRandomQuestion();
}
