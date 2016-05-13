package repositories;

import entities.OrgQuestion;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by shybovycha on 13/05/16.
 */
public interface OrgQuestionRepository extends CrudRepository<OrgQuestion, Long> {
}
