/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFPA.CDA03.demo.appliAgence.Dao;

import AFPA.CDA03.demo.appliAgence.models.Circuits;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Acer
 */
public class CircuitDao {
    public static Circuits findById(int id)
    {
    try
    {
        // Appel API
        String URL = "http://localhost:8080/circuits/" + id;
        RestTemplate restTemplate = new RestTemplate();
        Circuits c = restTemplate.getForObject (URL, Circuits.class);
       // System.out.println("API succeded findById " + c);
        return c;
        }
        catch(Exception e)
        {
        System.out.println("ERREUR : Service non lancé !! " + e.toString());
        return null;
        }
    }
    public static List<Circuits> findAll()
    {
        try {
            // Appel API
            String URL = "http://localhost:8080/circuits";
            RestTemplate restTemplate = new RestTemplate();
            Circuits[] tab = restTemplate.getForObject(URL, Circuits[].class);
            List<Circuits> ls = new ArrayList<Circuits>(Arrays.asList(tab));  // conversion du tableau en liste
         //   System.out.println("API succeded findAll " + ls);
            return ls;
        } catch (Exception e) {
            System.out.println("ERREUR : Service non lancé !!  " + e.toString());
            return null;
        }

    }
    
    public static Circuits editById(int id)
    {
        try

        {
            // Appel API
              String URL = "http://localhost:8080/circuits/" + id;
              RestTemplate restTemplate = new RestTemplate();
              Circuits c = restTemplate.getForObject (URL, Circuits.class);
        //      System.out.println("API succeded  editById" + c);
            return c;
        }
            catch(Exception e)
        {
            System.out.println("ERREUR : Service non lancé !!  " + e.toString());
            return null;
        }
    }
    
    
    public static boolean removeById(int id)
    {
        try
        {
            // Appel API
           String URL = "http://localhost:8080/circuits/" + id;
           RestTemplate restTemplate = new RestTemplate();
           restTemplate.delete(URL);
        //   System.out.println("Suppression OK");
           return true;
        }
        catch(Exception e)
        {
            System.out.println("ERREUR : Service non lancé !!  " + e.toString());
            return false;
        }
    }
}
