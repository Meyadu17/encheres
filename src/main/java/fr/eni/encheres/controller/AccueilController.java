package fr.eni.encheres.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller de la page d'accueil
 *
 * @author Jérémy G
 */
@RestController
public class AccueilController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String test(){
        return "test";
    }
}
