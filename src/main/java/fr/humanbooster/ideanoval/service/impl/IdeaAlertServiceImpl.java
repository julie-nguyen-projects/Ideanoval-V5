package fr.humanbooster.ideanoval.service.impl;

import fr.humanbooster.ideanoval.business.AlertMotive;
import fr.humanbooster.ideanoval.business.Idea;
import fr.humanbooster.ideanoval.business.IdeaAlert;
import fr.humanbooster.ideanoval.business.User;
import fr.humanbooster.ideanoval.dao.IdeaAlertDao;
import fr.humanbooster.ideanoval.service.IdeaAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Julie on 20/11/2016.
 */
@Service
@Transactional
public class IdeaAlertServiceImpl implements IdeaAlertService {

    @Autowired
    private IdeaAlertDao id;

    public IdeaAlertServiceImpl() {
    }

    @Override
    public void createIdeaAlert(User user, String motive, String description, Idea idea) {
        AlertMotive alertMotive = new AlertMotive(motive, description);
        IdeaAlert ideaAlert = new IdeaAlert(user, alertMotive, idea);
        id.createIdeaAlert(ideaAlert);
    }
}
