package fr.humanbooster.ideanoval.service.impl;

import fr.humanbooster.ideanoval.business.Comment;
import fr.humanbooster.ideanoval.business.Idea;
import fr.humanbooster.ideanoval.business.User;
import fr.humanbooster.ideanoval.dao.CommentDao;
import fr.humanbooster.ideanoval.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Julie on 19/11/2016.
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao cd;

    public CommentServiceImpl() {
    }

    @Override
    public void addComment(String content, User user, Idea idea) {
        Comment comment = new Comment(content, user, idea);
        cd.addComment(comment);
    }

    @Override
    public List getAllComments() {
        return cd.getAllComments();
    }

    @Override
    public List getAllCommentsOfAnIdea(long idIdea) {
        return cd.getAllCommentsOfAnIdea(idIdea);
    }

    @Override
    public Comment getCommentById(String idComment) {
        if (idComment == null) {
            return null;
        } else {
            Comment comment = cd.getCommentById(Long.parseLong(idComment));
            return comment;
        }
    }
}
