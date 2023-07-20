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
        // Если вопрос один дергаем его по Java
        if (amount == 1) {
            serviceList.get(0).getRandomQuestion();
        }

        int sizeJava=serviceList.get(0).getAll().size();

        int amountQuestionJava;
        int amountQuestionMath;

        if (amount>sizeJava) {
            amountQuestionJava = myRandom.nextInt(sizeJava-1) + 1;
        } else {
            amountQuestionJava = myRandom.nextInt(amount -1) + 1;
        }


        amountQuestionMath = amount - amountQuestionJava;


        Set<Question> resultSet = new HashSet<>();
        resultSet.addAll(getJavaRandomQuestion(amountQuestionJava));
        resultSet.addAll(getMathRandomQuestion(amountQuestionMath));

        return resultSet;
    }

    private Collection<Question> getMathRandomQuestion(int amountQuestionMath) {
        Set<Question> mathSet = new HashSet<>();
        for (int i = 0; i < amountQuestionMath; i++) {
            mathSet.add(serviceList.get(1).getRandomQuestion());
        }
        return mathSet;
    }

    private Collection<Question> getJavaRandomQuestion(int amountQuestionJava) {

        // Создаем массив из сета, чтобы иметь возможность случайным числом проходиться по индексам.
        List<Question> questionList=new ArrayList<>(serviceList.get(0).getAll());

        int counter=questionList.size();
        int randomValue = myRandom.nextInt(counter);

        // Результирующий сет с вопросами.
        Set<Question> setRandomQuestion = new HashSet<>();

        for (int i = 0; i < amountQuestionJava; i++) {
            Question temp = questionList.get(randomValue);
            while (setRandomQuestion.contains(temp)) {
                randomValue = myRandom.nextInt(counter);
                temp = questionList.get(randomValue);
            }
            setRandomQuestion.add(temp);
            questionList.remove(temp);
            counter--;
            randomValue = myRandom.nextInt(counter);
        }

        return setRandomQuestion;
    }
}
