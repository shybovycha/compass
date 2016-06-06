package pl.edu.uj.compass.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.uj.compass.entities.Answer;
import pl.edu.uj.compass.entities.Question;
import pl.edu.uj.compass.entities.QuestionOption;
import pl.edu.uj.compass.entities.Search;
import pl.edu.uj.compass.repositories.AnswerRepository;
import pl.edu.uj.compass.repositories.OptionRepository;
import pl.edu.uj.compass.repositories.QuestionRepository;
import pl.edu.uj.compass.repositories.SearchRepository;

import java.util.Arrays;

@EnableJpaRepositories("pl.edu.uj.compass.repositories")
@EntityScan("pl.edu.uj.compass.entities")
@ComponentScan(basePackages = { "pl.edu.uj.compass.matcher", "pl.edu.uj.compass.controllers" })
@RestController
@RequestMapping("/answers")
public class AnswerController {
    @Autowired
    protected QuestionRepository questionRepository;

    @Autowired
    protected OptionRepository optionRepository;

    @Autowired
    protected AnswerRepository answerRepository;

    @Autowired
    protected SearchRepository searchRepository;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    void create(@RequestParam("search_id") Long searchId, @RequestParam("question_id") Long questionId, @RequestParam("question_option_id") Long questionOptionId) {
        Search s = searchRepository.findOne(searchId);
        Question q = questionRepository.findOne(questionId);
        QuestionOption o = optionRepository.findOne(questionOptionId);
        Answer answer = new Answer(s, q, Arrays.asList(o));
        answerRepository.save(answer);
        s.getAnswers().add(answer);
        searchRepository.save(s);
    }
}
