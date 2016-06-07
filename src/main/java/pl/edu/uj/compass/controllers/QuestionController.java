package pl.edu.uj.compass.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;
import pl.edu.uj.compass.entities.Answer;
import pl.edu.uj.compass.entities.Question;
import pl.edu.uj.compass.entities.Search;
import pl.edu.uj.compass.repositories.QuestionRepository;
import pl.edu.uj.compass.repositories.SearchRepository;

import java.util.List;
import java.util.stream.Collectors;

@EnableJpaRepositories("pl.edu.uj.compass.repositories")
@EntityScan("pl.edu.uj.compass.entities")
@ComponentScan(basePackages = { "pl.edu.uj.compass.matcher", "pl.edu.uj.compass.controllers" })
@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    protected QuestionRepository questionRepository;

    @Autowired
    protected SearchRepository searchRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    List<Question> all() {
        return (List<Question>) questionRepository.findAll();
    }

    @RequestMapping(value = "/{searchId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    List<Question> forSearch(@PathVariable("searchId") Long searchId) {
        Search search = searchRepository.findOne(searchId);
        List<Question> answeredQuestions = search.getAnswers().stream().map(Answer::getQuestion).collect(Collectors.toList());
        List<Question> questions = (List<Question>) questionRepository.findAll();

        return questions.stream().filter(q -> !answeredQuestions.contains(q)).collect(Collectors.toList());
    }
}
