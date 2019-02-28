/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeeManagement.component;

import FeeManagement.Module.FeePayment.FeepaymentController;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class MonthController implements Initializable {

    @FXML
    private Pane monthpane;
    @FXML
    private Label PAID_AMOUNT;
    @FXML
    private Label DUES_AMOUNT;
    @FXML
    private Label PAID_BY;
    @FXML
    private Label PAID_DATE;
    @FXML
    private JFXButton addduesbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PAID_AMOUNT.setText(FeepaymentController.Paid_Amt);
        DUES_AMOUNT.setText(FeepaymentController.Dues_Amt);
        PAID_BY.setText(FeepaymentController.Paid_by);
        PAID_DATE.setText(FeepaymentController.Paid_Amt);
        if(Integer.parseInt(DUES_AMOUNT.getText())<=0){
            addduesbtn.setDisable(true);
        }
        else {
            addduesbtn.setDisable(false);
        }
        anim();
    }
    TranslateTransition slide;
    FadeTransition fade;

    void anim() {
//        slide = new TranslateTransition(Duration.seconds(0.8), monthpane);
//        slide.setToX(-300);
//        slide.play();
        fade = new FadeTransition(Duration.seconds(0.8), monthpane);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    void resetAnim() {
//        slide.setToX(0);
//        slide.play();
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();

        PauseTransition delay = new PauseTransition(Duration.seconds(0.8));
        delay.setOnFinished(e -> {
            FeepaymentController.loadpane.getChildren().remove(FeepaymentController.pane);
        });
        delay.play();
    }
    
    @FXML
    private void close(MouseEvent event) {

        resetAnim();

    }

}
