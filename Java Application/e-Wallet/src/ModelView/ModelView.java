/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelView;

import Function.Move;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import Function.Style;
import javafx.stage.StageStyle;

/**
 *
 * @author rizwan
 */
public class ModelView {

    public static Stage stage;
    static int  count = 0;

    public ModelView() {

    }

    public void openWindow(String path) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
//        //new Style().roundCorner(root, 360, 445, 50);
//        if(path =="/Login/Login.fxml")
//            new Style().roundCorner(root, 368, 333, 20);
//        else
//            new Style().roundCorner(root, 360, 445, 20);
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        if (path == "/Transfer/transfer.fxml") {
            count++;

            if (count == 1) {
                
                this.stage = stage;
                stage.setScene(scene);
                stage.initStyle(StageStyle.UNDECORATED);
                new Move(root, stage);
                stage.show();
            } else {
                this.stage.show();
            }
        } else {
            this.stage = stage;
            new Move(root, Login.Login.loginstage);
            Login.Login.loginstage.setScene(scene);
            Login.Login.loginstage.show();
            Login.Login.loginstage.setResizable(false);
        }
    }
    
    

}
