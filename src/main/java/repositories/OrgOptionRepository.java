package repositories;

import entities.OrgQuestionOption;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by shybovycha on 13/05/16.
 */
public interface OrgOptionRepository extends CrudRepository<OrgQuestionOption, Long> {
}
