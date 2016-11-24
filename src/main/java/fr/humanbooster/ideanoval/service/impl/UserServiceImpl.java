package fr.humanbooster.ideanoval.service.impl;

import fr.humanbooster.ideanoval.business.Role;
import fr.humanbooster.ideanoval.business.User;
import fr.humanbooster.ideanoval.dao.UserDao;
import fr.humanbooster.ideanoval.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;

/**
 * Created by Nea on 15/11/2016.
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao ud;

    @Override
    public long addUser(String pseudo, String email, String password) {
        User user = new User(pseudo, email, password);
        user.setRegisterDateUser(Date.from(Instant.now()));
        user.setRole(ud.findRoleByName("user"));
        return ud.saveUser(user);
    }

    @Override
    public User login(String email, String password) {
        return ud.findUserByEmailAndPassword(email, password);
    }

    @Override
    public User findUserById(String id) {
        if (id == null) {
            return null;
        } else {
            return ud.findUserById(Long.parseLong(id));
        }
    }
}
