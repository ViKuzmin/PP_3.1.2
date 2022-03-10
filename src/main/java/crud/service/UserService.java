package crud.service;

import crud.models.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {

     UserDetails loadUserByUsername(String username);

    User findById(Long userId);

    List<User> findAll();

    boolean save(User user);

    boolean delete(Long userId);

    List<User> usergetList(Long idMin);

    User findByUsername(String username);
}
