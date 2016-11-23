package fr.humanbooster.ideanoval.business;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Nea on 14/11/2016.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "alertType")
public abstract class Alert implements Serializable {

    private static final long serialVersionUID = 1L;

//======================
//Attributs
//======================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @ManyToOne
    @JoinColumn(name = "idAlert")
    protected User user;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "idAlertMotive")
    protected AlertMotive alertMotive;

//======================
//Constructors
//======================
    public Alert() {
    }

    public Alert(User user, AlertMotive alertMotive) {
        this.user = user;
        this.alertMotive = alertMotive;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AlertMotive getAlertMotive() {
        return alertMotive;
    }

    public void setAlertMotive(AlertMotive alertMotive) {
        this.alertMotive = alertMotive;
    }
}
