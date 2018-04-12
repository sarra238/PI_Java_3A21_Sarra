/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Restaurant;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.RestaurantService;
import utils.VoiceUtils;

/**
 * FXML Controller class
 *
 * @author Win10
 */
public class AjoutRestoController implements Initializable {
    @FXML
    private Label prixLabel;
    @FXML
    private TextField nomP;
    @FXML
    private TextField cat;
    @FXML
    private Button AjoutBtn;
    @FXML
    private Label prixLabel1;
    @FXML
    private TextField tel;
    @FXML
    private TextField adresse;
    @FXML
    private TextField longi;
    @FXML
    private TextField alti;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void AjoutProduit(ActionEvent event) {
        VoiceUtils v= new VoiceUtils("kevin16");
        RestaurantService sp=new RestaurantService();
        Restaurant p=new Restaurant();
        p.setNom(nomP.getText());
        p.setCategorie(cat.getText());
        p.setAdresse(adresse.getText());
        p.setNumtel(Integer.parseInt(tel.getText()));
        p.setLatitude((float) Double.parseDouble(alti.getText()));
        p.setLongitude((float) Double.parseDouble(longi.getText()));
        sp.AjouterRestaurant(p);
        String[] s={"Ajout de restaurant réussi!"};
        v.sayMultiple(s);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.close();
    }
    
}
