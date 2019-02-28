/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addMoney;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author rizwan
 */
public class addMoney extends Application {

    
    @Override
    public void start(Stage stage) throws Exception {
        MainWindow.MainWindow.mainStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("addMoney.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Add in wallet");
        stage.show();
        
    }
    
 
   
    
    public static void main(String[] args) {
        launch(args);
    } 
    
}
