package ru.rhontcompany.aqapi.servises.apiimpl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.rhontcompany.aqapi.servises.api.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class MathQuestionServiceImpl implements QuestionService {

    Random myRandom;

    public MathQuestionServiceImpl(Random random) {
        this.myRandom = random;
    }

    @Override
    public Question getRandomQuestion() {

        Question randomQuestion=new Question("SomeMathQ_"+myRandom.nextInt(100), "SomeMathA_"+myRandom.nextInt(100));
        return randomQuestion;
    }

    @Override
    public Collection<Question> getAll() {
        return null;
    }
}
