package fr.humanbooster.ideanoval.dao;

import fr.humanbooster.ideanoval.business.Comment;

import java.util.List;

/**
 * Created by Julie on 19/11/2016.
 */
public interface CommentDao {

    public void addComment(Comment comment);

    public List getAllComments();

    public List getAllCommentsOfAnIdea(long idIdea);
}
