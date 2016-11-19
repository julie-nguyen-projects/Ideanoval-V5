package fr.humanbooster.ideanoval.business;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Nea on 13/11/2016.
 */
@Entity
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

//======================
//Attributs
//======================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategory;

    @Column(nullable = false, length = 250)
    private String label;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Idea> ideas;

//======================
//Constructors
//======================
    public Category() {
    }

    public Category(String labelCategory, String description) {
        this.label = labelCategory;
        this.description = description;
    }

//======================
//Getters and Setters
//======================
    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String labelCategory) {
        this.label = labelCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Idea> getIdeas() {
        return ideas;
    }

    public void setIdeas(List<Idea> ideas) {
        this.ideas = ideas;
    }
}
