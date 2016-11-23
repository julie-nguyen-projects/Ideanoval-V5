package fr.humanbooster.ideanoval.service;

import fr.humanbooster.ideanoval.business.Idea;
import fr.humanbooster.ideanoval.business.User;

/**
 * Created by Julie on 20/11/2016.
 */
public interface IdeaAlertService {

    public void createIdeaAlert(User user, String motive, String description, Idea idea);
}
