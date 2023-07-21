package ru.rhontcompany.aqapi.servises.api;

import ru.rhontcompany.aqapi.servises.apiimpl.Question;

import java.util.Collection;

public interface QuestionRepository {

    Question remove(Question question);

    Question add(Question question);

    Question add(String question, String answer);

    Collection<Question> getAll();

}
