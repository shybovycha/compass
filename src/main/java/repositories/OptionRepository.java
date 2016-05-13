package repositories;

import entities.QuestionOption;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by shybovycha on 13/05/16.
 */
public interface OptionRepository extends CrudRepository<QuestionOption, Long> {
}
