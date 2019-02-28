/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeeManagement.component;

import FeeManagement.Methods.LoadExternalFx;
import FeeManagement.Module.Login.Login;
import static FeeManagement.Module.Login.Login.SCENE;
import FeeManagement.Module.Login.LoginController;
import static FeeManagement.component.ProfileController.profile;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javax.swing.Timer;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class TopbarController implements Initializable {

    @FXML
    private ImageView menuicon;

    @FXML
    private Text name;
    @FXML
    private ImageView profileicon;
    @FXML
    private BorderPane topbar;

    /**
     * Initializes the controller class.
     */
    //Pane menupane = SidemenuController.menutray;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        name.setText(LoginController.name);
        //shortcutKeys();
    }
    int count = 0;

    @FXML
    private void showMenu(MouseEvent event) {

        TranslateTransition ts = new TranslateTransition(Duration.seconds(0.8), SidemenuController.menuloader);
        RotateTransition rt = new RotateTransition(Duration.seconds(0.4), menuicon);
        rt.setFromAngle(0);
        rt.setToAngle(360);
        rt.play();
        if (count % 2 == 0) {
            ts.setToX(220);

            menuicon.setImage(new Image("/FeeManagement/Icon/back.png"));
        } else {
            ts.setToX(0);
            ts.play();
            menuicon.setImage(new Image("/FeeManagement/Icon/menu.png"));
        }
        ts.play();
        count++;
    }
    int procount = 0;

    @FXML
    private void showProfile(MouseEvent event) throws IOException {
        RotateTransition rt = new RotateTransition(Duration.seconds(0.5), profileicon);
        rt.setFromAngle(0);
        rt.setToAngle(360);

        rt.setAutoReverse(true);
        rt.setCycleCount(2);
        rt.play();
        if (procount == 0) {
            loadProfile(event);
            procount++;
        }
        TranslateTransition ts = new TranslateTransition(Duration.seconds(0.3), profile);
        ts.setToX(500);
        FadeTransition fd = new FadeTransition(Duration.seconds(0.5), ProfileController.profile);
        fd.setFromValue(0);
        fd.setToValue(1);
        ts.play();
        fd.play();

//        TranslateTransition tt = new TranslateTransition(Duration.seconds(0.5), ProfileController.profile);
//        tt.setToY(500);
//        tt.setAutoReverse(true);
//        tt.setCycleCount(2);
//        tt.play();
    }

    void loadProfile(MouseEvent e) throws IOException {

        //Login.LOADER.setDisable(true);
        AnchorPane profile = FXMLLoader.load(getClass().getResource("/FeeManagement/component/Profile.fxml"));
//        Scene scene = new Scene(profile);
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.isAlwaysOnTop();
//        stage.initStyle(StageStyle.UNDECORATED);
//        stage.show();
        profile.setTranslateX(e.getSceneX());
        profile.setTranslateY(80);
        LoadExternalFx.SCENE.getChildren().add(profile);

    }

    @FXML
    private void full(MouseEvent event) {
        if (!Login.STAGE.isFullScreen()) {
            Login.STAGE.setFullScreen(true);
        }
    }

void shortcutKeys() {
        final KeyCombination ALTX = new KeyCodeCombination(KeyCode.X, KeyCodeCombination.ALT_DOWN);
        Login.SCENE.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                KeyCode code = e.getCode();
                if (code == KeyCode.F12) {
                    if (!Login.STAGE.isFullScreen()) {
                        Login.STAGE.setFullScreen(true);
                    }
                }
                if ((ALTX.match(e))) {
                    Login.STAGE.close();
                }
            }
        });
    }
    

}
