package fr.humanbooster.ideanoval.dao.impl;

import fr.humanbooster.ideanoval.business.Comment;
import fr.humanbooster.ideanoval.dao.CommentDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List getAllComments() {
        return  sf.getCurrentSession().createQuery("FROM Comment ").getResultList();
    }

    @Override
    public List getAllCommentsOfAnIdea(long idIdea) {
        return sf.getCurrentSession().createQuery("FROM Comment WHERE idea.id=:idIdea")
                .setParameter("idIdea", idIdea)
                .getResultList();
    }

    @Override
    public Comment getCommentById(long idComment) {
        return sf.getCurrentSession().byId(Comment.class).load(idComment);
    }
}
