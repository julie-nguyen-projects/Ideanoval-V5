package fr.humanbooster.ideanoval.dao;

import fr.humanbooster.ideanoval.business.Idea;

import java.util.List;

/**
 * Created by Nea on 14/11/2016.
 */
public interface IdeaDao {
    public List<Idea> findAllIdeas();

    public void createIdea(Idea idea);

    public Idea findIdeaById(long id);
}
