package fr.humanbooster.ideanoval.business;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Julie on 19/11/2016.
 */
@Entity
public class Vote implements Serializable {

    private static final long serialVersionUID = 1L;

//======================
//Attributs
//======================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int note;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idIdea")
    private Idea idea;

//======================
//Constructors
//======================
    public Vote() {
    }

    public Vote(int note, User user, Idea idea) {
        this.note = note;
        this.user = user;
        this.idea = idea;
    }

//======================
//Getters and Setters
//======================
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Idea getIdea() {
        return idea;
    }

    public void setIdea(Idea idea) {
        this.idea = idea;
    }
}
