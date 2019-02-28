/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeeManagement.Methods;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author rizwan
 */
public class LoadExternalFx {
    public static AnchorPane SCENE;
    public void loadFxml(BorderPane bp, AnchorPane rootpane)  {
        try {
            SCENE = rootpane;
            //AnchorPane profile = FXMLLoader.load(getClass().getResource("/FeeManagement/component/Profile.fxml"));
            VBox pane = FXMLLoader.load(getClass().getResource("/FeeManagement/component/Topbar.fxml"));
            Pane sidemenu = FXMLLoader.load(getClass().getResource("/FeeManagement/component/Sidemenu.fxml"));
            BorderPane footer = FXMLLoader.load(getClass().getResource("/FeeManagement/component/Footer.fxml"));
            rootpane.getChildren().add(sidemenu);
            //rootpane.getChildren().add(profile);
            bp.setTop(pane);
            bp.setBottom(footer);
        } catch (IOException ex) {
            Logger.getLogger(LoadExternalFx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public static AnchorPane getScene(){
//        return SCENE;
//    }
}
