package fr.humanbooster.ideanoval.service;

import fr.humanbooster.ideanoval.business.Idea;
import fr.humanbooster.ideanoval.business.User;
import fr.humanbooster.ideanoval.business.Vote;

/**
 * Created by Julie on 20/11/2016.
 */
public interface VoteService {
    
    public void addTopVote(User user, Idea idea);

    public void addFlopVote(User user, Idea idea);

    public Vote findVoteByUserAndIdea(User user, Idea idea);
}
