package pl.edu.uj.compass.repositories;

import pl.edu.uj.compass.entities.CourseQuestion;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by shybovycha on 13/05/16.
 */
public interface CourseQuestionRepository extends CrudRepository<CourseQuestion, Long> {
}
