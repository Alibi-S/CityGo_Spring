package com.example.authorizationapi.service;

import com.example.authorizationapi.dao.UserDAO;
import com.example.authorizationapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public void createUser(User user) {
        userDAO.save(user);
    }

    public List<User> getUserList() {
        return userDAO.findAll();
    }

    public boolean getPermissions(String username, String password) {
        List<User> users = userDAO.findAll();
        for (User curUser: users) {
            if (curUser.getUsername().equals(username) && curUser.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
