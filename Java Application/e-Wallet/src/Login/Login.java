/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Function.Move;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author rizwan
 */
public class Login extends Application {
    public static Stage loginstage;
    Parent root;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        this.root = root;
        //new Style().roundCorner(root, 360, 333, 20);
        new Move(root, stage);
        Scene scene = new Scene(root);
        loginstage = stage;
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
        //stage.setResizable(false);
        
    }
    

      public static void main(String[] args) {
        launch(args);
    } 
    
}
