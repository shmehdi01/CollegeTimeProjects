/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.modules.adduser;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.swing.JOptionPane;
import library.management.database.DBConnection;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class StudentController implements Initializable {

    @FXML
    private JFXTextField sid;
    @FXML
    private JFXTextField roll;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField branch;
    @FXML
    private JFXTextField session;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    @FXML
    private void addStudent() throws ClassNotFoundException, SQLException{
        String id = sid.getText();
        String rolln = roll.getText();
        String name = this.name.getText();
        String branch = this.branch.getText();
        String sess = session.getText();
        if(id.isEmpty() || rolln.isEmpty() || name.isEmpty() || branch.isEmpty() || sess.isEmpty())
            JOptionPane.showMessageDialog(null, "Field is Empty");
        else{
           String query = "INSERT INTO student(sid,roll,name,branch,session) VALUES(" +
                    "'"+ id + "'," + 
                    "'"+ rolln + "'," +
                    "'"+ name + "'," +
                   "'"+ branch + "'," +
                    "'"+ sess + "')";
            System.out.println(query);
             boolean done = new DBConnection().insertQuery(query);

            if(done){
                JOptionPane.showMessageDialog(null, "Student Added Successfully");
            }
        }
            
    }
    
}
