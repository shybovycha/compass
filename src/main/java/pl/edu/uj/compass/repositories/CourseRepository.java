package pl.edu.uj.compass.repositories;

import pl.edu.uj.compass.entities.Course;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by shybovycha on 13/05/16.
 */
public interface CourseRepository extends CrudRepository<Course, Long> {
    Course findByName(String name);
}
