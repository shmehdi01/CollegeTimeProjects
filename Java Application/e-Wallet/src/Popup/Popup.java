/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Popup;

import Function.Move;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author rizwan
 */
public class Popup {
    
    public static Stage popStage;
    private static String title;
    private static String name;
    private static String amount;
     private static String info;
    
    public void confirm(String title, String name, String amount) throws IOException{
       this.title = title;
       this.name = name;
       this.amount = amount;
       Parent root =  FXMLLoader.load(getClass().getResource("popConfirm.fxml"));
       Scene scene = new Scene(root);
       Stage stage= new Stage();
       popStage = stage;
       stage.initStyle(StageStyle.UNDECORATED);
       new Move(root, stage);
       stage.setScene(scene);
       stage.showAndWait();
    }
    public void infoPop(String info) throws IOException{
        this.info = info;
       Parent root =  FXMLLoader.load(getClass().getResource("info.fxml"));
       Scene scene = new Scene(root);
       Stage stage= new Stage();
       popStage = stage;
       stage.initStyle(StageStyle.UNDECORATED);
       new Move(root, stage);
       stage.setScene(scene);
       stage.showAndWait();
    }
    
    public String getConfTitle(){
        return title;
    }
    public String getConfName(){
        return name;
    }
    public String getConfAmount(){
        return amount;
    }
    public String getInfo(){
        return info;
    }
}
