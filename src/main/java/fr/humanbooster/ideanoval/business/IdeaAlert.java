package fr.humanbooster.ideanoval.business;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by Julie on 20/11/2016.
 */
@Entity
public class IdeaAlert extends Alert {

//======================
//Attributs
//======================
    @ManyToOne
    @JoinColumn(name = "idIdea")
    private Idea idea;

//======================
//Constructors
//======================
    public IdeaAlert() {
    }

    public IdeaAlert(User user, AlertMotive alertMotive) {
        super(user, alertMotive);
    }

    public IdeaAlert(User user, AlertMotive alertMotive, Idea idea) {
        super(user, alertMotive);
        this.idea = idea;
    }

//======================
//Getters and Setters
//======================
    public Idea getIdea() {
        return idea;
    }

    public void setIdea(Idea idea) {
        this.idea = idea;
    }
}
