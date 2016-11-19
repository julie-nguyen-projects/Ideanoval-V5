package fr.humanbooster.ideanoval.dao.impl;

import fr.humanbooster.ideanoval.business.Comment;
import fr.humanbooster.ideanoval.dao.CommentDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * Created by Julie on 19/11/2016.
 */
@Repository
@Primary
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private SessionFactory sf;

    public CommentDaoImpl() {
    }

    public CommentDaoImpl(SessionFactory sessionFactory) {
    }

    @Override
    public void addComment(Comment comment) {
        sf.getCurrentSession().save(comment);
    }
}
