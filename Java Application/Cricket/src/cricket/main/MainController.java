/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket.main;

import cricket.function.LoadWin;
import cricket.function.InitTable;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class MainController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private BorderPane border_root;
    
    public static BorderPane setter;
    private Menu f;
    @FXML
    private Menu file;
    @FXML
    private Menu edit;
    @FXML
    private Menu help;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setter = border_root;
        new InitTable();
        
    }    

    @FXML
    private void createLeage(ActionEvent event) throws IOException {
        new LoadWin("/cricket/create/leagename.fxml");
    }

    @FXML
    private void addTeam(ActionEvent event) {
        new LoadWin("/cricket/create/addteam.fxml");
    }

    @FXML
    private void dashboard(ActionEvent event) {
        new LoadWin().dashboard();
    }

    @FXML
    private void addPlayer(ActionEvent event) {
        new LoadWin("/cricket/create/addplayer.fxml");
    }

    @FXML
    private void startQuick(ActionEvent event) {
        new LoadWin("/cricket/create/quick.fxml");
    }
    
}
