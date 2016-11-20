package fr.humanbooster.ideanoval.service.impl;

import fr.humanbooster.ideanoval.business.Idea;
import fr.humanbooster.ideanoval.business.User;
import fr.humanbooster.ideanoval.business.Vote;
import fr.humanbooster.ideanoval.dao.VoteDao;
import fr.humanbooster.ideanoval.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Julie on 20/11/2016.
 */
@Service
@Transactional
public class VoteServiceImpl implements VoteService{

    @Autowired
    private VoteDao vd;

    public VoteServiceImpl() {
    }

    @Override
    public void addTopVote(User user, Idea idea) {
        Vote vote = new Vote(1, user, idea);
        vd.addVote(vote);
    }

    @Override
    public void addFlopVote(User user, Idea idea) {
        Vote vote = new Vote(-1, user, idea);
        vd.addVote(vote);
    }

    @Override
    public Vote findVoteByUserAndIdea(User user, Idea idea) {
        return vd.findVoteByUserAndIdea(user, idea);
    }
}
