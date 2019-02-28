
package test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MainController {
    
    @FXML
    Label l;
    @FXML
    TextField user;
    @FXML
    PasswordField pass;
    
    
    @FXML
    public void Clicked(ActionEvent e){
        String s = user.getText();
        if(user.getText().equals("rizz") && pass.getText().equals("7499"))
        l.setText("Login Succesfull");
        else
            l.setText("Login Failed");
    }
}
