package fr.humanbooster.ideanoval.dao.impl;

import fr.humanbooster.ideanoval.business.Idea;
import fr.humanbooster.ideanoval.business.User;
import fr.humanbooster.ideanoval.business.Vote;
import fr.humanbooster.ideanoval.dao.VoteDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Julie on 20/11/2016.
 */
@Repository
@Primary
public class VoteDaoImpl implements VoteDao{

    @Autowired
    private SessionFactory sf;

    public VoteDaoImpl() {
    }

    public VoteDaoImpl(SessionFactory sessionFactory) {
    }

    @Override
    public void addVote(Vote vote) {
        sf.getCurrentSession().save(vote);
    }

    @Override
    public Vote findVoteByUserAndIdea(User user, Idea idea) {
        Vote vote = null;
        List results = sf.getCurrentSession()
                .createQuery("FROM Vote WHERE user.id=:idUser AND idea.id=:idIdea")
                .setParameter("idUser", user.getId())
                .setParameter("idIdea", idea.getIdIdea())
                .getResultList();

        if (results.size() == 1) {
            vote = (Vote) results.get(0);
        }
        return vote;
    }

    @Override
    public List getAllVotes() {
        return sf.getCurrentSession().createQuery("FROM Vote ").getResultList();
    }
}
