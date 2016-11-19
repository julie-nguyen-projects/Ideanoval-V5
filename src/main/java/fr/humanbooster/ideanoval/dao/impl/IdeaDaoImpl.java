package fr.humanbooster.ideanoval.dao.impl;

import fr.humanbooster.ideanoval.business.Idea;
import fr.humanbooster.ideanoval.dao.IdeaDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Nea on 14/11/2016.
 */
@Repository
@Primary
public class IdeaDaoImpl implements IdeaDao {

    @Autowired
    private SessionFactory sf;

    public IdeaDaoImpl() {
    }

    public IdeaDaoImpl(SessionFactory sessionFactory) {
    }

    @Override
    public List findAllIdeas() {
        return sf.getCurrentSession().createQuery("FROM Idea").getResultList();
    }

    @Override
    public void createIdea(Idea idea) {
        sf.getCurrentSession().save(idea);
    }

    @Override
    public Idea findIdeaById(long id) {
        return sf.getCurrentSession().byId(Idea.class).load(id);
    }
}
