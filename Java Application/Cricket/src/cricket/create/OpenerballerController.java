/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket.create;

import com.jfoenix.controls.JFXComboBox;
import cricket.function.LoadWin;
import cricket.scoreboard.MainboardController;
import cricket.scoreboard.function.BoardStruct;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class OpenerballerController implements Initializable {

    @FXML
    private JFXComboBox<String> bowlerlist;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setList();
    }

    void setList() {
        String bowl_T = BatfirstController.bowling_team;
        if (bowl_T.equals(SelectteamController.pt1.getTeam())) {
            bowlerlist.setItems(SelectteamController.sp1.getList());
        }

        if (bowl_T.equals(SelectteamController.pt2.getTeam())) {
            bowlerlist.setItems(SelectteamController.sp2.getList());
        }
    }

    static String bowler = "";
    static ObservableList<String> ballplayers;

    @FXML
    private void getPlayer(ActionEvent event) {
        bowler = bowlerlist.getValue();
        ballplayers = bowlerlist.getItems();
        LoadWin.load_pop_stage.close();
    }

}
