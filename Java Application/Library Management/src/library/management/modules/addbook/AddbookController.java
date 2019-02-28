/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.modules.addbook;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.swing.JOptionPane;
import library.management.database.DBConnection;
/**
 *
 * @author rizwan
 */
public class AddbookController implements Initializable {

    @FXML
    private JFXTextField bkid;
    @FXML
    private JFXTextField bkname;
    @FXML
    private JFXTextField author;
    @FXML
    private JFXTextField publisher;
    
 
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    } 
    @FXML
    private void insertData() throws SQLException, ClassNotFoundException{
        String bkid = this.bkid.getText();
        String bkname = this.bkname.getText();
        String author = this.author.getText();
        String publisher = this.publisher.getText();
        if(bkid.isEmpty() || bkname.isEmpty() || author.isEmpty() || publisher.isEmpty())
            JOptionPane.showMessageDialog(null, "Fields are empty!!");
        else{
            String query = "INSERT INTO book(bookid,bookname,author,publisher) VALUES(" +
                    "'"+ bkid + "'," + 
                    "'"+ bkname + "'," +
                    "'"+ author + "'," +
                    "'"+ publisher + "')";
            System.out.println(query);
           
           boolean done = new DBConnection().insertQuery(query);

            if(done){
                JOptionPane.showMessageDialog(null, "Book Added Successfully");
            }
            
        }
    }
    
}
