package atrotskov.dao.impl;

import atrotskov.dao.api.UserDao;
import atrotskov.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jdev on 15.02.2016.
 */
//@Repository
public class UserDaoImpl implements UserDao {

    public static final UserDaoImpl instance = new UserDaoImpl();

    private static Map<Long,User> storage = new HashMap<>();
    private static long nextId = 0;

    @Override
    public User create(User user) {
        user.setId(nextId);
        nextId++;
        storage.put(user.getId(), user);
        return user;
    }

    @Override
    public User getById(Long id) {
        return storage.get(id);
    }

    @Override
    public boolean delete(User user) {
        boolean resoult = false;
        if (storage.containsKey(user.getId())){
            storage.remove(user.getId());
            resoult = true;
        }
        return resoult;
    }

    @Override
    public User update(User user) {
            storage.put(user.getId(), user);
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> listOfUsers = new ArrayList<>();
        listOfUsers.addAll(storage.values());
        return listOfUsers;
    }
}
