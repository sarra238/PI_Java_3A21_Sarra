
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import utils.MyConnection;
import Entities.Rate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Alert;

/**
 *
 * @author BRAIKI Ahmad
 */
public class RateService 
{
    PreparedStatement st;
    Statement st2;
    MyConnection myDB;
        private final Connection con = MyConnection.getInstance().getConnection();

    
    public RateService() {
    }
    
    
    public void AjouterRate(Rate r) {
        
            String n = "Null";
        String sql ="insert into rating (rating,id_Resto) values ("+r.getRating()+","+r.getIdResto()+")";
        try {
            System.out.println(sql);
            Statement stl = con.createStatement();
            stl.executeUpdate(sql);
            //Sms.send(r);
            System.out.println("Add Done");
            
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
        }
    }
    
    
    
    
}