package pl.edu.uj.compass.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.edu.uj.compass.entities.Question;

/**
 * Created by shybovycha on 13/05/16.
 */
public interface QuestionRepository extends CrudRepository<Question, Long> {
    Question findByTitle(String title);
}
