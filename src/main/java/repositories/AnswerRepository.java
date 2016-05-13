package repositories;

import entities.Answer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by shybovycha on 13/05/16.
 */
public interface AnswerRepository extends CrudRepository<Answer, Long> {
}
