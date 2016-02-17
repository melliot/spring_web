package co.alexis.spring.repository;

import co.alexis.spring.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();

	User save(User user);

	User findByName(String name);
}
