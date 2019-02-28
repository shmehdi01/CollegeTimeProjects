/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author rizwan
 */
public class POP extends Application{
    
    
  
    
    @Override
    public void start(Stage stage) throws Exception {
        
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.centerOnScreen();
        Group root=new Group();
        Scene scene=new Scene(root, 500,300, Color.rgb(0, 0, 0, 0));
        scene.getStylesheets().add(getClass().getResource("PopStyle.css").toExternalForm());
        Rectangle r=new Rectangle();
        r.setId("rectAngle");
        r.widthProperty().bind(scene.widthProperty());
        r.heightProperty().bind(scene.heightProperty());
        Node area = r;
        root.getChildren().add(area);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] ar)
    {
        launch();
    }
    
    public static Stage popStage;
    public void showPop()
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Pop.fxml"));
            Stage stage = new Stage();
            popStage = stage;
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.centerOnScreen();
            Scene scene=new Scene(root,Color.rgb(0, 0, 0, 0));
            
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            System.out.println("Error in showing PopUp");
        }
    }
}
