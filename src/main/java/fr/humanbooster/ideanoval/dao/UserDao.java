package fr.humanbooster.ideanoval.dao;

import fr.humanbooster.ideanoval.business.User;

/**
 * Created by Nea on 15/11/2016.
 */
public interface UserDao {

    public long saveUser(User user);

    public User findUserByEmailAndPassword(String email, String password);

    public User findUserById(long id);
}
