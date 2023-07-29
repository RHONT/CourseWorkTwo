package ru.rhontcompany.aqapi.servises.apiimpl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.rhontcompany.aqapi.servises.api.QuestionRepository;
import ru.rhontcompany.aqapi.servises.api.QuestionService;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class JavaQuestionServiceImpl implements QuestionService {

    final QuestionRepository javaQuestionRepository;

    public JavaQuestionServiceImpl(@Qualifier("javaQuestionRepositoryImpl") QuestionRepository questionRepository) {
        this.javaQuestionRepository = questionRepository;
    }

    @Override
    public Question remove(Question question) {
        return javaQuestionRepository.remove(question);
    }

    @Override
    public Question add(Question question) {
        return javaQuestionRepository.add(question);
    }

    @Override
    public Question add(String question, String answer) {
        return javaQuestionRepository.add(question,answer);
    }

    @Override
    public Question getRandomQuestion() {
        int size=javaQuestionRepository.getAll().size();
        return javaQuestionRepository.getAll().stream().skip(new Random().nextInt(size)).findFirst().get();
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }
}
