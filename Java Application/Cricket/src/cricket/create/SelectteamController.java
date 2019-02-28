/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket.create;

import cricket.function.LoadWin;
import cricket.function.PlayerList;
import cricket.function.PlayingTeam;
import cricket.function.SelectedPlayer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import org.controlsfx.control.CheckListView;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class SelectteamController implements Initializable {

    @FXML
    private Text team1;
    @FXML
    private Text team2;
    @FXML
    private CheckListView<String> teamlist1;
    @FXML
    private CheckListView<String> teamlist2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        team1.setText(QuickController.Team_One_Name);
        team2.setText(QuickController.Team_Two_Name);
        teamlist1.setItems(new PlayerList("teamid", QuickController.Team_One_ID).getPlayerlist());
        teamlist2.setItems(new PlayerList("teamid", QuickController.Team_Two_ID).getPlayerlist());
        // TODO
    }    
    static SelectedPlayer sp1;
    static SelectedPlayer sp2;
    static PlayingTeam pt1;
    static PlayingTeam pt2;
    @FXML
    private void goNext(ActionEvent event) {
        sp1 = new SelectedPlayer(teamlist1.getCheckModel().getCheckedItems());
        sp2 = new SelectedPlayer(teamlist2.getCheckModel().getCheckedItems());
        pt1 = new PlayingTeam(team1.getText());
        pt2 = new PlayingTeam(team2.getText());
        new LoadWin("/cricket/create/batfirst.fxml");
    }
    
}
