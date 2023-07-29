package ru.rhontcompany.aqapi.servises.apiimpl;

import org.springframework.stereotype.Repository;
import ru.rhontcompany.aqapi.servises.api.QuestionRepository;
import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class JavaQuestionRepositoryImpl implements QuestionRepository {
    private Set<Question> questions;


    @PostConstruct
    private void init(){
        questions=new HashSet<>(Set.of(
                new Question("1q","1a"),
                new Question("2q","2a"),
                new Question("3q","3a"),
                new Question("4q","4a"),
                new Question("5q","5a"),
                new Question("6q","6a"),
                new Question("7q","7a")
        ));
    }

    public JavaQuestionRepositoryImpl(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public Question remove(Question questionObj) {
        questions.remove(questionObj);

        return questionObj;
    }

    @Override
    public Question add(Question question) {
        isBlankOrEmpty(question.getQuestion(), question.getAnswer());
        questions.remove(question);
        questions.add(question);
        return question;
    }

    @Override
    public Question add(String question, String answer) {
        isBlankOrEmpty(question,answer);
        Question questionObj=new Question(question,answer);
        return add(questionObj);
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }


    private void isBlankOrEmpty(String strFirst, String strSecond){
        if (strFirst.isBlank() || strFirst.isEmpty() || strSecond.isBlank() || strSecond.isEmpty()) {
            throw new IllegalArgumentException("Одна из строк пусты");
        }
    }
}
