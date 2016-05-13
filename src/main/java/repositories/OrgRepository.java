package repositories;

import entities.Org;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by shybovycha on 13/05/16.
 */
public interface OrgRepository extends CrudRepository<Org, Long> {
}
