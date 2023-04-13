package fr.eni.encheres.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Controller de la page d'accueil
 *
 * @author Jérémy G
 */
@Controller
public class AccueilController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String accueil(){
        return "accueil";
    }
}
