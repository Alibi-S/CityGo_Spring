package user_microservice.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user_microservice.user.DAO.UserDAO;
import user_microservice.user.model.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public List<User> findAllUsers() {return userDAO.findAll();}

    public Optional<User> findUserById(Long id) {return userDAO.findById(id);}

    public Optional<User> findUserByName(String name) {return userDAO.findUsersByName(name);}

    public Optional<User> findUserByEmail(String email) {return userDAO.findUsersByEmail(email);}

    public void createUser(User user) {
        userDAO.save(user);
    }

    public void updateUser(User user) {
        User originalUser = userDAO.getById((long) user.getId());
        if(originalUser != null) {
            userDAO.save(user);
        }
    }

    public void deleteUser(User user) {
        userDAO.delete(user);
    }
}
