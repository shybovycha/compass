package repositories;

import entities.Course;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by shybovycha on 13/05/16.
 */
public interface CourseRepository extends CrudRepository<Course, Long> {
}
