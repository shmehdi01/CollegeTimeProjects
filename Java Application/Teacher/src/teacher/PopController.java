/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher;

import static com.sun.javaws.ui.SplashScreen.hide;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import sun.plugin.javascript.navig.Anchor;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class PopController implements Initializable {

    /**
     * Initializes the controller class.
     */
        TeacherModel model = new TeacherModel();
    @FXML
    Label id;
    @FXML
    Label name;
    @FXML
    Label contact;
    @FXML
    Rectangle pop;
    @FXML
    Circle close;
    @FXML
    AnchorPane ap;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            Random r = new Random();
            
        try {
                ArrayList <TeacherData> td = model.getTeacherList();
                int x = r.nextInt(td.size());
                for(int i = 0; i<x; i++)
                {
                    id.setText(td.get(i).getId());
                    name.setText(td.get(i).getFirstname()+ " " + td.get(i).getLastname());
                    contact.setText(td.get(i).getMob());
                }   } catch (SQLException ex) {
                Logger.getLogger(PopController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        TranslateTransition trans = new TranslateTransition();
        trans.setDuration(Duration.seconds(5));
        trans.setNode(pop);
        //trans.setNode(close);
        trans.setToY(50);
        
        ScaleTransition st = new ScaleTransition(Duration.seconds(5), pop);
        st.setToX(2);
        st.setToY(2);
       
        RotateTransition rt = new RotateTransition(Duration.seconds(5), pop);
        rt.setByAngle(360);
        //trans.play();
        //st.play();
        rt.play();
        
        
    }   
    
    
    
    
    @FXML
    public void close()
    {
        POP.popStage.close();
    }
    
}
