/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.modules.main;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.effects.JFXDepthManager;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import library.management.database.DBConnection;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class MainController implements Initializable {

    @FXML
    private JFXTextField bookidtf;
    @FXML
    private Text bkn;
    @FXML
    private Text auth;
    @FXML
    private Text pub;
    @FXML
    private JFXTextField stdroll;
    @FXML
    private JFXButton issuebookbtn;
    @FXML
    private Button addmembtn;
    @FXML
    private Button addbookbtn;
    @FXML
    private Button viewmembtn;
    @FXML
    private Button viewbookbtn;
    @FXML
    private Button settingbtn;
    @FXML
    private Text infobk;
    @FXML
    private Text bkn1;
    @FXML
    private Text bkn11;
    @FXML
    private Text bkn111;
    @FXML
    private HBox book_info;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JFXDepthManager.setDepth(book_info, 0);
    }

    @FXML
    private void showBookDetail(ActionEvent event) throws ClassNotFoundException, SQLException {
        getBookDetail();
    }

    @FXML
    private void issueBook(ActionEvent event) {
    }

    @FXML
    private void loadAddMem(ActionEvent event) throws IOException {
        loadWin("/library/management/modules/adduser/student.fxml", "Add Member");
    }

    @FXML
    private void loadAddBook(ActionEvent event) throws IOException {
        loadWin("/library/management/modules/addbook/Addbook.fxml", "Add Book");
    }

    @FXML
    private void loadViewMem(ActionEvent event) {
    }

    @FXML
    private void loadViewBook(ActionEvent event) {
    }

    @FXML
    private void loadSetting(ActionEvent event) {
    }

    void loadWin(String loc, String title) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(loc));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    void getBookDetail() throws ClassNotFoundException, SQLException {
        String bkid = bookidtf.getText();
        String bookname = "";
        String author = "";
        String publisher = "";

        if (bkid.isEmpty()) {

        } else {
            String query = "SELECT * FROM book WHERE bookid = " + bkid;
            System.out.println(query);
            ResultSet rs = new DBConnection().readQuery(query);
            while (rs.next()) {
                bookname = rs.getString("bookname").toUpperCase();
                author = rs.getString("author").toUpperCase();
                publisher = rs.getString("publisher").toUpperCase();

            }
        }
        if(bookname.equals("") || author.equals("") || publisher.equals("")) {
            System.out.println("xxxxxxxxx");
            bkn.setText("xxx");
            auth.setText("xxx");
            pub.setText("xxx");
            infobk.setText("Book Not Available");

        } else {
            bkn.setText(bookname);
            auth.setText(author);
            pub.setText(publisher);
            infobk.setText("");
        }

    }

}
