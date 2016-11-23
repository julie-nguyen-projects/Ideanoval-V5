package fr.humanbooster.ideanoval.business;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Julie on 20/11/2016.
 */
@Entity
public class AlertMotive implements Serializable {

    private static final long serialVersionUID = 1L;

//======================
//Attributs
//======================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String label;

    private String description;

    @OneToMany(mappedBy = "alertMotive", cascade=CascadeType.ALL)
    private List<Alert> alerts;

//======================
//Constructors
//======================
    public AlertMotive() {
    }

    public AlertMotive(String label, String description) {
        this.label = label;
        this.description = description;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }
}
