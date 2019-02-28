/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeeManagement.Methods;

import FeeManagement.Module.Login.Login;
import FeeManagement.Module.Main.MainController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author rizwan
 */
public class Loader {

    private static String msg;
    private static String title;
    private static Loader load;
    private Parent root;
    static int count = 0;

    public Loader() {
         System.out.println("pop loaded" + count);
            count++;
    }

    public static Loader getInstance() {
        if (load == null) {
            load = new Loader();
        }
        return load;
    }

    boolean added = false;

    public void loadPop(String title, String msg, int time) throws IOException {

        try {
            this.title = title;
            this.msg = msg;
            Parent root = FXMLLoader.load(getClass().getResource("/FeeManagement/component/popinfo.fxml"));
            if (added == false) {
                MainController.pop.getChildren().add(root);
                added = true;
            }
            PauseTransition delay = new PauseTransition(Duration.seconds(time));
            delay.setOnFinished(e -> {
                if (added == true) {
                    //MainController.pop.getChildren().remove(root);
                    root.setVisible(false);
                    added = false;
                }

            }
            );
            delay.play();
        } catch (IOException ex) {
            Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getMsg() {
        return msg;
    }

    public String getTitle() {
        return title;
    }
}
