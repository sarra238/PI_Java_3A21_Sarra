    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entities.Reclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import utils.MyConnection;

/**
 *
 * @author BRAIKI Ahmad
 */
public class ReclamationService 
{
    PreparedStatement st;
    Statement st2;
    MyConnection myDB;
        private final Connection con = MyConnection.getInstance().getConnection();

    
    /*
    public ReclamationService(Reclamation r)
    {
        myDB = MyDB.getInsatance();
    }
    */
    public ReclamationService() {
    }
    
    
    
    /*
    @Override
    public Reclamation PassageReclamation(int id){
        Reclamation e = new Reclamation();
        try
        {
            Statement stm = conn.createStatement();
            ResultSet rest=stm.executeQuery("select * from sav where id="+id);
        while(rest.next())
        {
            //Reclamation e = new Reclamation();
                e.setId(rest.getInt(1));
                e.setExpediteur(rest.getString(2));
                e.setSujet(rest.getString(3));
                e.setMessage(rest.getString(4));
                e.setIdUser(rest.getInt(5));
                
            
        }
        }
        catch (SQLException ex)
        {
            System.out.println("Probleme affichage");
        }
        return e;
    }
    */
    public void AjouterReclamation(Reclamation r) {
        System.out.println("test");
        //r.toString();
        String sql = "insert into sav (expediteur,sujet,Message,idUser) values ('"+r.getExpediteur()+"','"+r.getSujet()+"','"+r.getMessage()+"',"+r.getIdUser()+")";        
        
        try 
        {
            System.out.println(sql);
            Statement stl = con.createStatement();
            stl.executeUpdate(sql);
            //Sms.send(r);
            System.out.println("Add Done");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajout reclamation confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Reclamation ajouté!");
            alert.showAndWait();

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
        }
        
        
        
    }
    
    public void SupprimerReclamation(int id) {
        String query="DELETE FROM sav WHERE id = " + id + ";";
    
        try {
            st=con.prepareStatement(query);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Reclamation> AfficherReclamation() {
        List<Reclamation> reclamations =new ArrayList<>();
        try
        {
            Statement stm = con.createStatement();
            ResultSet rest=stm.executeQuery("select expediteur,sujet,Message from sav ");
        while(rest.next())
        {
            Reclamation e = new Reclamation();
                e.setExpediteur(rest.getString(1));
                e.setSujet(rest.getString(2));
                e.setMessage(rest.getString(3));
            reclamations.add(e);
        }
        }
        catch (SQLException ex)
        {
            System.out.println("Probleme affichage");
        }
        return reclamations;
    
    
    }

    
    public void ModifierReclamation(Reclamation r,int id) {
        try {
            String req;
            
            req = "UPDATE sav SET 'sujet'=?,'Message'=? WHERE id = "+id;
            
            st= con.prepareStatement(req);
            
            st.setString(1, r.getSujet());
            st.setString(2, r.getMessage());
            
            st.executeUpdate();
            System.out.println("Modification OK!");
        } catch (SQLException ex) {
            System.out.println("Problème de Modification");
        }
    }
    public int Count(String id) {
        int i=0;
        try {
            PreparedStatement pt;
            String query = "select * from sav where Sujet='"+id+"'";
            pt=con.prepareStatement(query);
            ResultSet rs = pt.executeQuery();
            while(rs.next()){
                i+=1;
            }
        }
         catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour de l'annonce " + ex.getMessage());
        }  
        return i;
    }
}
    

