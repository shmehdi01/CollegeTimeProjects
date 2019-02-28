/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeeManagement.Module.Main;

import FeeManagement.Methods.LoadExternalFx;
import FeeManagement.Module.Login.Login;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.PauseTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class MainController implements Initializable {

    private Pane menutray;

    /**
     * Initializes the controller class.
     */
    TranslateTransition ts;
    @FXML
    private ImageView menuicon;
    @FXML
    private JFXButton feepay;
    @FXML
    private JFXButton feedetail;
    @FXML
    private Pane profilepane;
  
    @FXML
    private BorderPane mainarea;
    @FXML
    private StackPane root;
    @FXML
    private AnchorPane rootpane;
    @FXML
    private JFXButton feestruct;
    private AnchorPane findstd;
    public static AnchorPane pop;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pop = rootpane;
        Login.LOADER = root;
        new LoadExternalFx().loadFxml(mainarea, rootpane);
        ts = new TranslateTransition(Duration.seconds(0.8), menutray);
        ts.setToX(-24);
        ts.play();
    }
    int count = 0;

    @FXML
    private void showMenu(MouseEvent event) {

        if (count % 2 == 0) {
            ts.setToX(186);
            ts.play();

            menuicon.setImage(new Image("/FeeManagement/Icon/back.png"));
        } else {
            ts.setToX(-24);
            ts.play();
            menuicon.setImage(new Image("/FeeManagement/Icon/menu.png"));
        }
        count++;
    }

    @FXML
    private void openFeePay(ActionEvent event) throws IOException {
        // btnAnim(feepay);
//        TranslateTransition y = new TranslateTransition(Duration.seconds(1.5), k);
//        y.setToX(10);
//        y.play();
    btnEffect(feepay);
        loadWin("/FeeManagement/Module/FeePayment/feepayment.fxml");

    }

    @FXML
    private void openFeeDetail(ActionEvent event) {

    }

//    private void btnAnim(Node node) {
//        RotateTransition rt = new RotateTransition(Duration.seconds(1), node);
//        ScaleTransition st = new ScaleTransition(Duration.seconds(1), node);
//        TranslateTransition ts = new TranslateTransition(Duration.seconds(0.8), node);
//        FadeTransition fd = new FadeTransition(Duration.seconds(0.4), mainarea);
//        rt.setFromAngle(0);
//        rt.setToAngle(360);
//
//        rt.setAutoReverse(true);
//        rt.setCycleCount(3);
//        rt.play();
//        if (rt.getStatus() == Animation.Status.RUNNING) {
//            st.setToX(7);
//            st.setToY(7);
//            st.setDelay(Duration.seconds(0));
//            st.play();
//            if (st.getStatus() == Animation.Status.RUNNING) {
//                ts.setToX(400);
//                ts.setToY(250);
//                ts.setDelay(Duration.seconds(0));
//                ts.play();
//            }
//            fd.setFromValue(1);
//            fd.setToValue(0);
//            fd.play();
//        }
//
//    }

    @FXML
    private void showProfile(MouseEvent event) {

//        RotateTransition rt = new RotateTransition(Duration.seconds(0.5), profilepane);
//        rt.setFromAngle(0);
//        rt.setToAngle(360);
//
//        rt.setAutoReverse(true);
//        rt.setCycleCount(2);
//        rt.play();
    }

    @FXML
    private void byeMsg(ActionEvent event) {
//        TranslateTransition tr = new TranslateTransition(Duration.seconds(0.5), bye);
//        //tr.setToX(300);
//        tr.setToY(600);
//        tr.play();
//        if (tr.getStatus() == Animation.Status.RUNNING) {
//            System.out.println("logout");
//        }
    }
    
    public void loadWin(String path) throws IOException {
        
        PauseTransition delay = new PauseTransition(Duration.seconds(0.8));
        delay.setOnFinished(ev -> {
            try {

                loadWinEffect(this.root, feepay);
                Parent root = FXMLLoader.load(getClass().getResource(path));
                
                this.root.getChildren().setAll(root);
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        delay.play();

    }

    void loadWinEffect(Node e, Node k) {

        FadeTransition x = new FadeTransition(Duration.seconds(0.8), e);
        x.setFromValue(0);
        x.setToValue(1);
        x.setCycleCount(1);
        x.setInterpolator(Interpolator.EASE_OUT);
        x.setAutoReverse(true);
        //x.setDelay(Duration.seconds(1.5));
        x.play();

    }

    void btnEffect(Node btn) {
        FadeTransition fd = new FadeTransition(Duration.seconds(0.4), mainarea);
        TranslateTransition ts = new TranslateTransition(Duration.seconds(0.8), btn);
        ts.setToX(-1000);
        fd.setFromValue(1);
        fd.setToValue(0.0);
        fd.setInterpolator(Interpolator.EASE_IN);
        fd.play();
        ts.play();
    }

    @FXML
    private void openFeeStruct(ActionEvent event) throws IOException {
        btnEffect(feestruct);
        loadWin("/FeeManagement/Module/FeeStructure/structure.fxml");
    }

    @FXML
    private void showFinder(ActionEvent event) throws IOException {
        
        loadWin("RegisterStd.fxml");
        
        
    }

}
