package fr.humanbooster.ideanoval.service;

import fr.humanbooster.ideanoval.business.Comment;
import fr.humanbooster.ideanoval.business.User;

/**
 * Created by Nea on 23/11/2016.
 */
public interface CommentAlertService {

    public void createCommentAlert(User user, String motive, String description, Comment comment);
}
