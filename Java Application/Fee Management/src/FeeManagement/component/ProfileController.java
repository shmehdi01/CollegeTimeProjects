/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeeManagement.component;

import FeeManagement.Module.Login.Login;
import com.jfoenix.effects.JFXDepthManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class ProfileController implements Initializable {

    @FXML
    private AnchorPane root;
    public static AnchorPane profile;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        profile = root;
        JFXDepthManager.setDepth(root, 5);
    }    

    @FXML
    private void close(ActionEvent event) {
        //Login.LOADER.setDisable(false);
        FadeTransition fd = new FadeTransition(Duration.seconds(0.5), profile);
        TranslateTransition ts = new TranslateTransition(Duration.seconds(0.3),profile);
        ts.setToX(1500);
        fd.setFromValue(1);
        fd.setToValue(0);
        fd.play();
        ts.play();
        
    }
    
}
