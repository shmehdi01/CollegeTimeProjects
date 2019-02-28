
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket.function;

import cricket.main.MainController;
import cricket.main.MainLoader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author rizwan
 */
public class LoadWin {

    public LoadWin() {

    }

    public LoadWin(String path) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(path));
            MainController.setter.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(LoadWin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dashboard() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/cricket/main/Main.fxml"));
            Scene scene = MainLoader.main_scene;
            scene.setRoot(root);
            MainLoader.main_stage.setScene(scene);
            MainLoader.main_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoadWin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Stage load_pop_stage;
    private static Scene load_pop_scene;

    public void loadPop(String title, String path) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        load_pop_scene = scene;
        Stage stage = new Stage();
        load_pop_stage = stage;
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
//        load_pop_stage.setScene(load_pop_scene);
//        load_pop_stage.setTitle(title);
//        load_pop_stage.show();
    }

    public void loadBowler(String title) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/cricket/create/openerballer.fxml"));
            Scene scene = this.load_pop_scene;
            scene.setRoot(root);
            this.load_pop_stage.setScene(scene);
            this.load_pop_stage.setTitle(title);
            this.load_pop_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoadWin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
