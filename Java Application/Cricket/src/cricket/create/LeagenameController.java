/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket.create;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import cricket.db.DBConnection;
import cricket.function.LoadWin;
import cricket.function.TeamList;
import cricket.main.MainController;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class LeagenameController implements Initializable {
    
    DBConnection DBHandler;
    @FXML
    private JFXTextField leagename;
    @FXML
    private JFXComboBox<String> teamlist;
    @FXML
    private JFXListView<String> selectedlist;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DBHandler = DBConnection.getConnection();
        teamlist.setItems(new TeamList().getTeamlist());
    }    
    static String leage_name;
    @FXML
    private void next(ActionEvent event) throws IOException {
        leage_name = leagename.getText();
         new LoadWin("/cricket/create/creategroup.fxml");
    }
    
 
    
   static ObservableList <String> team =  FXCollections.observableArrayList();
    void addList(){
        String Tname = teamlist.getValue();
        if(isExistTeam(Tname)){
            System.out.println("already added");
        }else{
            team.add(Tname);
            selectedlist.setItems(team);
        }
        
    }

    @FXML
    private void addToList(MouseEvent event) {
        addList();
    }
    
    
    boolean isExistTeam(String team){
        for(int i=0;i<this.team.size();i++){
            if(team.equals(this.team.get(i)))
                return true;
        }
        return false;
    }
    
}
