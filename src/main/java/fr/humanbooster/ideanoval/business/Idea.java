package fr.humanbooster.ideanoval.business;

import fr.humanbooster.ideanoval.utils.DateUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * Created by Nea on 13/11/2016.
 */
@Entity
public class Idea implements Serializable {

    private static final long serialVersionUID = 1L;

//======================
//Attributs
//======================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idIdea;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String description;

    private Date publicationDateIdea;

    @ManyToOne
    @JoinColumn(name = "idCategory")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @OneToMany(mappedBy = "idea", fetch = FetchType.EAGER)
    private List<Comment> comments;

//======================
//Constructors
//======================
    public Idea() {
    }


    public Idea(String titleIdea, String descriptionIdea) {
        this.title = titleIdea;
        this.description = descriptionIdea;
    }

    public Idea(String titleIdea, String descriptionIdea, User user) {
        this.title = titleIdea;
        this.description = descriptionIdea;
        this.user = user;
        this.publicationDateIdea = Date.from(Instant.now());
    }

    public Idea(String titleIdea, String descriptionIdea, Category category, User user) {
        this.title = titleIdea;
        this.description = descriptionIdea;
        this.category = category;
        this.user = user;
        this.publicationDateIdea = Date.from(Instant.now());
    }

//======================
//Getters and Setters
//======================
    public long getIdIdea() {
        return idIdea;
    }

    public void setIdIdea(long idIdea) {
        this.idIdea = idIdea;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String titleIdea) {
        this.title = titleIdea;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descriptionIdea) {
        this.description = descriptionIdea;
    }

    public String getPublicationDateIdea() {
        return DateUtils.getStringFromDate(this.publicationDateIdea);
    }

    public void setPublicationDateIdea(Date publicationDateIdea) {
        this.publicationDateIdea = publicationDateIdea;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
