package fr.humanbooster.ideanoval.business;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Julie on 20/11/2016.
 */
@Entity
public class CommentAlert extends Alert {

//======================
//Attributs
//======================
    @ManyToOne
    @JoinColumn(name = "idComment")
    private Comment comment;

//======================
//Constructors
//======================
    public CommentAlert() {
    }

    public CommentAlert(User user, AlertMotive alertMotive) {
        super(user, alertMotive);
    }

    public CommentAlert(User user, AlertMotive alertMotive, Comment comment) {
        super(user, alertMotive);
        this.comment = comment;
    }

//======================
//Getters and Setters
//======================
    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
