/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author Win10
 */
public class SavAdminController implements Initializable {
    public static Reclamation recc;
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
    private Button StatBtn;
    @FXML
    private TableView<Reclamation> Savtab;
    @FXML
    private TableColumn<Reclamation, String> exp;
    @FXML
    private TableColumn<Reclamation, String> sujet;
    @FXML
    private TableColumn<Reclamation, String> msg;
    @FXML
    private Button traiterBtn;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ReclamationService v =  new  ReclamationService();
        ArrayList arrayList = (ArrayList) v.AfficherReclamation();
        ObservableList ob = FXCollections.observableArrayList(arrayList);
        Savtab.setItems(ob);
        exp.setCellValueFactory(new PropertyValueFactory<>("expediteur"));
        sujet.setCellValueFactory(new PropertyValueFactory<>("sujet"));
        msg.setCellValueFactory(new PropertyValueFactory<>("Message"));
        Savtab.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
    if (newSelection != null) {
         recc=newSelection;
    }});  
    }    

    @FXML
    private void Home(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("HomeAd.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Home!");
        primaryStage.setScene(scene);
        primaryStage.show(); 
    }

    @FXML
    private void Produits(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      Parent root = FXMLLoader.load(getClass().getResource("ProduitAdmin.fxml"));
      Scene scene = new Scene(root);    
      primaryStage.setTitle("Produits!");
      primaryStage.setScene(scene);
      primaryStage.show();
    }

    @FXML
    private void Annonces(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AnnoncesAdmin.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Annonces!");
        primaryStage.setScene(scene);
        primaryStage.show(); 
    }

    @FXML
    private void Event(ActionEvent event) throws IOException {
      Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      Parent root = FXMLLoader.load(getClass().getResource("AffichEventAd.fxml"));
      Scene scene = new Scene(root);    
      primaryStage.setTitle("Evenement");
      primaryStage.setScene(scene);
      primaryStage.show();
    }

    @FXML
    private void Resto(ActionEvent event) throws IOException {
         Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("RestoAdmin.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Restaurants!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void Sav(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("SavAdmin.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Service Aprés Vente!");
        primaryStage.setScene(scene);
        primaryStage.show(); 
    }

    @FXML
    private void Stat(ActionEvent event) throws IOException {
        Stage primary = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root2 = FXMLLoader.load(getClass().getResource("SavAdmin.fxml"));
        Scene scene2 = new Scene(root2); 
        primary.setTitle("Service Aprés Vente!");
        primary.setScene(scene2);
        primary.show();
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("StatSav.fxml"));
        Scene scene = new Scene(root);        
        primaryStage.setTitle("Statistique!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void triter(ActionEvent event) throws IOException {
        ObservableList<Reclamation> r,fo;
        fo=Savtab.getItems();
        r=Savtab.getSelectionModel().getSelectedItems();
        if(r.size()>0){
        Stage primary = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root2 = FXMLLoader.load(getClass().getResource("SavAdmin.fxml"));
        Scene scene2 = new Scene(root2); 
        primary.setTitle("Service Aprés Vente!");
        primary.setScene(scene2);
        primary.show();
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SavTraiterRec.fxml"));
        Scene scene = new Scene(root);        
        primaryStage.setTitle("Statistique!");
        primaryStage.setScene(scene);
        primaryStage.show();
        }
    }
    
}
