/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author BRAIKI Ahmad
 */
public class Restaurant {
private static ObservableList<Restaurant> Panier = FXCollections.observableArrayList();

    public static ObservableList<Restaurant> getPanier() {
        return Panier;
    }

    public static void setPanier(ObservableList<Restaurant> Panier) {
        Restaurant.Panier = Panier;
    }
    int id;
    String nom;
    String adresse;
    int numtel;
    String categorie;
    String valide;
    float latitude;
    float longitude;
    int idUser;
    
    //String etat;
    
    public Restaurant() {
    }
    
    /*
    public Restaurant(int id, String nom, String adresse, int numtel, String categorie, String etat, float latitude, float longitude, int idUser) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.numtel = numtel;
        this.categorie = categorie;
        this.etat = etat;
        this.latitude = latitude;
        this.longitude = longitude;
        this.idUser = idUser;
    }*/


    public Restaurant(int id, String nom, String adresse, int numtel, String categorie, String valide, float latitude, float longitude, int idUser) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.numtel = numtel;
        this.categorie = categorie;
        this.valide = valide;
        this.latitude = latitude;
        this.longitude = longitude;
        this.idUser = idUser;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getValide() {
        return valide;
    }

    public void setValide(String valide) {
        this.valide = valide;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
 
    /*
    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }*/

   

    
}
