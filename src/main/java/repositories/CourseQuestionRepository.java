package repositories;

import entities.CourseQuestion;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by shybovycha on 13/05/16.
 */
public interface CourseQuestionRepository extends CrudRepository<CourseQuestion, Long> {
}
