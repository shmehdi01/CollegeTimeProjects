/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket.scoreboard;

import cricket.create.BatfirstController;
import static cricket.function.LoadWin.load_pop_stage;
import cricket.scoreboard.function.BoardStruct;
import java.net.URL;
import java.util.ResourceBundle;
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
public class PlayersController implements Initializable {
 BoardStruct board ;
    @FXML
    private CheckListView<String> playerlist;
    @FXML
    private Text title;
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        board = BatfirstController.bs;
        setBatPlayer = false;
           setBallPlayer = false;
        setList();
    }
    String team ="";
    void setList(){
        team = MainboardController.Team_Name_For_List;
        if(team.equals(board.getBatTeamName())){
            playerlist.setItems(board.getBatPlayList());
            title.setText("Choose Next Batsman");
        }
        if(team.equals(board.getBallTeamName())){
            playerlist.setItems(board.getBallPlayList());
            title.setText("Choose Next Bowler");
        }
    }
   
    public static boolean setBatPlayer = false;
    public static boolean setBallPlayer = false;
    @FXML
    private void setPlayer(ActionEvent event) {
       
        ObservableList <String> p = playerlist.getCheckModel().getCheckedItems();
        if(team.equals(board.getBatTeamName())){
            board.setNextBatsman(p.get(0));
            setBatPlayer = true;
            setBallPlayer = false;
        }
        if(team.equals(board.getBallTeamName())){
           board.setNextBowler(p.get(0));
           setBatPlayer = false;
           setBallPlayer = true;
        }
        load_pop_stage.close();
    }
    
    
}
