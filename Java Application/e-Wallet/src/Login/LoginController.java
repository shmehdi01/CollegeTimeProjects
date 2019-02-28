/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.sql.SQLException;
import javafx.scene.control.PasswordField;
import ModelView.*;
import Validation.Validation;
import java.io.IOException;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import createTable.createTables;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class LoginController implements Initializable {

    @FXML
    private TextField mobile;
    @FXML
    private TextField pass;
    @FXML
    private Button login;
    @FXML
    private Text forget;
    @FXML
    private Text signup;
    @FXML
    private AnchorPane drawer;
    @FXML
    private Button cancel;
    @FXML
    private TextField name;
    @FXML
    private TextField newmob;
    @FXML
    private PasswordField newpass;
    @FXML
    private PasswordField newrepass;
    @FXML
    private Button register;

    Action action = new Action();
    ModelView mv = new ModelView();
    @FXML
    private Label warn;
    @FXML
    private Label info;
    @FXML
    private Circle minimize;
    @FXML
    private Circle close;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            createTables c = new createTables();
                    } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* Code for action performed*/
    @FXML
    public void getLogin() throws SQLException, IOException {
        System.out.println(new Validation().checkPhoneNum(mobile.getText()) + " lol");
        boolean isUser = action.isValidUser(mobile.getText(), pass.getText());
        if (isUser) {
            
            mv.openWindow("/MainWindow/Main.fxml");
        }
        else {
            warn.setText("Username/password incorrect !!");
            clear();
        }

        System.out.println(isUser);
    }

    @FXML
    public void Registration() throws SQLException, IOException {
        action.doSignup(newmob.getText(), newpass.getText(), name.getText());
    }
    @FXML
    public void closeWindow(){
        close.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
               Platform.exit(); 
            }
        });
    }
    @FXML
    public void minWindow(){
        minimize.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                Login.loginstage.setIconified(true);
            }
        });
    }
    

    /* code of validation */
    @FXML
    public boolean matchPass(){
        if(newrepass.getText().isEmpty())
            info.setText("");
        if(newpass.getText().equals(newrepass.getText()))
        {
            info.setTextFill(Color.web("#fff"));
            info.setText("Password Matched ✓✓");
            return true;
        }
        else{
            info.setTextFill(Color.web("#c61515"));
            info.setText("Password did not Matched ✗✗");
            return false;
        }
    }

    private void clear() {
        mobile.setText("");
        pass.setText("");
        name.setText("");
        newmob.setText("");
        newpass.setText("");
        newrepass.setText("");
    }

    /* Method for Validation*/
 /* below code for animation and effect*/
    int count = 0;

    @FXML
    public void findPass() {
        count++;
        if (count % 2 != 0) {
            setLayoutPass();
        } else {
            resetLayout();
        }

    }

    @FXML
    public void doSignUp() {
        count++;
        if (count % 2 != 0) {

            appDraw();
        } else {
            appDrawOut();
        }
    }

    TranslateTransition forgetEffect, draw;
    FadeTransition fadeHidePass;

    private void appDraw() {
        draw = new TranslateTransition(Duration.seconds(1), drawer);
        draw.setToY(312);
        draw.play();
    }

    @FXML
    public void appDrawOut() {
        draw.setToY(0);
        draw.play();
    }

    private void setLayoutPass() {
        login.setText("Find Password");
        forget.setText("Get Login Here ");
        fadeHidePass = new FadeTransition(Duration.seconds(0.5), pass);
        fadeHidePass.setByValue(1.0);
        fadeHidePass.setToValue(0.0);
        fadeHidePass.play();
        forgetEffect = new TranslateTransition();
        forgetEffect.setDuration(Duration.seconds(0.5));
        forgetEffect.setNode(login);
        forgetEffect.setToY(-50);
        forgetEffect.play();
    }

    private void resetLayout() {
        // pass.setVisible(true);
        login.setText("Login");
        forget.setText("Forget Password");
        fadeHidePass.setByValue(0.0);
        fadeHidePass.setToValue(1.0);
        fadeHidePass.play();
        forgetEffect.setToY(0);
        forgetEffect.play();
    }

}
