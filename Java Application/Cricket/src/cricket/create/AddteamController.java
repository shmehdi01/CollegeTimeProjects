/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket.create;

import com.jfoenix.controls.JFXTextField;
import cricket.db.DBConnection;
import cricket.main.MainController;
import cricket.main.MainLoader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class AddteamController implements Initializable {

    @FXML
    private VBox vb;
    @FXML
    private JFXTextField tf0;
    @FXML
    private Text info;

    DBConnection DBHandler;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DBHandler = DBConnection.getConnection();
    }
    int count = 0;

    @FXML
    private void add(MouseEvent event) {
        count++;

        if (count >= 5) {
            System.out.println("maximum 5");
            info.setText("Maximum 5 Only");
        } else {
            JFXTextField tf = new JFXTextField();
            tf.setFocusColor(Color.web("#178b7f"));
            tf.setPromptText("Team Name " + (count + 1));
            vb.getChildren().add(tf);
        }

    }

    @FXML
    private void loadMain(ActionEvent event) throws IOException {
        ObservableList<String> team = getText();
        boolean done = false;
        for (int i = 0; i < team.size(); i++) {
            String name = team.get(i);
            String nick = nickname(name.toUpperCase());
            String query = "INSERT INTO Teams(name,nickname) VALUES('" + name.toUpperCase() + "','" + nick  + "')";
            done = DBHandler.updateQuery(query);
            
            System.out.println(query);
        }
        if(done){
            System.out.println("Success");
            JOptionPane.showMessageDialog(null, "Team Name Saved");
        }

    }

    ObservableList<String> getText() {
        JFXTextField tf;
        ObservableList<Node> vbc = vb.getChildren();
        ObservableList<String> team = FXCollections.observableArrayList();
        for (int i = 0; i < vbc.size(); i++) {
            tf = (JFXTextField) vbc.get(i);
            System.out.println(tf.getText());
            team.add(tf.getText());
        }
        return team;
    }

    String nickname(String n) {

        String F = Character.toString(n.charAt(0));

        for (int i = 0; i < n.length(); i++) {
            if (Character.isSpace(n.charAt(i))) {
                F = F + Character.toString(n.charAt(i + 1));
            }
        }
        return (F);
    }

}
