package service;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import model.User;

public class AuthService {

    private final UserDAO userDAO = new UserDAOImpl();

    public boolean register(User user) {
        return userDAO.register(user);
    }

    public User login(String username, String password) {
        return userDAO.login(username, password);
    }
}