/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import static Login.Login.loginstage;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author rizwan
 */
public class Move {

    double X;
    double Y;

    public Move(final Parent root, final Stage stage) {

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                root.setCursor(Cursor.CLOSED_HAND);
                X = t.getSceneX();
                Y = t.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                stage.setX(t.getScreenX() - X);
                stage.setY(t.getScreenY() - Y);
                root.setCursor(Cursor.CLOSED_HAND);
            }
        });
        
        root.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                root.setCursor(Cursor.DEFAULT);
                
            }
        });
    }

}
