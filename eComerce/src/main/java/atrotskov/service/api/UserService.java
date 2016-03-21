package atrotskov.service.api;

import atrotskov.model.User;

import java.util.List;

/**
 * Created by jdev on 29.02.2016.
 */
public interface UserService {
        User create(User user);
        User getById(Long id);
        boolean delete(User user);
        User update(User user);
        List<User> getAll();
        User findByEmail(String email);
}
