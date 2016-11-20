package fr.humanbooster.ideanoval.controller;

import fr.humanbooster.ideanoval.business.Category;
import fr.humanbooster.ideanoval.business.Idea;
import fr.humanbooster.ideanoval.business.User;
import fr.humanbooster.ideanoval.business.Vote;
import fr.humanbooster.ideanoval.service.*;
import fr.humanbooster.ideanoval.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Nea on 15/11/2016.
 */
@Controller
public class IdeaController {

    @Autowired
    private HttpSession session;

    @Autowired
    private IdeaService ideaService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private VoteService voteService;

    @Autowired
    private UserController userController = new UserController();

    private DateUtils dateUtils;

//======================
//Add Idea
//======================
    @RequestMapping(value = "/addIdea", method = RequestMethod.GET)
    public ModelAndView addIdeaGet() {
        ModelAndView mav = new ModelAndView("addIdea");
        mav.addObject("idea", new Idea());
        mav.addObject("categories", categoryService.getAllCategories());
        return mav;
    }

    @RequestMapping(value = "/addIdea", method = RequestMethod.POST)
    public ModelAndView addIdeaPost(@ModelAttribute("idea") Idea idea,
                                    @RequestParam Map<String, Object> map) {
        String title = idea.getTitle();
        String description = idea.getDescription();
        String idCategory = map.get("ID_CATEGORY").toString();
        User user = userService.findUserById(session.getAttribute("id").toString());
        Category category = categoryService.findCategoryById(idCategory);
        ideaService.createIdea(title, description, category, user);
        return userController.welcomePage();
    }

//======================
//Details of an idea
//======================
    @RequestMapping(value = "/anIdea", method = RequestMethod.GET)
    public ModelAndView anIdea(@RequestParam(name = "id") String id) {
        ModelAndView mav = new ModelAndView("anIdea");
        Idea idea = ideaService.getIdeaById(id);
        mav.addObject("idea", idea);
        if (session.getAttribute("id") != null) {
            User user = userService.findUserById(session.getAttribute("id").toString());
            Vote vote = voteService.findVoteByUserAndIdea(user, idea);
            mav.addObject("vote", vote);
        }
        return mav;
    }

//======================
//A user comments an idea
//======================
    @RequestMapping(value = "/commentAnIdea", method = RequestMethod.POST)
    public ModelAndView commentAnIdea(@RequestParam(name = "idea_id") String idIdea,
                                      @RequestParam Map<String, Object> map) {
        User user = userService.findUserById(session.getAttribute("id").toString());
        String content = map.get("commentContent").toString();
        Idea idea = ideaService.getIdeaById(idIdea);
        commentService.addComment(content, user, idea);
        return anIdea(idIdea);
    }


//======================
//A user votes an idea
//======================
    @RequestMapping(value = "topVote", method = RequestMethod.GET)
    public ModelAndView topVote(@RequestParam(name = "id") String idIdea) {
        Idea idea = ideaService.getIdeaById(idIdea);
        User user = userService.findUserById(session.getAttribute("id").toString());
        voteService.addTopVote(user, idea);
        return anIdea(idIdea);
    }

    @RequestMapping(value = "flopVote", method = RequestMethod.GET)
    public ModelAndView flopVote(@RequestParam(name = "id") String idIdea) {
        Idea idea = ideaService.getIdeaById(idIdea);
        User user = userService.findUserById(session.getAttribute("id").toString());
        voteService.addFlopVote(user, idea);
        return anIdea(idIdea);
    }



}
