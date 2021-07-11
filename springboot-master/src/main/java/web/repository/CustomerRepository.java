package web.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.model.Customer;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query(value = "SELECT u FROM Customer u where u.userName = ?1 and u.password = ?2 ")
    Optional<Customer> login(String username, String password);
    @Query(value = "SELECT u FROM Customer u where u.token = ?1 ")
    Optional<Customer> findByToken(String token);
    @Query(value = "SELECT u FROM Customer u where u.userName = ?1 ")
    List<Optional<Customer>> findByUserName(String username);
}