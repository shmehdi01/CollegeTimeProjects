/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeeManagement.component;

import FeeManagement.Module.Login.Login;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import FeeManagement.Module.Main.LoadMain;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class FooterController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void dashboard(ActionEvent event) throws IOException {
        //new MainController().loadWin("/FeeManagement/Module/Main/Main.fxml");
        Parent root = FXMLLoader.load(getClass().getResource("/FeeManagement/Module/Main/Main.fxml"));
       
        Scene scene = Login.SCENE;
        scene.setRoot(root);
        Login.STAGE.setScene(scene);
        Login.STAGE.setFullScreen(true);
        Login.STAGE.show();
 //LoadMain.LOADER.getChildren().setAll(root);
    }

    @FXML
    private void Logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/FeeManagement/Module/Login/Login.fxml"));
//        Scene scene = new Scene(root);
//        
//        Login.STAGE.setScene(scene);
//        //Login.STAGE.setFullScreen(true);
//        Login.STAGE.show();
    Login.LOADER.getChildren().setAll(root);
    }
    
    
}
