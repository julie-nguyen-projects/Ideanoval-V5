package fr.humanbooster.ideanoval.dao.impl;

import fr.humanbooster.ideanoval.business.User;
import fr.humanbooster.ideanoval.dao.UserDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Nea on 15/11/2016.
 */
@Repository
@Primary
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sf;

    public UserDaoImpl() {

    }

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sf = sessionFactory;
    }

    @Override
    public long saveUser(User user) {
        sf.getCurrentSession().save(user);
        return user.getId();
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        User userTryingToConnect = null;
        String hql = "FROM User WHERE email= :email AND password= :password";
        Query query = sf.getCurrentSession().createQuery(hql);
        query.setParameter("email", email);
        query.setParameter("password", password);
        List results = query.getResultList();

        if (results.size() == 1) {
            userTryingToConnect = (User) results.get(0);
        }
        return userTryingToConnect;
    }

    @Override
    public User findUserById(long id) {
        return sf.getCurrentSession().byId(User.class).load(id);
    }
}
