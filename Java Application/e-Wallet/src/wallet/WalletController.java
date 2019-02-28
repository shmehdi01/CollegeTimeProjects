/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wallet;

import Login.Action;
import Popup.Popup;
import Query.Run;
import Update.Transaction;
import Update.Txnhistory;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class WalletController implements Initializable {
    
    @FXML
    private TextField amtfield;
    @FXML
    private Button conbtn;
    Transaction txn = new Transaction();
    Action set = new Action();
    /**
     * Initializes the controller class.
     */
    TranslateTransition ttf, ttb;
    FadeTransition fdf, fdb;
    @FXML
    private Label addbtn;
    @FXML
    private Label balance;
    @FXML
    private TableColumn<Txnhistory, String> amtcol;
    @FXML
    private TableColumn<Txnhistory, String> actcol;
    @FXML
    private TableColumn<Txnhistory, String> datecol;
    
   
    @FXML
    private TableView<Txnhistory> table;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        amtfield.setVisible(false);
        conbtn.setVisible(false);
        try {
            balance.setText("₹ " + new Transaction().getWallet(set.getUserID()));
        } catch (SQLException ex) {
            Logger.getLogger(WalletController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void addWallet() throws SQLException, IOException {
        if (Integer.parseInt(amtfield.getText()) <= 0) {
            new Popup().infoPop("Add minimum ₹ 1 ");
        } else if (txn.updateWallet(set.getUserID(), Integer.parseInt(amtfield.getText()), "Added", "cr")) {
            new Popup().infoPop("Wallet Updated");
            balance.setText("₹ " + new Transaction().getWallet(set.getUserID()));
        }
        
    }
    
    public void animation() {
        amtfield.setVisible(true);
        conbtn.setVisible(true);
        ttf = new TranslateTransition(Duration.seconds(.6), amtfield);
        ttb = new TranslateTransition(Duration.seconds(.6), conbtn);
        fdf = new FadeTransition(Duration.seconds(.6), amtfield);
        fdb = new FadeTransition(Duration.seconds(.6), conbtn);
        fdf.setByValue(0.0);
        fdb.setByValue(0.0);
        fdf.setToValue(1.0);
        fdb.setToValue(1.0);
        ttf.setToY(-20);
        ttb.setToY(20);
        ttf.play();
        ttb.play();
        fdf.play();
        fdb.play();
        addbtn.setText("Cancel");
    }
    
    @FXML
    public void cancel() {
        ttf.setToY(0);
        ttb.setToY(0);
        fdf.setByValue(1.0);
        fdb.setByValue(1.0);
        fdf.setToValue(0.0);
        fdb.setToValue(0.0);
        ttf.play();
        ttb.play();
        fdf.play();
        fdb.play();
        addbtn.setText("Add Money");
    }
    int count = 0;
    
    @FXML
    public void show() {
        count++;
        if (count % 2 != 0) {
            animation();
        } else {
            cancel();
        }
        System.out.println(count);
    }
    
    @FXML
    private void goBack(MouseEvent event) throws IOException {
        new ModelView.ModelView().openWindow("/MainWindow/Main.fxml");
    }
    @FXML
    private void txnHis() throws SQLException {
        final ObservableList<Txnhistory> history = FXCollections.observableArrayList();
        String query = "SELECT amount,action,date FROM txntable WHERE userid = " + new Action().getUserID() + " ORDER by txnid DESC";
        
        ResultSet rs = new Run().readQuery(query);
        while (rs.next()) {
            history.add(new Txnhistory("₹ " + rs.getInt("amount") , rs.getString("action"), rs.getString("date")));
        }
        amtcol.setCellValueFactory(new PropertyValueFactory < Txnhistory, String > ("amount"));
        actcol.setCellValueFactory(new PropertyValueFactory < Txnhistory, String > ("action"));
        datecol.setCellValueFactory(new PropertyValueFactory < Txnhistory, String > ("date"));
        table.setItems(history);
    }
    
}
