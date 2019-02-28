/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeeManagement.Module.FeeStructure;

import FeeManagement.Database.DBConnect;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import FeeManagement.Database.DBConnect;
import FeeManagement.Methods.LoadExternalFx;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class StructureController implements Initializable {

    @FXML
    private ComboBox<String> feetypelist;
    @FXML
    private ComboBox<String> timelist;
    @FXML
    private ComboBox<String> classlist;
    @FXML
    private JFXTextField amount;

    /**
     * Initializes the controller class.
     */
    DBConnect DBHandler;
    @FXML
    private AnchorPane rootpane;
    @FXML
    private BorderPane structurearea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new LoadExternalFx().loadFxml(structurearea, rootpane);
        DBHandler = DBConnect.connectDB();
        try {
            getFeeType();
            getFeeTime();
            getCls();
        } catch (SQLException ex) {
            Logger.getLogger(StructureController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void savedata(ActionEvent event) {
        insetData();
    }

    void getFeeType() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        String query = "SELECT * FROM fees";
        ResultSet rs = DBHandler.execQuery(query);
        while (rs.next()) {
            list.add(rs.getString("fees_heading"));
            //System.out.println(rs.getString("fees_heading"));
        }
        feetypelist.setItems(list);
    }
    
    void getFeeTime() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        String query = "SELECT * FROM fee_type";
        ResultSet rs = DBHandler.execQuery(query);
        while (rs.next()) {
            list.add(rs.getString("fee_type"));
            //System.out.println(rs.getString("fees_heading"));
        }
        timelist.setItems(list);
    }
    
      void getCls() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        String query = "SELECT * FROM class";
        ResultSet rs = DBHandler.execQuery(query);
        while (rs.next()) {
            list.add(rs.getString("class"));
            //System.out.println(rs.getString("fees_heading"));
        }
        classlist.setItems(list);
    }
      
      void insetData(){
          String fee = feetypelist.getValue();
          String time = timelist.getValue();
          String cls = classlist.getValue();
          String amount = this.amount.getText();
          String query = "INSERT INTO fee_structure(fee_heading,amount,class,time)"
                  + "VALUES('" + fee + "','" + amount
                  + "','" + cls
                  + "','" + time
                  + "')";
          System.out.println(query);
          if(DBHandler.updateQuery(query))
              System.out.println("updated");
      }

}
