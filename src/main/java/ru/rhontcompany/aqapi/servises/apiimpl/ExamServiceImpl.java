package ru.rhontcompany.aqapi.servises.apiimpl;

import org.springframework.stereotype.Service;
import ru.rhontcompany.aqapi.servises.api.ExamService;
import ru.rhontcompany.aqapi.servises.api.QuestionService;
import ru.rhontcompany.aqapi.servises.apiimpl.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExamServiceImpl implements ExamService {

    private Random random;
    private final QuestionService questionService;



    public ExamServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
        random=new Random();

    }

    @Override
    public Collection<Question> getRandomCollect(int amount) {
        if (amount<1) {
            throw new IllegalArgumentException("Значение отрицательное!");
        }
        if (amount==1) {
            questionService.getRandomQuestion();
        }
        Question[] questionsArray=questionService.getAll().toArray(new Question[0]);

        if (questionsArray.length<amount) {
            throw new IllegalArgumentException("Количество вопросов превышает список");
        }

        Set<Question> setOriginal= new HashSet<>(questionService.getAll());
        int randomValue=random.nextInt(questionsArray.length);

        Set<Question> setRandomQuestion=new HashSet<>();
        for (int i = 0; i < amount; i++) {
            Question temp=questionsArray[randomValue];
            while (!setOriginal.contains(temp)){
                randomValue=random.nextInt(questionsArray.length);
                temp=questionsArray[randomValue];
            }
            setRandomQuestion.add(temp);
            setOriginal.remove(temp);
        }
        return setRandomQuestion;
    }
}
