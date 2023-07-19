package ru.rhontcompany.aqapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rhontcompany.aqapi.servises.api.QuestionRepository;
import ru.rhontcompany.aqapi.servises.api.QuestionService;
import ru.rhontcompany.aqapi.servises.apiimpl.Question;

import java.util.Collection;

//(”/exam/java/(add/remove/find)”)
@RestController
@RequestMapping(path = "exam/java")
public class JavaController {

    private final QuestionRepository questionRepository;

    public JavaController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping(path = "add")
    public Question add(@RequestParam(name = "q") String question,
                        @RequestParam(name = "a") String answer) {
        Question questionObj = new Question(question, answer);
        return questionRepository.add(questionObj);
    }

    @GetMapping(path = "remove")
    public Question remove(@RequestParam(name = "q") String question,
                           @RequestParam(name = "a") String answer) {
        Question questionObj = new Question(question, answer);
        return questionRepository.remove(questionObj);
    }

    @GetMapping(path = "get")
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @GetMapping(path = "find")
    public Question find(@RequestParam(name = "q") String question,
                         @RequestParam(name = "a") String answer) {
        Question questionObj = new Question(question, answer);
        return questionRepository.find(questionObj);
    }
}
