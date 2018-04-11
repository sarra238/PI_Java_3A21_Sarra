/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


public class confcommande {
    private String nom;
    private String prenom;
    private String adresse;
    private int idP;
    private int user;

    public confcommande(String nom, String prenom, String adresse, int produit, int user) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.idP = produit;
        this.user = user;
    }

    public confcommande(String nom, String prenom, String adresse, int user) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.user = user;
    }

    

    

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    /**
     *
     * @param nom
     * @param prenom
     * @param adresse
     * @param produit
     */
    public confcommande(String nom, String prenom,int produit, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.idP = produit;
    }

    public confcommande(String prenom, String adresse, int produit) {
        this.prenom = prenom;
        this.adresse = adresse;
        this.idP= produit;
    }

    public confcommande(String nom, String prenom, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public confcommande() {
    }

    


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    

    @Override
    public String toString() {
        return "confcommande{" + "nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", produit=" + idP + '}';
    }

   
    
    


}
