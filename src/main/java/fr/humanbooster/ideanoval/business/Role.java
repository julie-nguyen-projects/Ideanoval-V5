package fr.humanbooster.ideanoval.business;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Nea on 13/11/2016.
 */
@Entity
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

//======================
//Attributs
//======================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;

    private String nameRole;

    @OneToMany(mappedBy = "role")
    private List<User> users;

//======================
//Constructors
//======================
    public Role() {
    }

    public Role(String nameRole) {
        this.nameRole = nameRole;
    }

//======================
//Getters and Setters
//======================
    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
