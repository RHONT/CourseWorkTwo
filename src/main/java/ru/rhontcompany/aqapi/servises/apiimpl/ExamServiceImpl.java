package ru.rhontcompany.aqapi.servises.apiimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.rhontcompany.aqapi.servises.api.ExamService;
import ru.rhontcompany.aqapi.servises.api.QuestionService;

import java.util.*;

@Service
public class ExamServiceImpl implements ExamService {


    private final Random myRandom;
//    private final QuestionService questionService;

    @Qualifier("mathAndJava")
    private final List<QuestionService> serviceList;


//    public ExamServiceImpl(QuestionService questionService) {
//        this.questionService = questionService;
//        random=new Random();
//
//    }

    public ExamServiceImpl(Random myRandom, List<QuestionService> serviceList) {
        this.myRandom = myRandom;
        this.serviceList = serviceList;
    }


//    public ExamServiceImpl(List<QuestionService> serviceList) {
////        this.random = new Random();
//        this.serviceList = serviceList;
//    }

    @Override
    public Collection<Question> getRandomCollect(int amount) {
        if (amount < 1) {
            throw new IllegalArgumentException("Значение отрицательное!");
        }
        // Если вопрос один дергаем его по Java
        if (amount == 1) {
            serviceList.get(0).getRandomQuestion();
        }

        int amountQuestionJava=myRandom.nextInt(amount+1)+1;
        int amountQuestionMath=amount-amountQuestionJava;

        Set<Question> resultSet=new HashSet<>();
        resultSet.addAll(getJavaRandomQuestion(amountQuestionJava));
        resultSet.addAll(getMathRandomQuestion(amountQuestionMath));

        return resultSet;
    }

    private Collection<Question> getMathRandomQuestion(int amountQuestionMath) {
        Set<Question> mathSet=new HashSet<>();
        for (int i = 0; i < amountQuestionMath; i++) {
            mathSet.add(serviceList.get(1).getRandomQuestion());
        }
        return mathSet;
    }

    private Collection<Question> getJavaRandomQuestion(int amountQuestionJava) {

        // Создаем массив из сета, чтобы иметь возможность случайным числом проходиться по индексам.
        Question[] questionsArray = serviceList.get(0).getAll().toArray(new Question[0]);

        // Создаем копию сета оригинала, чтобы удалять вопросы, которые уже попались.
        Set<Question> setOriginal = new HashSet<>(serviceList.get(0).getAll());

        int randomValue = myRandom.nextInt(questionsArray.length);

        // Результирующий сет с вопросами.
        Set<Question> setRandomQuestion = new HashSet<>();

        for (int i = 0; i < amountQuestionJava; i++) {
            Question temp = questionsArray[randomValue];
            while (!setOriginal.contains(temp)) {
                randomValue = myRandom.nextInt(questionsArray.length);
                temp = questionsArray[randomValue];
            }
            setRandomQuestion.add(temp);
            setOriginal.remove(temp);
        }


        return setRandomQuestion;
    }
}
