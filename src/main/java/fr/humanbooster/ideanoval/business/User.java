package fr.humanbooster.ideanoval.business;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * Created by Nea on 13/11/2016.
 */
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

//======================
//Attributs
//======================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 25, unique = true)
    private String pseudo;

    @Column(nullable = false, length = 25, unique = true)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    private boolean active;

    private boolean admin;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date registerDateUser;

    @OneToMany(mappedBy = "user")
    private List<Idea> ideas;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "idRole")
    private Role role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Vote> votes;

    @OneToMany(mappedBy = "user")
    private List<Alert> alerts;

//======================
//Constructors
//======================
    public User() {
    }

    public User(String pseudo, String email, String password) {
        this.pseudo = pseudo;
        this.email = email;
        this.password = password;
        this.registerDateUser = Date.from(Instant.now());
    }

    public User(String pseudo, String email, String password, Role role) {
        this.pseudo = pseudo;
        this.email = email;
        this.password = password;
        this.role = role;
        this.registerDateUser = Date.from(Instant.now());
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

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Idea> getIdeas() {
        return ideas;
    }

    public void setIdeas(List<Idea> ideas) {
        this.ideas = ideas;
    }

    public Date getRegisterDateUser() {
        return registerDateUser;
    }

    public void setRegisterDateUser(Date registerDateUser) {
        this.registerDateUser = registerDateUser;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
