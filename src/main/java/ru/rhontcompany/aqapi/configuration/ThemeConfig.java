package ru.rhontcompany.aqapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.rhontcompany.aqapi.servises.api.QuestionRepository;
import ru.rhontcompany.aqapi.servises.api.QuestionService;
import ru.rhontcompany.aqapi.servises.apiimpl.JavaQuestionServiceImpl;
import ru.rhontcompany.aqapi.servises.apiimpl.MathQuestionServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class ThemeConfig {

    QuestionRepository javaQuestionRepository;

    @Bean
    public List<QuestionService> mathAndJava() {
        List<QuestionService> themeList = new ArrayList<>();
        themeList.add(new JavaQuestionServiceImpl(javaQuestionRepository));
        themeList.add(new MathQuestionServiceImpl(myRandom()));
        return themeList;
    }

    @Bean
    public Random myRandom(){
        return new Random();
    }
}
