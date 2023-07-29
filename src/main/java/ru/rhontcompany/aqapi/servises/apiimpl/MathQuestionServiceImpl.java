package ru.rhontcompany.aqapi.servises.apiimpl;

import org.springframework.stereotype.Service;
import ru.rhontcompany.aqapi.exception.StopedMathRepository;
import ru.rhontcompany.aqapi.servises.api.QuestionService;

import java.util.*;

@Service
public class MathQuestionServiceImpl implements QuestionService {

    boolean isActive=false;
    Set<Question> repositoryRandomQuestion = new HashSet<>();
    Random myRandom;

    public MathQuestionServiceImpl(Random random) {
        this.myRandom = random;
    }

    @Override
    public Question getRandomQuestion() {
        while (true) {
            Question randomQuestion = new Question("SomeMathQ_" + myRandom.nextInt(100), "SomeMathA_" + myRandom.nextInt(100));
            if (!repositoryRandomQuestion.contains(randomQuestion)) {
                repositoryRandomQuestion.add(randomQuestion);
                return randomQuestion;
            }
        }
    }

    @Override
    public Collection<Question> getAll() {
        checkActive();
        return Collections.unmodifiableSet(repositoryRandomQuestion);
    }

    @Override
    public Question remove(Question question) {
        checkActive();
        repositoryRandomQuestion.remove(question);
        return question;
    }

    @Override
    public Question add(Question question) {
        checkActive();
        repositoryRandomQuestion.remove(question);
        repositoryRandomQuestion.add(question);
        return question;
    }

    @Override
    public Question add(String question, String answer) {
        checkActive();
        Question questionObj=new Question(question,answer);
        return add(questionObj);
    }

    private void checkActive(){
        if (!isActive) {
            throw new StopedMathRepository("Method not Allowed");
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
