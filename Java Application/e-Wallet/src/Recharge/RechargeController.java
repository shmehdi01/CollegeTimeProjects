/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recharge;

import Login.Action;
import Popup.Popup;
import Update.Transaction;
import Validation.Validation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class RechargeController implements Initializable {

    @FXML
    private ComboBox<String> operator;
    ObservableList<String> operatorlist = FXCollections.observableArrayList("Airtel", "Aircel", "BSNL", "Idea", "Reliance", "Tata Docomo", "Telenor", "Vodafone");
    @FXML
    private ComboBox<String> circle;
    ObservableList<String> circlelist = FXCollections.observableArrayList("Andhra Pradesh & Telengana", "Assam", "Bihar & Jharkhand", "Chennai",
            "Delhi NCR", "Gujrat", "Haryana", "J&K");
    @FXML
    private TextArea mob;
    @FXML
    private TextArea bal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        operator.setItems(operatorlist);
        circle.setItems(circlelist);
    }

    @FXML
    public void goBack() throws IOException {
        new ModelView.ModelView().openWindow("/MainWindow/Main.fxml");
    }

    @FXML
    public void doRecharge() throws SQLException, IOException {
        String mobile = mob.getText();
        String opr = operator.getValue();
        String cir = circle.getValue();
        String amt = bal.getText();
        int wallet = new Transaction().getWallet(new Action().getUserID());
        if (mobile.isEmpty() || opr.isEmpty() || cir.isEmpty() || amt.isEmpty()) {
            new Popup().infoPop("Filed is empty");
        }
         else if(Integer.parseInt(amt)<=0){
            new Popup().infoPop("Can't recharge with ₹ 0 or less");
        }
        else if (!new Validation().checkPhoneNum(mobile)) {
            new Popup().infoPop("Mobile number not correct");
        } else {
            if (wallet < Integer.parseInt(amt)) {
               new Popup().infoPop("Insufficient wallet");
            }
            else{
                 new Transaction().updateWallet(new Action().getUserID(), (-1 * Integer.parseInt(amt)), "Recharge " + mobile, "dr");
                 new Popup().infoPop("Recharge Successful");
            }

        }
    }

}
