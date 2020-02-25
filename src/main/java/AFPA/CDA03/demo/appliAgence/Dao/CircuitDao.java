/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFPA.CDA03.demo.appliAgence.Dao;

import AFPA.CDA03.demo.appliAgence.models.Circuit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Acer
 */
public class CircuitDao {
    public static Circuit findById(int id)
    {
    try
    {
        // Appel API
        String URL = "http://localhost:8080/circuits/" + id;
        RestTemplate restTemplate = new RestTemplate();
        Circuit c = restTemplate.getForObject (URL, Circuit.class);
        System.out.println("API succeded " + c);
        return c;
        }
        catch(Exception e)
        {
        System.out.println("ERREUR : Service non lancé !! " + e.toString());
        return null;
        }
    }
    public static List<Circuit> findAll()
    {
            try {
                // Appel API
                String URL = "http://localhost:8080/circuits";
                RestTemplate restTemplate = new RestTemplate();
                Circuit[] tab = restTemplate.getForObject(URL, Circuit[].class);
                List<Circuit> ls = new ArrayList<Circuit>(Arrays.asList(tab));  // conversion du tableau en liste

                System.out.println("API succeded " + ls);
                return ls;
            } catch (Exception e) {
                System.out.println("ERREUR : Service non lancé !!  " + e.toString());
                return null;
            }

    }
    
    public static Circuit editById(int id)
    {
        try

        {
            // Appel API
              String URL = "http://localhost:8080/circuits/" + id;
              RestTemplate restTemplate = new RestTemplate();
              Circuit c = restTemplate.getForObject (URL, Circuit.class);
              System.out.println("API succeded " + c);
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
           System.out.println("Suppression OK");
           return true;
        }
        catch(Exception e)
        {
            System.out.println("ERREUR : Service non lancé !!  " + e.toString());
            return false;
        }
    }
}