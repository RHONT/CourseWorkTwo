package ru.rhontcompany.aqapi.servises.apiimpl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.rhontcompany.aqapi.servises.api.ExamService;
import ru.rhontcompany.aqapi.servises.api.QuestionService;
import java.util.*;

@Service
public class ExamServiceImpl implements ExamService {

    private final Random myRandom;

    @Qualifier("mathAndJava")
    private final List<QuestionService> serviceList;

    public ExamServiceImpl(Random myRandom, List<QuestionService> serviceList) {
        this.myRandom = myRandom;
        this.serviceList = serviceList;
    }

    @Override
    public Collection<Question> getRandomCollect(int amount) {
        if (amount < 1) {
            throw new IllegalArgumentException("Значение отрицательное!");
        }

        Set<Question> resultSet = new HashSet<>();

        while (amount>0){
            for (QuestionService questionService : serviceList) {
                if (amount > 0) {
                    Question temp = questionService.getRandomQuestion();
                    if (!resultSet.contains(temp)) {
                        resultSet.add(temp);
                        amount--;
                    }
                } else break;
            }
        }
        return resultSet;
    }
}
