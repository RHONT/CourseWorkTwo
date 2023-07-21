package ru.rhontcompany.aqapi.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rhontcompany.aqapi.servises.api.QuestionService;
import ru.rhontcompany.aqapi.servises.apiimpl.Question;
import java.util.Collection;

@RestController
@RequestMapping(path = "exam/math")
public class MathController {

    private final QuestionService mathService;

    public MathController(@Qualifier("mathQuestionServiceImpl") QuestionService questionService) {
        this.mathService = questionService;
    }

    @GetMapping(path = "add")
    public Question add(@RequestParam(name = "q") String question,
                        @RequestParam(name = "a") String answer){

        return mathService.add(question,answer);
    }

    @GetMapping(path = "remove")
    public Question remove(@RequestParam(name = "q") String question,
                           @RequestParam(name = "a") String answer){
        Question questionObj = new Question(question, answer);
        return mathService.remove(questionObj);
    }

    @GetMapping(path = "get")
    public Collection<Question> getAll(){
        return mathService.getAll();
    }
}
