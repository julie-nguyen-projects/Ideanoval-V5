package fr.humanbooster.ideanoval.controller;

import fr.humanbooster.ideanoval.business.Idea;
import fr.humanbooster.ideanoval.business.User;
import fr.humanbooster.ideanoval.service.IdeaService;
import fr.humanbooster.ideanoval.service.UserService;
import fr.humanbooster.ideanoval.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Nea on 13/11/2016.
 */
@Controller
public class UserController {

    @Autowired
    private HttpSession session;

    @Autowired
    private IdeaService ideaService;

    @Autowired
    private UserService userService;

    @Autowired
    private VoteService voteService;

//======================
//Welcome page
//======================
    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public ModelAndView welcomePage() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("ideas", ideaService.getAllIdeas());
        if (session.getAttribute("id") != null) {
            mav.addObject("user", userService.findUserById(session.getAttribute("id").toString()));
            return mav;
        }
        return mav;
    }

//======================
//Registration
//======================
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registerGet() {
        ModelAndView mav = new ModelAndView("registration");
        mav.addObject("user", new User());
        return mav;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerPost(@ModelAttribute("user") User user) {
        String pseudo = user.getPseudo();
        String email = user.getEmail();
        String password = user.getPassword();
        long idUser = userService.addUser(pseudo, email, password);
        return loginGet();
    }

//======================
//Login
//======================
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginGet() {
        ModelAndView mav = new ModelAndView("/login");
        mav.addObject("user", new User());
        return mav;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginPost(@ModelAttribute("user") User user) {
        User userConnected = userService.login(user.getEmail(), user.getPassword());

        if (userConnected != null) {
            session.setAttribute("id", userConnected.getId());
            return welcomePage();
        } else {
            System.out.println("Identifiants invalides");
            return loginGet();
        }
    }

//======================
//Logout
//======================
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout() {
        session.invalidate();
        return welcomePage();
    }
}
