package fr.humanbooster.ideanoval.dao;

import fr.humanbooster.ideanoval.business.Comment;
import fr.humanbooster.ideanoval.business.User;

import java.util.List;

/**
 * Created by Julie on 19/11/2016.
 */
public interface CommentDao {

    public void addComment(Comment comment);

    public List<Comment> getAllComments();
}
