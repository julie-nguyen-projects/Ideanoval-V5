package fr.humanbooster.ideanoval.controller;

import fr.humanbooster.ideanoval.business.Category;
import fr.humanbooster.ideanoval.business.Idea;
import fr.humanbooster.ideanoval.business.User;
import fr.humanbooster.ideanoval.service.CategoryService;
import fr.humanbooster.ideanoval.service.CommentService;
import fr.humanbooster.ideanoval.service.IdeaService;
import fr.humanbooster.ideanoval.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
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
    private UserController userController = new UserController();

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
        mav.addObject("idea", ideaService.getIdeaById(id));
        mav.addObject("comments", commentService.getAllComments());
        return mav;
    }


//======================
//A user comment an idea
//======================
    @RequestMapping(value = "/commentAnIdea", method = RequestMethod.POST)
    public ModelAndView commentAnIdea(@RequestParam(name = "idea_id") String idIdea,
                                      @RequestParam Map<String, Object> map) {
        ModelAndView mav = new ModelAndView("anIdea");
        User user = userService.findUserById(session.getAttribute("id").toString());
        String content = map.get("commentContent").toString();
        Idea idea = ideaService.getIdeaById(idIdea);

        // Ajouter commentaire
        commentService.addComment(content, user, idea);

        return anIdea(idIdea);
    }

}
