package pl.edu.uj.compass.matcher;

import pl.edu.uj.compass.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.uj.compass.repositories.CourseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by shybovycha on 13/05/16.
 */
@Service
public class CourseMatcher {
    @Autowired
    private CourseRepository courseRepository;

    public CourseMatcher() {
    }

    public List<RankedCourseMatch> match(Search search) {
        int _s1 = search.getAnswers().size();
        List<Question> answeredQuestions = search.getAnswers().stream().map(Answer::getQuestion).collect(Collectors.toList());
        List<RankedCourseMatch> result = new ArrayList<>();

        return StreamSupport.stream(courseRepository.findAll().spliterator(), false)
                .map(course -> {
                    List<CourseQuestion> courseQuestions = course.getCourseQuestions();

                    Integer weight = courseQuestions
                            .stream()
                            .filter(cq -> answeredQuestions.stream().anyMatch(aq -> aq.getId() == cq.getQuestion().getId()))
                            .collect(Collectors.toMap(Function.identity(), q -> search.getAnswers().stream().filter(a -> a.getQuestion().getId() == q.getQuestion().getId()).findFirst().get()))
                            .entrySet()
                            .stream()
                            .map(pair -> pair.getKey().getCourseQuestionOptions()
                                    .stream()
                                    .filter(cqo -> pair.getValue().getQuestionOptions().stream().anyMatch(qo -> qo.getId() == cqo.getQuestionOption().getId()))
                                    .map(CourseQuestionOption::getWeight)
                                    .collect(Collectors.summingInt(Integer::intValue)))
                            .collect(Collectors.summingInt(Integer::intValue));

                    return new RankedCourseMatch(course, weight);
                }).collect(Collectors.toList());
    }
}
