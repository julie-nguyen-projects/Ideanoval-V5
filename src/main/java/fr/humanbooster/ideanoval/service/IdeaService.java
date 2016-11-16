package fr.humanbooster.ideanoval.service;

import fr.humanbooster.ideanoval.business.Category;
import fr.humanbooster.ideanoval.business.Idea;
import fr.humanbooster.ideanoval.business.User;

import java.util.List;

/**
 * Created by Nea on 13/11/2016.
 */
public interface IdeaService {

    public List<Idea> getAllIdeas();

    public void createIdea(String title, String description, Category category, User user);

    public Idea getIdeaById(String id);
}
