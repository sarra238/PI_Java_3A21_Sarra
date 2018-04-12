/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import static Controller.RestoClientController.ddd;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;
import services.RestaurantService;

/**
 * FXML Controller class
 *
 * @author Win10
 */
public class RatingRestoController implements Initializable {
    @FXML
    private Rating rating;
    @FXML
    private Button ajouterRateBtn;

    int note;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rating.ratingProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            note=newValue.intValue();
            System.out.println(""+newValue);
        });
    }    

    @FXML
    private void ajouterRate(ActionEvent event) {
        RestaurantService rs=new RestaurantService();
        rs.AjouterRating(ddd, note);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.close();
        
    }
    
}
