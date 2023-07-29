package ru.rhontcompany.aqapi.servises.api;

import ru.rhontcompany.aqapi.servises.apiimpl.Question;

import java.util.Collection;

public interface QuestionService {
    Question remove(Question question);

    Question add(Question question);

    Question add(String question, String answer);

    Question getRandomQuestion();

    Collection<Question> getAll();

}
