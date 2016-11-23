package fr.humanbooster.ideanoval.dao.impl;

import fr.humanbooster.ideanoval.business.IdeaAlert;
import fr.humanbooster.ideanoval.dao.IdeaAlertDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * Created by Julie on 20/11/2016.
 */
@Repository
@Primary
public class IdeaAlertDaoImpl implements IdeaAlertDao {

    @Autowired
    private SessionFactory sf;

    public IdeaAlertDaoImpl() {
    }

    public IdeaAlertDaoImpl(SessionFactory sessionFactory) {
    }

    @Override
    public void createIdeaAlert(IdeaAlert ideaAlert) {
        sf.getCurrentSession().save(ideaAlert);
    }
}
