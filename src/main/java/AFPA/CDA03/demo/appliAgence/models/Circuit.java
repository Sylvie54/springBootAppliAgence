/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFPA.CDA03.demo.appliAgence.models;

/**
 *
 * @author Acer
 */
public class Circuit {
    private int id;
    private String nom;
    private String pays;
    public Circuit() { }
    public Circuit(int id, String nom, String pays) {
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
