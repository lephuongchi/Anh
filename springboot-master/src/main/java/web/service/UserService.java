package web.service;

import org.springframework.stereotype.Component;
import web.model.User;

@Component
public interface UserService {
    public void saveUser(User user);
}
