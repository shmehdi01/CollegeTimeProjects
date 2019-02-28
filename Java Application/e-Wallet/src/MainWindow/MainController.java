/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainWindow;

import Login.Action;
import ModelView.ModelView;
import Update.Transaction;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class MainController implements Initializable {

    Stage stage;
    @FXML
    private Rectangle transferBtn;
    @FXML
    private Text addMoney;
    @FXML
    private ImageView menubtn;
    @FXML
    private AnchorPane menutray;
    @FXML
    private ImageView dp;
    @FXML
    private AnchorPane closemenu;
    @FXML
    private AnchorPane profileview;
    @FXML
    private ImageView profiledp;
    @FXML
    private VBox profleclose;
    @FXML
    private Label profilename;
    @FXML
    private Label profilenum;
    Action set = new Action();
    Transaction txn = new Transaction();
    @FXML
    private Label profileemail;
    @FXML
    private Label sname;
    @FXML
    private Label snum;
    @FXML
    private Label balance;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dp.setClip(new Circle(24, 23, 22));
        try {
            showData();
            // profileview.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* Method For Show User Data*/

    private void showData() throws SQLException {
        Transaction txn = new Transaction();
        //txn.getDetail(set.getUserID());
        profiledp.setClip(new Circle(45, 45, 40));
        profilename.setText(set.getUserName());
        profilenum.setText(set.getMob());
        sname.setText(set.getUserName());
        snum.setText(set.getMob());
        balance.setText("₹ " + txn.getWallet(set.getUserID()));
    }

    @FXML
    public void addMoney() throws IOException, Exception {
        //new ModelView().openWindow("/addMoney/addMoney.fxml");

    }

    @FXML
    public void openRecharge() throws IOException {
        new ModelView().openWindow("/Recharge/Recharge.fxml");
    }

    @FXML
    public void openWallet() throws IOException {
        new ModelView().openWindow("/wallet/wallet.fxml");
    }

    @FXML
    public void logout() throws IOException {
        new ModelView().openWindow("/Login/Login.fxml");
        ModelView.stage.close();
    }
    
    @FXML
    public void transfer() throws IOException{
        new ModelView().openWindow("/Transfer/transfer.fxml");
    }

    /* Below code for animation and effect*/
    TranslateTransition slideleft;

    @FXML
    public void showMenu() {
        slideleft = new TranslateTransition(Duration.seconds(0.8), menutray);
        slideleft.setToX(200);
        slideleft.play();
    }

    @FXML
    public void closeMenu() {
        slideleft.setToX(0);
        slideleft.play();
    }
    FadeTransition sp;
    TranslateTransition spt;

    @FXML
    public void showProfile() {
        sp = new FadeTransition(Duration.seconds(0.5), profileview);
        spt = new TranslateTransition(Duration.seconds(0.5), profileview);
        spt.setToX(0);
        spt.setToY(350);
        spt.play();
        sp.setByValue(0.0);
        sp.setToValue(1.0);
        //profileview.setVisible(true);
        sp.play();
    }

    @FXML
    public void closeProfie() {
        spt = new TranslateTransition(Duration.seconds(0.5), profileview);
        sp.setByValue(1.0);
        sp.setToValue(0.0);
        sp.play();
        spt.setToX(200);
        spt.play();
        //profileview.setVisible(false);

    }

}
