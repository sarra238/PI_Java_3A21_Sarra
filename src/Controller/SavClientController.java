/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Reclamation;
import Entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import services.ReclamationService;
import services.UserService;
import static services.UserService.conn;
import utils.Sms;

/**
 * FXML Controller class
 *
 * @author Win10
 */
public class SavClientController implements Initializable {
    @FXML
    private Button Home;
    @FXML
    private Button Produits;
    @FXML
    private Button Annonces;
    @FXML
    private Button Evénements;
    @FXML
    private Button Restaurants;
    @FXML
    private Button SAV;
    @FXML
    private ComboBox<String> combo;
    @FXML
    private TextArea msg;
    @FXML
    private Button EnvoiBtn;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList ob = FXCollections.observableArrayList("Produit Périmé","Produit non livrer","Reclamation Restaurant","Evenement debile","Autre ...");
        combo.setItems(ob);
    }    

    @FXML
    private void Home(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("HomeC.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Home!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void Produits(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("ProduitClient.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Produits!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void Annonces(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AnnoncesClient.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Annonces!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void Event(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AffichEventClient.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Evenement!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void Resto(ActionEvent event) {
    }

    @FXML
    private void Sav(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("SavClient.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Service Aprés Vente!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void Envoyer(ActionEvent event) throws IOException {
        
        Reclamation r=new Reclamation();
        User u;
        UserService us=new UserService();
        ReclamationService rs=new ReclamationService();
        u=us.RechercherUsertById(conn);
        r.setExpediteur(u.getEmail());
        r.setSujet(combo.getValue());
        r.setMessage(msg.getText());
        r.setIdUser(conn);
        rs.AjouterReclamation(r);
        Sms.sendTrait(msg.getText());
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("SavClient.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Service Aprés Vente!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
