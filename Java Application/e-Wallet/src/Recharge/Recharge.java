/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recharge;

import static MainWindow.MainWindow.mainStage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author rizwan
 */
public class Recharge extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Recharge.fxml"));
        Scene scene = new Scene(root);
        mainStage = stage;
        stage.setScene(scene);
        stage.setTitle("e-Wallet");
        stage.show();
        stage.setResizable(false);
    }
     public static void main(String[] args) {
        launch(args);
    } 
    
}
