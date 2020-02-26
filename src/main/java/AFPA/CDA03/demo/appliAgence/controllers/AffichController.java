/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFPA.CDA03.demo.appliAgence.controllers;

import AFPA.CDA03.demo.appliAgence.Dao.CircuitDao;
import AFPA.CDA03.demo.appliAgence.Dao.CircuitsRepository;
import AFPA.CDA03.demo.appliAgence.models.Circuits;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Acer
 */

@Controller
//@ResponseBody  //  pour répondre sans passer par une vue
public class AffichController 
{
    @Autowired
    private CircuitsRepository CircuitsData;
    
    @RequestMapping(value = "/circuits/{id}", method = RequestMethod.GET)
  //  @GetMapping("/circuits/{id}") 								
    //appel API recherche circuit id
    public String findById(@PathVariable int id, ModelMap params) throws Exception
            
    {
       try { 
           Circuits c = CircuitDao.findById(id);
           params.put("circuit", c );
           if (c == null) {
               this.findAll(params);
               params.put("message", "le circuit est non trouvé" );
               return "listeCircuits";
           }
           else {
               return "detailCircuit";
           }
       }
       catch (Exception e) {
           this.findAll(params);
           return "listeCircuits";
       }
    }
    
    @RequestMapping(value = "/circuits/{id}", method = RequestMethod.POST)
    public String Update(ModelMap params,@RequestParam("Id") int Id,@RequestParam("Nom") String nom, @RequestParam("pays") String pays) {
        Circuits circuit = new Circuits(Id, nom, pays);
        CircuitsData.save(circuit);
        this.findAll(params);
        return "listeCircuits";	
    }

    @GetMapping("/circuits") 									
    //appel API liste de tous les circuits
    public String findAll(ModelMap params)
    {
        List<Circuits> liste = CircuitDao.findAll();
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
            
    @RequestMapping(value = "/circuits/ajout", method = RequestMethod.GET)
    public String create( ModelMap params)
    {
       Circuits c = new Circuits();
       params.put("circuit", c );
       // on appelle le template detailCircuit.html, en lui passant en paramètre 
       // le circuit demandé
       return "detailCircuit";
    }
    @RequestMapping(value = "/circuits/ajout", method = RequestMethod.POST)
    public String comeBackCreate(ModelMap params,@RequestParam("Nom") String nom, @RequestParam("pays") String pays) {
        System.out.println("ajout le nom : " + nom + " le pays : " + pays);
        Circuits circuit = new Circuits(0, nom, pays);
        CircuitsData.save(circuit);
        this.findAll(params);
        return "listeCircuits";	
    }
    	
}
