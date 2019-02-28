/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Popup;

import javafx.stage.Stage;

/**
 *
 * @author rizwan
 */
public class Profile extends Application {
    
    @Override
    public void start(final Stage stage) {
        stage.setTitle("Profile");
        BorderPane root = new BorderPane();
        Rectangle rect =new Rectangle(400,150);
        rect.setStroke(Color.DARKGRAY);
        rect.setArcHeight(4);
        rect.setArcWidth(6);
        rect.setEffect(new DropShadow());
        final Popup pop = new Popup();
        pop.getContent().add(rect);
        pop.setHeight(100);
        pop.setWidth(100);
        Circle circle = new Circle(400,300,200,Color.WHITESMOKE);
        circle.setStroke(Color.BLACK);
        circle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
//              pop.setX(t.getSceneX());
              pop.setX(300);
            
              //pop.setY(t.getSceneY()-50);
              pop.setY(300);
              pop.show(stage);
              
            }
        });
      circle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                pop.hide();
                }
        });
      root.getChildren().add(circle);
      stage.setScene(new Scene(root, 800, 600));
      stage.show();
       }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
