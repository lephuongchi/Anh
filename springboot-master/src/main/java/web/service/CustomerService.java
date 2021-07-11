package web.service;
import org.springframework.security.core.userdetails.User;
import web.model.Customer;

import java.util.Optional;

public interface CustomerService {
    String login(String username, String password);
    Optional<User> findByToken(String token);
    Customer findById(Long id);
    void saveCustomer(Customer customer);
}
