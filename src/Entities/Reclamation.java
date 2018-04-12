/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author BRAIKI Ahmad
 */
public class Reclamation 
{
    public int id;
    public String expediteur;
    public String sujet;
    public String Message;
    public int idUser;

    public Reclamation() {
    }

    
    
    public Reclamation(int id, String expediteur, String sujet, String Message, int idUser) {
        this.id = id;
        this.expediteur = expediteur;
        this.sujet = sujet;
        this.Message = Message;
        this.idUser = idUser;
    }
    
    /*
    public Reclamation(String text, String text0, String text1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(String expediteur) {
        this.expediteur = expediteur;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }
    
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
}
