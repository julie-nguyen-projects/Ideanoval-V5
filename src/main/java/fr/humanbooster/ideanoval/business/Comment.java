package fr.humanbooster.ideanoval.business;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Nea on 13/11/2016.
 */
@Entity
public class Comment implements Serializable{

    private static final long serialVersionUID = 1L;

//======================
//Attributs
//======================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idComment;

    @Column(nullable = false)
    private String commentContent;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

//======================
//Constructors
//======================
    public Comment() {
    }

    public Comment(String commentContent, User user) {
        this.commentContent = commentContent;
        this.user = user;
    }

//======================
//Getters and Setters
//======================
    public long getIdComment() {
        return idComment;
    }

    public void setIdComment(long idComment) {
        this.idComment = idComment;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
