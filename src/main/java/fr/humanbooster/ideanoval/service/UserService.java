package fr.humanbooster.ideanoval.service;

import fr.humanbooster.ideanoval.business.User;

/**
 * Created by Nea on 15/11/2016.
 */
public interface UserService {

    public long addUser(String pseudo, String email, String password);

    public User login(String email, String password);

    public User findUserById(String id);
}
