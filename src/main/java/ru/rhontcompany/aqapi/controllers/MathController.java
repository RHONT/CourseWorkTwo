package ru.rhontcompany.aqapi.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rhontcompany.aqapi.exception.StopedMathRepository;
import ru.rhontcompany.aqapi.servises.apiimpl.Question;

import java.util.Collection;

@RestController
@RequestMapping(path = "exam/math")
public class MathController {

    @GetMapping(path = "add")
    public Question add(@RequestParam(name = "q") String question,
                        @RequestParam(name = "a") String answer){

        throw new StopedMathRepository("Method not Allowed");
    }

    @GetMapping(path = "remove")
    public Question remove(@RequestParam(name = "q") String question,
                           @RequestParam(name = "a") String answer){
        throw new StopedMathRepository("Method not Allowed");
    }

    @GetMapping(path = "get")
    public Collection<Question> getAll(){
        throw new StopedMathRepository("Method not Allowed");
    }
}
