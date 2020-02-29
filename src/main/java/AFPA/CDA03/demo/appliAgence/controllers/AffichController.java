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
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    
    @GetMapping("/circuits/{id}")
    //appel API recherche circuit id
    public String findById(@PathVariable int id, ModelMap params) throws Exception
    {
        try { 
            Circuits c = CircuitDao.findById(id);
            params.put("circuits", c );
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
    
    @PostMapping("/circuits/{id}")
    public String Update( @Valid Circuits circuit,BindingResult bindingResult,
            ModelMap params)
    {
        if (bindingResult.hasErrors()) {
            return "detailCircuit";
        }
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
    //  affichage de base sous forme de table 
        return "listeCircuits";		
    //  avec détail des circuits et suppression par l'icône de poubelle
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
    @GetMapping("/tarifs")
    public String tarifs( )
    {

       return "tarifs";
    }        
    @GetMapping("/circuits/ajout")
    public String create( Circuits circuit)
    {

       return "ajoutCircuit";
    }
    @PostMapping("/circuits/ajout")
    public String comeBackCreate( @Valid Circuits circuit,BindingResult bindingResult,
            ModelMap params)
   {
        if (bindingResult.hasErrors()) {
            return "ajoutCircuit";
        }

        CircuitsData.save(circuit);
        this.findAll(params);
        return "listeCircuits";	
        }
     
    } 
    
    	

