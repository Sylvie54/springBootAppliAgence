/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFPA.CDA03.demo.appliAgence.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 *
 * @author Acer
 */
@Entity
public class Circuits {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @javax.persistence.Id
    private int id;
    private String nom;
    private String pays;
    public Circuits() { }
    public Circuits(int id, String nom, String pays) {
        this.id = id;
        this.nom = nom;
        this.pays = pays; 
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        return "Circuit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", pays='" + pays + '\'' +
                '}';
    }
}
