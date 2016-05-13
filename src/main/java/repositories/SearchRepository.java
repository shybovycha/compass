package repositories;

import entities.Search;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by shybovycha on 13/05/16.
 */
public interface SearchRepository extends CrudRepository<Search, Long> {
}
