package repositoryMock;

import model.Question;
import repository.dao.QuestionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class QuestionRepositoryImpMock implements QuestionRepository {
    private final List<Question> temporaryStorage= new ArrayList<>();
    public QuestionRepositoryImpMock() {
        temporaryStorage.add(Question.builder().id(1).text("some text1").topic("Incapsulation").build());
        temporaryStorage.add(Question.builder().id(2).text("some text2").topic("Incapsulation").build());
        temporaryStorage.add(Question.builder().id(3).text("some text3").topic("Incapsulation").build());
        temporaryStorage.add(Question.builder().id(4).text("some text4").topic("Incapsulation").build());
        temporaryStorage.add(Question.builder().id(5).text("some text5").topic("OOP").build());
        temporaryStorage.add(Question.builder().id(6).text("some text6").topic("OOP").build());
        temporaryStorage.add(Question.builder().id(7).text("some text7").topic("Inheritance").build());
        temporaryStorage.add(Question.builder().id(8).text("some text8").topic("Inheritance").build());
    }

    public List<Question> getTemporaryStorage() {
        return temporaryStorage;
    }

    @Override
    public void save(Question toSave) {
        temporaryStorage.add(toSave);
    }

    @Override
    public void delete(Question toDelete) {
    temporaryStorage.remove(toDelete);
    }

    @Override
    public Question getRandomQuestion() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, temporaryStorage.size());
        return temporaryStorage.get(randomNum);
    }
}
