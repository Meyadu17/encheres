package fr.eni.encheres.controller;

import fr.eni.encheres.bo.Utilisateur;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@Controller
public class AccueilController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String accueil(){

        return "accueil";
    }
}
