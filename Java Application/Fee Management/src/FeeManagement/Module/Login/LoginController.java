/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeeManagement.Module.Login;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.swing.JOptionPane;
import FeeManagement.Database.DBConnect;
import FeeManagement.Module.Main.LoadMain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField user;
    @FXML
    private JFXPasswordField pass;
    Connection con;
    public static String name;
     DBConnect DBhandle;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           DBhandle = DBConnect.connectDB();
    }    

    @FXML
    private void getLogin(ActionEvent event) throws IOException, SQLException {
        String user = this.user.getText();
        String pass = this.pass.getText();
        if(user.isEmpty() || pass.isEmpty())
            JOptionPane.showMessageDialog(null, "Field is empty");
        else{
            if(isValidUser(user, pass))
                loadMain();
        }
    }
    
    void loadMain() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/FeeManagement/Module/Main/Main.fxml"));
        Scene scene = Login.SCENE;
        scene.setRoot(root);
        Login.STAGE.setScene(scene);
        Login.STAGE.setFullScreen(true);
        Login.STAGE.show();

    }
    
    private boolean isValidUser(String user, String pass) throws SQLException {
        String query = "SELECT * FROM user WHERE user = '" + user + "'";
        ResultSet rs = DBhandle.execQuery(query);
        if(rs.next()){
            if(user.equals(rs.getString("user")) && pass.equals(rs.getString("pass"))){
                name =rs.getString("fname");
                return true;
            }
                
        }
        return false;
    }
    
}
