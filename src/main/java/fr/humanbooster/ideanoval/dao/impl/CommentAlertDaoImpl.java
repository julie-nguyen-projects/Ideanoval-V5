package fr.humanbooster.ideanoval.dao.impl;

import fr.humanbooster.ideanoval.business.CommentAlert;
import fr.humanbooster.ideanoval.dao.CommentAlertDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * Created by Nea on 23/11/2016.
 */
@Repository
@Primary
public class CommentAlertDaoImpl implements CommentAlertDao {

    @Autowired
    private SessionFactory sf;

    public CommentAlertDaoImpl() {
    }

    public CommentAlertDaoImpl(SessionFactory sessionFactory) {
    }

    @Override
    public void createCommentAlert(CommentAlert commentAlert) {
        sf.getCurrentSession().save(commentAlert);
    }
}
