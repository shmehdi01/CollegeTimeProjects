/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket.create;

import com.jfoenix.controls.JFXRadioButton;
import cricket.function.LoadWin;
import cricket.main.MainLoader;
import static cricket.main.MainLoader.main_scene;
import cricket.scoreboard.function.BoardStruct;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class BatfirstController implements Initializable {

    @FXML
    private JFXRadioButton team1;
    @FXML
    private JFXRadioButton team2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(SelectteamController.sp1.getList());
        ToggleGroup tg = new ToggleGroup();
        team1.setToggleGroup(tg);
        team2.setToggleGroup(tg);
        team1.setText(QuickController.Team_One_Name);
        team2.setText(QuickController.Team_Two_Name);
    }

    String getBattingTeam() {
        if (team1.isSelected()) {
            return team1.getText();
        }
        if (team2.isSelected()) {
            return team2.getText();
        } else {
            return null;
        }
    }
    
       String getBallingTeam() {
        if (!team1.isSelected()) {
            return team1.getText();
        }
        if (!team2.isSelected()) {
            return team2.getText();
        } else {
            return null;
        }
    }

    void loadPop() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("initplayer.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(getBattingTeam());
        stage.show();
    }
    static String batting_team = "";
    static String bowling_team = "";

    
    public static BoardStruct bs;
    @FXML
    private void next(ActionEvent event) {
        bs = new BoardStruct(batting_team, getBallingTeam(), QuickController.ovr, Initplayer.p1, Initplayer.p2, OpenerballerController.bowler,Initplayer.batplayers,OpenerballerController.ballplayers);
        System.out.println("bowling team is " + getBallingTeam());
        
        start();
    }
    
    void start(){
        new LoadWin("/cricket/scoreboard/mainboard.fxml");
        MainLoader.main_stage.setTitle("Quick Match");
        MainLoader.main_stage.setHeight(700);
        MainLoader.main_stage.setWidth(1200);
        MainLoader.main_stage.centerOnScreen();
    }

    @FXML
    private void popPlayers1(ActionEvent event) throws IOException {
        batting_team = getBattingTeam(); 
        bowling_team = getBallingTeam();
        new LoadWin().loadPop(batting_team, "/cricket/create/initplayer.fxml");
    }

    @FXML
    private void popPlayers2(ActionEvent event) throws IOException {
        batting_team = getBattingTeam();
        bowling_team = getBallingTeam();
        new LoadWin().loadPop(batting_team, "/cricket/create/initplayer.fxml");
    }

}
