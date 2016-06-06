package pl.edu.uj.compass.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;
import pl.edu.uj.compass.entities.Search;
import pl.edu.uj.compass.repositories.SearchRepository;

import java.util.List;

@EnableJpaRepositories("pl.edu.uj.compass.repositories")
@EntityScan("pl.edu.uj.compass.entities")
@ComponentScan(basePackages = { "pl.edu.uj.compass.matcher", "pl.edu.uj.compass.controllers" })
@RestController
@RequestMapping("/searches")
public class SearchController {
    @Autowired
    protected SearchRepository searchRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    List<Search> all() {
        return (List<Search>) searchRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    Search read(@PathVariable("id") Long searchId) {
        return searchRepository.findOne(searchId);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    Search create() {
        Search search = new Search();

        searchRepository.save(search);

        return search;
    }
}
