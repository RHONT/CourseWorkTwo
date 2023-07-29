package ru.rhontcompany.aqapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rhontcompany.aqapi.servises.api.ExamService;
import ru.rhontcompany.aqapi.servises.apiimpl.Question;

import java.util.Collection;

@RestController
@RequestMapping(path = "exam/")
public class ExamController {
    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping(path = "get/{amount}")
    public Collection<Question> getQuestions(@PathVariable(name = "amount") int amountQuestions){
        return examService.getRandomCollect(amountQuestions);
    }

}
