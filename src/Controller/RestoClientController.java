/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Restaurant;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import services.RestaurantService;

/**
 * FXML Controller class
 *
 * @author Win10
 */
public class RestoClientController implements Initializable {
    @FXML
    private TableView<Restaurant> tabAnn;
    @FXML
    private TableColumn<Restaurant, String> NomAnn;
    @FXML
    private Label numTel;
    @FXML
    private Label nom;
    @FXML
    private Label cat;
    @FXML
    private Label adresse;
    @FXML
    private TextField seach;
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
    private Label nomtext;
    @FXML
    private Label cattext;
    @FXML
    private Label telText;
    @FXML
    private Label adressText;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RestaurantService Ann=new RestaurantService();
        ArrayList A= (ArrayList) Ann.AfficherRestaurant2();
        ObservableList ob=FXCollections.observableArrayList(A);
        tabAnn.setItems(ob);
        NomAnn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tabAnn.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        FilteredList<Restaurant> fil= new FilteredList<>(ob,e->true);
        seach.setOnKeyReleased((KeyEvent e) -> {
            seach.textProperty().addListener((ObservableValue<? extends String> observableValue, String oldValue, String newValue) -> {
                fil.setPredicate((Predicate <? super Restaurant>) Annonce->{
                    if(newValue==null||newValue.isEmpty()){return true;}
                    String lower=newValue.toLowerCase();
                    if(Annonce.getNom().toLowerCase().contains(lower)){return true;}
                    else if(Annonce.getCategorie().toLowerCase().contains(lower)){return true;}
                     else if(Annonce.getAdresse().toLowerCase().contains(lower)){return true;}
                    return false;
                });
            });
            SortedList<Restaurant> k = new SortedList<>(fil);
            k.comparatorProperty().bind(tabAnn.comparatorProperty());
            tabAnn.setItems(k);
        });
        tabAnn.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
    if (newSelection != null) {
          nomtext.setVisible(true);
          nom.setVisible(true);
          nom.setText(newSelection.getNom());
          cattext.setVisible(true);
          cat.setVisible(true);
          cat.setText(newSelection.getCategorie());
          adressText.setVisible(true);
          adresse.setVisible(true);
          adresse.setText(newSelection.getAdresse());
          telText.setVisible(true);
          numTel.setVisible(true);
          numTel.setText(Integer.toString(newSelection.getNumtel()));
    }});  
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
    private void Resto(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("RestoClient.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Restaurants!");
        primaryStage.setScene(scene);
        primaryStage.show();
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
    
}
