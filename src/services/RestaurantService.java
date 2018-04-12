
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entities.Restaurant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import static services.UserService.conn;
import utils.MyConnection;
import utils.Sms;

/**
 *
 * @author BRAIKI Ahmad
 */
public class RestaurantService 
{
    PreparedStatement st;
    Statement st2;
        private final Connection con = MyConnection.getInstance().getConnection();
    private ObservableList<Restaurant> data;
    
//    public RestaurantService(Restaurant r)
//    {
//    
//    }

    public RestaurantService() {
    }
    public void AjouterRestaurant(Restaurant r) {
        String sql ="insert into restaurant (nom,adresse,numtel,categorie,latitute,longitude,idUser) values ('"+r.getNom()+"','"+r.getAdresse()+"',"+r.getNumtel()+",'"+r.getCategorie()+"',"+r.getLatitude()+","+r.getLongitude()+","+conn+")";
        try {
            System.out.println(sql);
            Statement stl = con.createStatement();
            stl.executeUpdate(sql);
            //Sms.send(r);
            System.out.println("Add Done");
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Ajout restaurant confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Restaurant ajouté!");
            alert.showAndWait();

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
        }
    }
    public void SupprimerRestaurant(int id) {
        String query="DELETE FROM restaurant WHERE id = " + id + ";";
    
        try {
            st=con.prepareStatement(query);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            
        }
    }
    
    public List<Restaurant> AfficherRestaurant() {
        List<Restaurant> restaurants = new ArrayList();
        try
        {
            Statement stm = con.createStatement();
            ResultSet rest=stm.executeQuery("select id,nom,adresse,numtel,categorie,latitute,longitude,idUser,validej from restaurant ");
        while(rest.next())
        {
            Restaurant e = new Restaurant();
                e.setId(rest.getInt(1));
                e.setNom(rest.getString(2));
                e.setAdresse(rest.getString(3));
                e.setNumtel(rest.getInt(4));
                e.setCategorie(rest.getString(5));
                e.setLatitude(rest.getFloat(6));
                e.setLongitude(rest.getFloat(7));
                e.setIdUser(rest.getInt(8));
                e.setValide(rest.getString(9));
                
            restaurants.add(e);
        }
        }
        catch (SQLException ex)
        {
            
            System.out.println(ex.toString());
            System.out.println("Affichage echouee");
        }
        return restaurants;
    
    
    }

    public List<Restaurant> AfficherRestaurant2() {
        List<Restaurant> restaurants = new ArrayList();
        try
        {
            Statement stm = con.createStatement();
            ResultSet rest=stm.executeQuery("select id,nom,adresse,numtel,categorie,latitute,longitude,idUser,validej from restaurant ");
        while(rest.next())
        {
            Restaurant e = new Restaurant();
                e.setId(rest.getInt(1));
                e.setNom(rest.getString(2));
                e.setAdresse(rest.getString(3));
                e.setNumtel(rest.getInt(4));
                e.setCategorie(rest.getString(5));
                /*if (rest.getInt(6) == 1)
                    e.setEtat("Valider");
                else if (rest.getInt(6) == 0)
                    e.setEtat("Non Valider");
                else 
                    e.setEtat("En attente");*/
                
                e.setLatitude(rest.getFloat(6));
                e.setLongitude(rest.getFloat(7));
                e.setIdUser(rest.getInt(8));
                e.setValide(rest.getString(9));
              String x=e.getValide();
                if("Valide".equals(x)){
            restaurants.add(e);
                }
                
        }
        return restaurants;
        }
        catch (SQLException ex)
        {
            
            System.out.println(ex.toString());
            System.out.println("Affichage echouee");
        }
        return null;
    
    
    }
    public void ModifierRestaurant(Restaurant r) {
        try {
            String req;
            
            req = "UPDATE restaurant SET nom=?, adresse=?, numtel=?, categorie=? WHERE id = '"+r.getId()+"' and idUser='"+conn+"'";
            
            st= con.prepareStatement(req);
            
            st.setString(1, r.getNom());
            st.setString(2, r.getAdresse());
            st.setInt(3, r.getNumtel());
            st.setString(4, r.getCategorie());
            //st.setInt(5, r.getValide());
            //st.setFloat(6, r.getLatitude());
            //st.setFloat(7, r.getLongitude());
            //st.setInt(8, r.getIdUser());
            
            
            st.executeUpdate();
            System.out.println("Modification Validee!");
        } catch (SQLException ex) {
            System.out.println("Problème de Modification");
        }
    }
    public void ModifierEtatRestaurant(Restaurant r) {
        try {
            
            //System.out.println("valide = "+r.getEtat());
            System.out.println("valide = "+r.getValide());
            
            String req;
            
            req = "UPDATE restaurant SET validej=? WHERE id = '"+r.getId()+"'";
            
            st= con.prepareStatement(req);
            
            String e=r.getValide();
            if (e.equals("Valide"))
            {st.setString(1, "Non Valide");}
            else 
            {st.setString(1, "Valide");}
            
            
        /*if (r.getValide()==1)
            etat.setText("Valider");
        else if (r.getValide()==0)
            etat.setText("Unvalide");
        */
        

            //st.setString(2, r.getAdresse());
            //st.setInt(3, r.getNumtel());
            //st.setString(4, r.getCategorie());
            //st.setInt(5, r.getValide());
            //st.setFloat(6, r.getLatitude());
            //st.setFloat(7, r.getLongitude());
            //st.setInt(8, r.getIdUser());
            
            
            st.executeUpdate();
            System.out.println("Modification Validee!");
        } catch (SQLException ex) {
            System.out.println("Problème de Modification");
        }
    }
    public void AjouterRating(Restaurant i,int r)
    {
      
        //String query="update rating set rating="+r+" where id ="+id;
        String query="INSERT INTO rating (rating,id_Resto) VALUES ('"+i.getId()+"',"+r+")";
        PreparedStatement ps;
        try {
            Statement stl = con.createStatement();
            stl.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    

