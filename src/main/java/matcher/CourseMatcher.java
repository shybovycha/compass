package matcher;

import entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CourseQuestionRepository;
import repositories.CourseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by shybovycha on 13/05/16.
 */
@Service
public class CourseMatcher {
    @Autowired
    private CourseQuestionRepository courseQuestionRepository;

    @Autowired
    private CourseRepository courseRepository;

    public CourseMatcher() {
    }

    public List<RankedCourseMatch> match(Search search) {
        List<Question> answeredQuestions = search.getAnswers().stream().map(Answer::getQuestion).collect(Collectors.toList());
        List<RankedCourseMatch> result = new ArrayList<>();

        return StreamSupport.stream(courseRepository.findAll().spliterator(), false)
                .map(course -> {
                    List<CourseQuestion> csqs1 = course.getCourseQuestions()
                            .stream()
                            .filter(cq -> answeredQuestions.stream().anyMatch(aq -> aq.getId() == cq.getQuestion().getId()))
                            .collect(Collectors.toList());

                    Map<CourseQuestion, Answer> courseQuestionWithAnswers = csqs1
                            .stream()
                            .collect(Collectors.toMap(Function.identity(), q -> search.getAnswers().stream().filter(a -> a.getQuestion().getId() == q.getQuestion().getId()).findFirst().get()));

                    Integer weight = courseQuestionWithAnswers.entrySet()
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

    private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
