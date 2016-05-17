package pl.edu.uj.compass.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;
import pl.edu.uj.compass.entities.Course;
import pl.edu.uj.compass.entities.Search;
import pl.edu.uj.compass.matcher.CourseMatcher;
import pl.edu.uj.compass.matcher.RankedCourseMatch;
import pl.edu.uj.compass.repositories.SearchRepository;

import java.util.List;
import java.util.stream.Collectors;

@EnableJpaRepositories("pl.edu.uj.compass.repositories")
@EntityScan("pl.edu.uj.compass.entities")
@ComponentScan(basePackages = { "pl.edu.uj.compass.matcher", "pl.edu.uj.compass.controllers" })
@RestController
@RequestMapping("/match")
public class MatchController {
    @Autowired
    protected SearchRepository searchRepository;

    @Autowired
    protected CourseMatcher matcher;

    @RequestMapping(value = "/{searchId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    List<Course> match(@PathVariable("searchId") Long searchId) {
        Search search = searchRepository.findOne(searchId);
        List<RankedCourseMatch> matches = matcher.match(search);

        return matches.stream()
                .sorted((c1, c2) -> Long.compare(c2.getRank(), c1.getRank()))
                .map(RankedCourseMatch::getCourse)
                .collect(Collectors.toList());
    }
}
