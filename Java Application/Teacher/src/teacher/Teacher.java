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
import javafx.stage.Screen;
import javafx.stage.Stage;


/**
 *
 * @author rizwan
 */


public class Teacher extends Application {

    public static Scene scene, pc;
    public static Parent root, pop ;
    public static Stage thisStage;
    @Override
    public void start(Stage stage) throws Exception {
        thisStage = stage;
        root= FXMLLoader.load(getClass().getResource("TeacherGUI.fxml"));
        //pop= FXMLLoader.load(getClass().getResource("Pop.fxml"));
        //stage.initStyle(StageStyle.TRANSPARENT);
        scene = new Scene(root);
       // pc = new Scene(pop);
        
        scene.getStylesheets().add(getClass().getResource("teachergui.css").toExternalForm());
        stage.setScene(scene);
        //stage.setFullScreen(true);
       
        javafx.geometry.Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        //set Stage boundaries to visible bounds of the main screen
        stage.setX(primaryScreenBounds.getMinX());
        stage.setY(primaryScreenBounds.getMinY());
        stage.setWidth(primaryScreenBounds.getWidth());
        stage.setHeight(primaryScreenBounds.getHeight());
        stage.show();
        
        
   }
    
 public static void main(String []ar)
 {
     launch();
 }
    
    
}
