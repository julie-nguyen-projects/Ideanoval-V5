package fr.humanbooster.ideanoval.service.impl;

import fr.humanbooster.ideanoval.business.AlertMotive;
import fr.humanbooster.ideanoval.business.Comment;
import fr.humanbooster.ideanoval.business.CommentAlert;
import fr.humanbooster.ideanoval.business.User;
import fr.humanbooster.ideanoval.dao.CommentAlertDao;
import fr.humanbooster.ideanoval.service.CommentAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Nea on 23/11/2016.
 */
@Service
@Transactional
public class CommentAlertServiceImpl implements CommentAlertService {

    @Autowired
    private CommentAlertDao cd;

    public CommentAlertServiceImpl() {
    }

    @Override
    public void createCommentAlert(User user, String motive, String description, Comment comment) {
        AlertMotive alertMotive = new AlertMotive(motive, description);
        CommentAlert commentAlert = new CommentAlert(user, alertMotive, comment);
        cd.createCommentAlert(commentAlert);
    }
}
