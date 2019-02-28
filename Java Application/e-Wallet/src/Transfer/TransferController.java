/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transfer;

import Login.Action;
import Popup.Popup;
import Update.Refresh;
import Update.Transaction;
import Validation.Validation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class TransferController implements Initializable {

    @FXML
    private Label close;
    @FXML
    private TextField mobile;
    @FXML
    private TextField amount;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void closeWin() {
        mobile.setText("");
        amount.setText("");
        ModelView.ModelView.stage.close();
    }

    @FXML
    public void doTransfer() throws SQLException, IOException {
        String mob = mobile.getText();
        String amt = amount.getText();
        int wallet = new Transaction().getWallet(new Action().getUserID());
        Refresh get = new Refresh();
        if (mob.isEmpty() || amt.isEmpty()) {
            new Popup().infoPop("Fields is empty");
        } 
        else if(Integer.parseInt(amt)<=0){
            new Popup().infoPop("Minimum amount ₹ 1");
        }
        else if (!new Validation().checkPhoneNum(mob)) {
            new Popup().infoPop("Mobile number not correct");
        } else {
            get.getUserInfo(mob);
            String rcvrname = get.getUserName();
            int rcvrid = get.getUserId();
            int myid = new Action().getUserID();
            String mynum = new Action().getMob();
            String myname = new Action().getUserName();
            if (rcvrid == 0) {
                new Popup().infoPop("Number is not registered");
            } 
            else if(mob.equals(mynum)){
                new Popup().infoPop("Failed !! sending to own number");
            }
            else if (Integer.parseInt(amt) > wallet) {
                new Popup().infoPop("Insuficient Wallet");
            } else {
                boolean debit = new Transaction().updateWallet(myid, (-1 * Integer.parseInt(amt)), "Transfer to " + mob + "/" + rcvrname, "dr");
                boolean credit = new Transaction().updateWallet(rcvrid, (Integer.parseInt(amt)), "Received by " + mynum + "/" + myname, "cr");
                if (debit && credit) {
                    Login.Login.loginstage.close();
                    closeWin();
                    new ModelView.ModelView().openWindow("/MainWindow/Main.fxml");
                    new Popup().confirm("Sent Successfully to", rcvrname, "₹ " + amt);
                    
                }
            }
        }

    }
}
