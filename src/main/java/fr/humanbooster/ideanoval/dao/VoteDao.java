package fr.humanbooster.ideanoval.dao;

import fr.humanbooster.ideanoval.business.Idea;
import fr.humanbooster.ideanoval.business.User;
import fr.humanbooster.ideanoval.business.Vote;

/**
 * Created by Julie on 20/11/2016.
 */
public interface VoteDao {

    public void addVote(Vote vote);

    public Vote findVoteByUserAndIdea(User user, Idea idea);
}
