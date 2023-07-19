package ru.rhontcompany.aqapi.servises.apiimpl;

import org.springframework.stereotype.Service;
import ru.rhontcompany.aqapi.servises.api.QuestionRepository;
import ru.rhontcompany.aqapi.servises.api.QuestionService;

import java.util.Collection;
import java.util.Random;

@Service
public class JavaQuestionServiceImpl implements QuestionService {

    final QuestionRepository questionRepository;

    public JavaQuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }



    @Override
    public Question getRandomQuestion() {
        return questionRepository.getRandomQuestion();
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }
}
