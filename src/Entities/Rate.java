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
public class Rate {
    
    int rating;
    int idResto;

    public Rate() {
    }
    
    public Rate(int rating, int idResto) {
        this.rating = rating;
        this.idResto = idResto;
    }

    
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getIdResto() {
        return idResto;
    }

    public void setIdResto(int idResto) {
        this.idResto = idResto;
    }
    
    
    
}
