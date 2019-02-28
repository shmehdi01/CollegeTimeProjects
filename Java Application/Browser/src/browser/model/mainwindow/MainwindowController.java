/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package browser.model.mainwindow;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class MainwindowController implements Initializable {

    @FXML
    private TextField urlfiled;
    @FXML
    private WebView webview;
    private WebEngine engine;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            engine = webview.getEngine();
    } 
    int i =0;
    @FXML 
    private void openUrl(){
        engine.load("http://"+urlfiled.getText());
        
       // engine.loadContent("<html>"+ urlfiled.getText() +" </html>");
        //engine.getLocation();
        System.out.println(i++);
    }
    
}
