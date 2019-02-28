/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author rizwan
 */
public class Pop2 extends Application {
    
    public static Stage  popStage;
    @Override
    public void start(Stage stage) throws Exception {
        popStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("Pop.fxml"));
        
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.centerOnScreen();
        Scene scene=new Scene(root,Color.rgb(0, 0, 0, 0));
   
        stage.setScene(scene);
        stage.show();
        
    }
    
    public static void main(String [] ar)
    {
        launch();
    }
    
}
