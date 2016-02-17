package co.alexis.spring.repository;

import java.util.List;

import co.alexis.spring.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

	List<Customer> findById(Long id);
}