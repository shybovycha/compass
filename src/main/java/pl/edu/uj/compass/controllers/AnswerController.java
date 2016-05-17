package pl.edu.uj.compass.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.uj.compass.entities.Answer;
import pl.edu.uj.compass.repositories.AnswerRepository;

@EnableJpaRepositories("pl.edu.uj.compass.repositories")
@EntityScan("pl.edu.uj.compass.entities")
@ComponentScan(basePackages = { "pl.edu.uj.compass.matcher", "pl.edu.uj.compass.controllers" })
@RestController
@RequestMapping("/answers")
public class AnswerController {
    @Autowired
    protected AnswerRepository answerRepository;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    void create(@RequestBody Answer answer) {
        answerRepository.save(answer);
    }
}
