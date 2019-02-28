/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket.create;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import cricket.db.DBConnection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import cricket.function.Team;
import cricket.function.TeamList;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class AddplayerController implements Initializable {

    @FXML
    private JFXComboBox<String> teamlist;
    @FXML
    private VBox vbtf;
    @FXML
    private Text info;
    DBConnection DBHandler;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DBHandler = DBConnection.getConnection();
        teamlist.setItems(new TeamList().getTeamlist());
    }

    int count = 0;

    @FXML
    private void add(MouseEvent event) {
        count++;

        if (count >= 5) {
            System.out.println("maximum 5");
            info.setText("Maximum 5 at one time");
        } else {
            JFXTextField tf = new JFXTextField();
            tf.setFocusColor(Color.web("#178b7f"));
            tf.setPromptText("Player " + (count + 1));
            vbtf.getChildren().add(tf);
        }
    }

    ObservableList<String> getText() {
        JFXTextField tf;
        ObservableList<Node> vbc = vbtf.getChildren();
        ObservableList<String> player = FXCollections.observableArrayList();
        for (int i = 0; i < vbc.size(); i++) {
            tf = (JFXTextField) vbc.get(i);
            System.out.println(tf.getText());
            player.add(tf.getText());
        }
        return player;
    }

    @FXML
    private void save(ActionEvent event) {
        ObservableList<String> team = getText();
        boolean done = false;
        for (int i = 0; i < team.size(); i++) {
            String name = team.get(i);

            String query = "INSERT INTO Players(teamid,name) VALUES('" + Team_ID + "','" + name.toUpperCase() + "')";
            done = DBHandler.updateQuery(query);

            System.out.println(query);
        }
        if (done) {
            System.out.println("Success");
            JOptionPane.showMessageDialog(null, "Player Name Saved");
        }
    }

    int Team_ID;

    @FXML
    private void getTeamName(ActionEvent event) {
        String Team_Name = teamlist.getValue();
        Team_ID = new Team("name", Team_Name).getTeamid();
    }

}
