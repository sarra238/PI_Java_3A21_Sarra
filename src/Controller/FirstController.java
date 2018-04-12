/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Win10
 */
public class FirstController implements Initializable {
    @FXML
    private ImageView imgv;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    private void makeFadeout() {
        FadeTransition f=new FadeTransition();
        f.setDuration(Duration.millis(1000));
        f.setNode(imgv);
        f.setFromValue(1);
        f.setToValue(0);
        f.setOnFinished((ActionEvent event) -> {
            try {
                Parent root2 = FXMLLoader.load(getClass().getResource("VideoIni.fxml"));
                Scene scene2 = new Scene(root2);
                Stage s=(Stage) imgv.getScene().getWindow();
                s.setScene(scene2);
            } catch (IOException ex) {
                Logger.getLogger(FirstController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        f.play();
    }

    @FXML
    private void fffff(MouseEvent event) {
        makeFadeout();
    }
}
