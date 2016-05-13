package repositories;

import entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by shybovycha on 13/05/16.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
