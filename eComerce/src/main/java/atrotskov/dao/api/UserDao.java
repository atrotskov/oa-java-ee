package atrotskov.dao.api;

import atrotskov.model.User;
import java.util.List;

public interface UserDao {

	User create(User user);
	User getById(Long id);
	boolean delete(User user);
	User update(User user);
	List<User> getAll();

	User findByEmail(String email);

}
