/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket.create;

import com.jfoenix.controls.JFXComboBox;
import cricket.function.LoadWin;
import cricket.function.Team;
import cricket.function.TeamList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class QuickController implements Initializable {

    @FXML
    private JFXComboBox<String> teamlist1;
    @FXML
    private JFXComboBox<String> teamlist2;
    @FXML
    private Text team1;
    @FXML
    private Text team2;
    @FXML
    private JFXComboBox<Integer> overlist;

    private ObservableList <Integer> over = FXCollections.observableArrayList(5,10,12,15,20);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      teamlist1.setItems(new TeamList().getTeamlist());
      overlist.setItems(over);
    }    

    @FXML
    private void addSecondTeamList(ActionEvent event) {
        ObservableList <String> teamlist2 = new TeamList().getTeamlist();
        teamlist2.remove(teamlist1.getValue());
        this.teamlist2.setItems(teamlist2);
    }

    @FXML
    private void setTeamLabel(ActionEvent event) {
        team1.setText(teamlist1.getValue());
        team2.setText(teamlist2.getValue());
    }

    static int Team_One_ID = 0;
    static int Team_Two_ID = 0;
    static String Team_One_Name = "";
    static String Team_Two_Name = "";
    static int ovr = 0;
    @FXML
    private void goNext(ActionEvent event) {
        Team_One_Name = teamlist1.getValue();
        Team_Two_Name = teamlist2.getValue();
        Team_One_ID = new Team("name", Team_One_Name).getTeamid();
        Team_Two_ID = new Team("name", Team_Two_Name).getTeamid();
        ovr = overlist.getValue();
        new LoadWin("/cricket/create/selectteam.fxml");
    }
    
}
