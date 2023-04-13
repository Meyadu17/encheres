package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.RetraitDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestionRetrait {

    @Autowired
    RetraitDAO dao;

    public Retrait creerRetrait(Retrait retrait) {
        return dao.save(retrait);
    }

}

