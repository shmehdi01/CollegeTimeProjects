/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket.create;

import cricket.function.LoadWin;
import cricket.function.SelectedPlayer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
public class Initplayer implements Initializable {

    @FXML
    private Text heading;
    @FXML
    private CheckListView<String> batsmanlist;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      setList();
            
    }   
    
    void setList(){
        String bat_T = BatfirstController.batting_team;
        if(bat_T.equals(SelectteamController.pt1.getTeam()))
            batsmanlist.setItems(SelectteamController.sp1.getList());
        
        if(bat_T.equals(SelectteamController.pt2.getTeam()))
            batsmanlist.setItems(SelectteamController.sp2.getList());    
    }
    
    static SelectedPlayer opener;
    static String p1;
    static String p2;
    static ObservableList <String> batplayers;
    @FXML
    private void getTwoPlayers(ActionEvent event) throws IOException {
        opener = new SelectedPlayer(batsmanlist.getCheckModel().getCheckedItems());
        ObservableList <String> p = opener.getList();
        p1 = p.get(0);
        p2 = p.get(1);
        batplayers = batsmanlist.getItems();
        System.out.println(opener.getList());
        new LoadWin().loadBowler(BatfirstController.bowling_team);
    }
    
}
