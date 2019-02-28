/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher;



import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class TeacherGUIController implements Initializable {
     TeacherModel model = new TeacherModel();
    /**
     * Initializes the controller class.
     */
     @FXML
     private Label isConnect;
     @FXML
     private Label id;//
     @FXML
     private Label firstName; 
     @FXML
     private Label  lastName;
     @FXML
     private Label  dob;
     @FXML
     private Label gender;
     @FXML
     private Label city; // mobile, email, subject, qualification, attendence ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       if(model.isConnected())
            // System.out.println("conne");
           isConnect.setText("Database is Connected");
       else
            // System.out.println("no");
           isConnect.setText("Not Connected");
       
        TranslateTransition trans = new TranslateTransition();
        trans.setDuration(Duration.seconds(3));
        trans.setNode(isConnect);
        trans.setToY(-100);
        
        ScaleTransition st = new ScaleTransition();
        st.setToX(2);
        st.setToY(2);
        
        trans.play();
        st.play();
    }    
    
    public void showTeachersList(MouseEvent e) throws SQLException
    {
        ArrayList <TeacherData> td = model.getTeacherList();
        for(int i = 0; i<td.size(); i++)
        {
           id.setText(td.get(i).getId()); 
           // System.out.println(td.get(i).getId());
           firstName.setText(td.get(i).getFirstname());
           lastName.setText(td.get(i).getLastname());
        }
       
        
    }
    

    public void onClick(MouseEvent e)
    {
     
              
    }
    
    
   
    @FXML
    public void showPop(MouseEvent ex){
    
        try
        {
          POP pop = new POP();
            pop.showPop();
          //POP.popStage.setX(ex.getX());
         // POP.popStage.setY(ex.getY());
            
        }catch(Exception e)
        {
            System.out.println("error in controler");
        }
       
        
        //Teacher.thisStage.setScene(Teacher.pc);
    }
    int a = 0;
    @FXML
    Rectangle tab;
    @FXML
    public void expand()
    {
        a++;
         ScaleTransition st = new ScaleTransition(Duration.seconds(1), tab);
        if(a%2!=0)
        {
        
         st.setByY(5);
         st.play();
        }
        //tab.setHeight(300);
        else
              st.setByY(-5);
         st.play();
            
    }
}
