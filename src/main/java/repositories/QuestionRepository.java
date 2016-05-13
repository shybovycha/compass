package repositories;

import entities.Question;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by shybovycha on 13/05/16.
 */
public interface QuestionRepository extends CrudRepository<Question, Long> {
}
