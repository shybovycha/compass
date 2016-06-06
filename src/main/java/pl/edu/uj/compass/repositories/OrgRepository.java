package pl.edu.uj.compass.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.edu.uj.compass.entities.Org;

/**
 * Created by shybovycha on 13/05/16.
 */
public interface OrgRepository extends CrudRepository<Org, Long> {
    Org findByName(String name);
}
