package fr.humanbooster.ideanoval.service.impl;

import fr.humanbooster.ideanoval.business.Category;
import fr.humanbooster.ideanoval.business.Idea;
import fr.humanbooster.ideanoval.business.User;
import fr.humanbooster.ideanoval.dao.IdeaDao;
import fr.humanbooster.ideanoval.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * Created by Nea on 13/11/2016.
 */
@Service
@Transactional
public class IdeaServiceImpl implements IdeaService {

    @Autowired
    private IdeaDao id;

    public IdeaServiceImpl() {
    }

    @Override
    public List<Idea> getAllIdeas() {
        return id.findAllIdeas();
    }

    @Override
    public void createIdea(String title, String description, Category category, User user) {
        Idea idea = new Idea(title, description, category, user);
        idea.setPublicationDateIdea(Date.from(Instant.now()));
        id.createIdea(idea);
    }

    @Override
    public Idea getIdeaById(String idIdea) {
        if (idIdea == null) {
            return null;
        } else {
            Idea idea = id.findIdeaById(Long.parseLong(idIdea));
            return idea;
        }
    }


}
