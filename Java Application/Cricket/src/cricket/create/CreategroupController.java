/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket.create;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import cricket.function.CreateGroup;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class CreategroupController implements Initializable {

    @FXML
    private JFXListView<String> selectedlist;
    @FXML
    private JFXRadioButton rand;
    @FXML
    private JFXRadioButton manual;
    @FXML
    private JFXListView<String> groupA;
    @FXML
    private JFXListView<String> groupB;
    @FXML
    private Text leagename;
     ObservableList<String> listt = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listt = LeagenameController.team;
        leagename.setText(LeagenameController.leage_name.toUpperCase());
        ToggleGroup tg = new ToggleGroup();
        rand.setToggleGroup(tg);
        manual.setToggleGroup(tg);
        selectedlist.setItems(LeagenameController.team);
    }    
    
    void makeRandGroup(){
        CreateGroup cg = new CreateGroup(selectedlist.getItems());
        groupA.setItems(cg.getGroupA());
        groupB.setItems(cg.getGroupB()); 
    }

    @FXML
    private void createGp(ActionEvent event) {
        if(rand.isSelected() == true)
            makeRandGroup();
        else if(manual.isSelected() == true)
            System.out.println("working");
        else System.out.println("select random or manual");
    }

    @FXML
    private void save(ActionEvent event) {
    }
}
