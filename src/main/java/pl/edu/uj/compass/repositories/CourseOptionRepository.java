package pl.edu.uj.compass.repositories;

import pl.edu.uj.compass.entities.CourseQuestionOption;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by shybovycha on 13/05/16.
 */
public interface CourseOptionRepository extends CrudRepository<CourseQuestionOption, Long> {
}
