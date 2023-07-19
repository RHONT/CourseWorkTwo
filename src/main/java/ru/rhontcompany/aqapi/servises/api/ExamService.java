package ru.rhontcompany.aqapi.servises.api;

import ru.rhontcompany.aqapi.servises.apiimpl.Question;

import java.util.Collection;

public interface ExamService {
    Collection<Question> getRandomCollect(int amount);
}
