/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFPA.CDA03.demo.appliAgence.controllers;

import AFPA.CDA03.demo.appliAgence.Dao.CircuitDao;
import AFPA.CDA03.demo.appliAgence.models.Circuit;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Acer
 */

@Controller
//@ResponseBody  //  pour répondre sans passer par une vue
public class AffichController 
{
    @GetMapping("/circuits/{id}") 								
    //appel API recherche circuit id
    public String findById(@PathVariable int id, ModelMap params)
    {
       Circuit c = CircuitDao.findById(id);
       params.put("circuit", c );
       // on appelle le template detailCircuit.html, en lui passant en paramètre 
       // le circuit demandé
       return "detailCircuit";
    }

    @GetMapping("/circuits") 									
    //appel API liste de tous les circuits
    public String findAll(ModelMap params)
    {
        List<Circuit> liste = CircuitDao.findAll();
        // on appelle le template listeCircuits.html, en lui passant en paramètre 
        // la liste de tous les circuits
        params.put("circuits", liste );
        
        // return "listeCircuitsSimple";	
    // affichage de base sous forme de table 
        return "listeCircuits";		
    // avec détail des circuits et suppression par l'icône de poubelle
    }
    
      
    // suppression d'un circuit par son id
    // après suppression, on réaffiche la liste
    @GetMapping("/removeCircuit/{id}") 
    public String removeById(@PathVariable int id, ModelMap params)
    {
       CircuitDao.removeById(id);						
    // appel de l'API de suppression 
       
       return findAll (params) ; 						
    // réaffichage de tous les circuits après la suppression   
    }
    
    	
}
