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

/**
 * FXML Controller class
 *
 * @author Win10
 */
public class ModifierRestoController implements Initializable {
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
    @FXML
    private Label id;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void DATA(Restaurant A)
    {
        id.setText(Integer.toString(A.getId()));
        nomP.setText(A.getNom());
        adresse.setText(A.getAdresse());
        tel.setText(Integer.toString( A.getNumtel()));
        longi.setText(Double.toString( A.getLongitude()));
        alti.setText(Double.toString( A.getLatitude()));
        cat.setText(A.getCategorie());
    }
    @FXML
    private void Modifier(ActionEvent event) {
        RestaurantService sp=new RestaurantService();
        Restaurant p=new Restaurant();
        p.setId(Integer.parseInt(id.getText()));
        p.setNom(nomP.getText());
        p.setCategorie(cat.getText());
        p.setAdresse(adresse.getText());
        p.setNumtel(Integer.parseInt(tel.getText()));
        p.setLatitude((float) Double.parseDouble(alti.getText()));
        p.setLongitude((float) Double.parseDouble(longi.getText()));
        p.setValide("Non Valide");
        sp.ModifierRestaurant(p);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.close();
    }
    
}
