package fr.humanbooster.ideanoval.service;

import fr.humanbooster.ideanoval.business.Idea;
import fr.humanbooster.ideanoval.business.User;

/**
 * Created by Julie on 19/11/2016.
 */
public interface CommentService {

    public void addComment(String content, User user, Idea idea);
}
