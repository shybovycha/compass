package repositories;

import entities.CourseQuestionOption;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by shybovycha on 13/05/16.
 */
public interface CourseOptionRepository extends CrudRepository<CourseQuestionOption, Long> {
}
