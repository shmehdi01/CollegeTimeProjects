/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeeManagement.Module.FeePayment;

import FeeManagement.Database.DBConnect;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import FeeManagement.Methods.LoadExternalFx;
import FeeManagement.Methods.Loader;
import FeeManagement.Methods.Validation;
import FeeManagement.Structure.Student;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class FeepaymentController implements Initializable {

    @FXML
    private BorderPane feepayarea;
    @FXML
    private AnchorPane rootpane;
    @FXML
    private ComboBox<String> classlist;
    @FXML
    private ComboBox<String> seclist;
    private ComboBox<String> namelist;
    DBConnect DBHandler;
    @FXML
    private ComboBox<String> rolllist;
    @FXML
    private Label stdname;
    @FXML
    private JFXTextField search;
    @FXML
    private JFXListView<String> hintbox;
    @FXML
    private Text name;
    @FXML
    private Text father;
    @FXML
    private Text regno;
    @FXML
    private Text mob;
    @FXML
    private Text cat;
    @FXML
    private HBox fhmn;
    @FXML
    private HBox fhm;
    @FXML
    private Rectangle jan;
    @FXML
    private Rectangle feb;
    @FXML
    private Rectangle march;
    @FXML
    private Rectangle april;
    @FXML
    private Rectangle may;
    @FXML
    private Rectangle june;
    @FXML
    private HBox shmn;
    @FXML
    private HBox shm;
    @FXML
    private Rectangle july;
    @FXML
    private Rectangle aug;
    @FXML
    private Rectangle sept;
    @FXML
    private Rectangle oct;
    @FXML
    private Rectangle nov;
    @FXML
    private Rectangle dec;
    @FXML
    private Label monthhead;
    @FXML
    private Text label_jan;
    @FXML
    private Text label_feb;
    @FXML
    private Text label_march;
    @FXML
    private Text label_april;
    @FXML
    private Text label_may;
    @FXML
    private Text label_june;
    @FXML
    private Text label_july;
    @FXML
    private Text label_aug;
    @FXML
    private Text label_sept;
    @FXML
    private Text label_oct;
    @FXML
    private Text label_nov;
    @FXML
    private Text label_dec;
    @FXML
    private JFXComboBox<String> monthlist;

    final String COLOR_PAID = "#1eff3a";
    final String COLOR_DUES = "#ff2d1f";
    final String COLOR_DEFAULT = "#9ba19c";
    @FXML
    private JFXListView<String> feedetaillist;
    @FXML
    private JFXComboBox<String> paytime;
    @FXML
    private JFXListView<String> feedetaillistN;
    @FXML
    private Label totalfee;
    @FXML
    private VBox feepane;
    @FXML
    private JFXRadioButton bycash;
    @FXML
    private JFXRadioButton bychq;
    @FXML
    private JFXRadioButton byonline;
    @FXML
    private JFXTextField chqno;
    @FXML
    private JFXTextField onlinetxn;
    @FXML
    private JFXTextField payingamt;
    @FXML
    private Label invalid;
    @FXML
    private Label dues;
    @FXML
    private Label returnamt;
    @FXML
    private Label fine;
    @FXML
    private Label gtotal;
    @FXML
    private JFXCheckBox addfine;
    @FXML
    private TextField finetf;
    @FXML
    private HBox fineBox;
    @FXML
    private Label payamt;
    @FXML
    private Label invalidfine;
    @FXML
    private Pane monthpane;
    @FXML
    private Label PAID_AMOUNT;
    @FXML
    private Label DUES_AMOUNT;
    @FXML
    private Label PAID_BY;
    @FXML
    private Label PAID_DATE;
    @FXML
    private JFXButton addduesbtn;
    @FXML
    private StackPane loadroot;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fineBox.setVisible(false);
        ToggleGroup tg = new ToggleGroup();
        bycash.setToggleGroup(tg);
        bychq.setToggleGroup(tg);
        bycash.selectedProperty().set(true);
        chqno.setVisible(false);
        onlinetxn.setVisible(false);
        byonline.setToggleGroup(tg);
        feepane.setVisible(false);
        monthlist.setStyle("-fx-color:#006b33");
        ObservableList list = FXCollections.observableArrayList(
                "JANUARY",
                "FEBURARY",
                "MARCH",
                "APRIL",
                "MAY",
                "JUNE",
                "JULY",
                "AUGUST",
                "SEPTEMBER",
                "OCTOBER",
                "NOVEMBER",
                "DECEMBER");
        monthlist.setItems(list);
        hintbox.setVisible(false);
        DBHandler = DBConnect.connectDB();
        new LoadExternalFx().loadFxml(feepayarea, rootpane);
        try {
            getClassList();
        } catch (SQLException ex) {
            Logger.getLogger(FeepaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        monthhead.setLayoutX(1180);
        monthhead.setVisible(false);
        monthlist.getSelectionModel().select(getCurrentMonth() - 1);
    }

    void getClassList() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        String query = "SELECT DISTINCT class FROM student ";
        ResultSet rs = DBHandler.execQuery(query);
        while (rs.next()) {
            list.add(rs.getString("class"));
        }
        classlist.setItems(list);
    }

    void getSecList() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        String cls = classlist.getValue();
        if (cls == null) {
            System.out.println("sec list null query");
        } else {
            String query = "SELECT DISTINCT sec FROM student WHERE class = '" + cls + "'";
            ResultSet rs = DBHandler.execQuery(query);
            while (rs.next()) {
                list.add(rs.getString("sec"));
            }
        }
        seclist.setItems(list);
    }

    void getRollList() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        String cls = classlist.getValue();
        String sec = seclist.getValue();
        if (cls == null || sec == null) {
            System.out.println("roll no. list null query");
        } else {
            String query = "SELECT roll FROM student WHERE sec = '" + sec + "' AND class='" + cls + "'";
            System.out.println(query);
            ResultSet rs = DBHandler.execQuery(query);
            while (rs.next()) {
                list.add(rs.getString("roll"));
            }
        }

        rolllist.setItems(list);
    }

    void getNameList() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        String cls = classlist.getValue();
        String sec = seclist.getValue();
        String query = "SELECT fname,lname,roll FROM student WHERE sec = '" + sec + "' AND class='" + cls + "'";
        System.out.println(query);
        ResultSet rs = DBHandler.execQuery(query);
        while (rs.next()) {
            list.add(rs.getString("fname") + " " + rs.getString("lname"));
        }
        namelist.setItems(list);
    }

    Student getStdDetail() throws SQLException {
        Student std = null;
        String cls = classlist.getValue();
        String sec = seclist.getValue();
        String roll = rolllist.getValue();
        String name = null;
        if (cls == null || sec == null || roll == null) {
            System.out.println("student detail null query");
        } else {
            String query = "SELECT * FROM student WHERE sec = '" + sec + "' AND class='" + cls + "' AND roll='" + roll + "'";
            System.out.println(query);
            ResultSet rs = DBHandler.execQuery(query);
            while (rs.next()) {
                //name = rs.getString("fname") + " " + rs.getString("lname");
                std = new Student(
                        rs.getInt("regid"),
                        rs.getInt("roll"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("father"),
                        rs.getString("mobile"),
                        rs.getString("email"),
                        rs.getString("class"),
                        rs.getString("sec"),
                        rs.getString("session"),
                        rs.getString("add"),
                        rs.getString("category")
                );
            }
        }

        return std;
    }

    void searchStudent() throws SQLException {

        ObservableList<String> list = FXCollections.observableArrayList();
//        if(search.getText().isEmpty()){
//            
//        }else{
        String query = "SELECT * FROM student WHERE fname LIKE  '" + search.getText() + "%'";
        ResultSet rs = DBHandler.execQuery(query);
        while (rs.next()) {
            list.add(
                    rs.getString("roll") + " | "
                    + rs.getString("fname") + " " + rs.getString("lname")
                    + "  " + rs.getString("class") + "th"
                    + " (" + rs.getString("sec") + ")"
            );

            System.out.println(rs.getString("fname") + " " + rs.getString("lname"));
        }
//        }
        if (list.isEmpty()) {
            list.add("No search Found!!");
        }
        hintbox.setVisible(true);
        hintbox.setItems(list);

    }

    @FXML
    private void setSec(ActionEvent event) throws SQLException {
        getSecList();
    }

    @FXML
    private void setRoll(ActionEvent event) throws SQLException {
        getRollList();
    }

    @FXML
    private void setName(ActionEvent event) throws SQLException {
        Student std = getStdDetail();
        if (std == null) {
            stdname.setText("");
            name.setText("");
            father.setText("");
            regno.setText("");
            mob.setText("");
            cat.setText("");

        } else {
            stdname.setText(std.getFname() + " " + std.getLname());
            name.setText(std.getFname() + " " + std.getLname());
            father.setText(std.getFather());
            regno.setText(std.getRegid() + "");
            mob.setText(std.getMobile());
            cat.setText(std.getCat());
            ObservableList paidcode = getPaidMonthsCode(std.getRegid());
            ObservableList duescode = getPaidDuesCode(std.getRegid());
            resetColor();
            if (isPaidMonthAvaiable == true) {
                setColorMonth(paidcode, COLOR_PAID);
            }
            if (isDuesMonthAvailable == true) {
                setColorMonth(duescode, COLOR_DUES);
            }

            setPayTime();
            getFeeDetail();
            getFine(std.getRegid() + "");
            calDuesFee();
        }

    }

    @FXML
    private void doSearch(KeyEvent event) throws SQLException {

        searchStudent();
        //animReset();
    }

    @FXML
    private void hide(MouseEvent event) {

        animReset();
    }

    TranslateTransition recttrans;
    FadeTransition rectfade;
    FadeTransition firshlafmon;
    FadeTransition firshlafmonname;
    FadeTransition sechlafmon;
    FadeTransition sechlafmonname;
    TranslateTransition headtrans;

    void prevFeeAnim(Node monRect, String monName) {
        monthhead.setVisible(true);
        recttrans = new TranslateTransition(Duration.seconds(1), monRect);
        rectfade = new FadeTransition(Duration.seconds(1), monRect);
        firshlafmon = new FadeTransition(Duration.seconds(1), fhm);
        firshlafmonname = new FadeTransition(Duration.seconds(1), fhmn);
        sechlafmon = new FadeTransition(Duration.seconds(1), shm);
        sechlafmonname = new FadeTransition(Duration.seconds(1), shmn);
        headtrans = new TranslateTransition(Duration.seconds(1), monthpane);

        rectfade.setFromValue(1);
        rectfade.setToValue(0);

        firshlafmon.setFromValue(1);
        firshlafmon.setToValue(0);

        firshlafmonname.setFromValue(1);
        firshlafmonname.setToValue(0);

        sechlafmon.setFromValue(1);
        sechlafmon.setToValue(0);

        sechlafmonname.setFromValue(1);
        sechlafmonname.setToValue(0);

        recttrans.setToY(-100);
        headtrans.setToX(-303);

        recttrans.play();
        rectfade.play();
        firshlafmon.play();
        firshlafmonname.play();
        sechlafmon.play();
        sechlafmonname.play();
        headtrans.play();
        monthhead.setText(monName);

    }

   public void animReset() {
        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        rectfade.setFromValue(0);
        rectfade.setToValue(1);

        firshlafmon.setFromValue(0);
        firshlafmon.setToValue(1);

        firshlafmonname.setFromValue(0);
        firshlafmonname.setToValue(1);

        sechlafmon.setFromValue(0);
        sechlafmon.setToValue(1);

        sechlafmonname.setFromValue(0);
        sechlafmonname.setToValue(1);

        recttrans.setToY(0);
        headtrans.setToX(0);

        recttrans.play();
        rectfade.play();
        firshlafmon.play();
        firshlafmonname.play();
        sechlafmon.play();
        sechlafmonname.play();
        headtrans.play();
        delay.setOnFinished(ev -> {
            monthhead.setVisible(false);
        });
        delay.play();

    }

    int getCurrentMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("M");
        int month = Integer.parseInt(sdf.format(new Date()));
        return month;
    }

    void setColorMonth(ObservableList code, String color) {
        Rectangle[] tabs = {jan, feb, march, april, may, june, july,
            aug, sept, oct, nov, dec};
        ObservableList<Integer> list = code;
        for (int i = 0; i < tabs.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == i) {
                    System.out.println("color -> " + i);
                    tabs[i].setFill(Color.web(color));
                } else {
                    //       System.out.println("else color -> " + i);
                    //                  tabs[i].setFill(Color.web(COLOR_DEFAULT));
                }
            }
        }
    }

    void resetColor() {
        Rectangle[] tabs = {jan, feb, march, april, may, june, july,
            aug, sept, oct, nov, dec};
        for (int i = 0; i < tabs.length; i++) {
            System.out.println("default color " + i);
            tabs[i].setFill(Color.web(COLOR_DEFAULT));
        }
    }
    boolean isPaidMonthAvaiable = false;

    ObservableList getPaidMonthsCode(int regno) throws SQLException {
        ObservableList<Integer> monthcode = FXCollections.observableArrayList();
        String query = "select monthcode from Txn where dues = 0 and rid =" + regno;
        ResultSet rs = DBHandler.execQuery(query);
        while (rs.next()) {
            monthcode.add(rs.getInt("monthcode"));
            isPaidMonthAvaiable = true;
        }
        return monthcode;
    }
    boolean isDuesMonthAvailable = false;

    ObservableList getPaidDuesCode(int regno) throws SQLException {
        ObservableList<Integer> monthcode = FXCollections.observableArrayList();
        String query = "select monthcode from Txn where dues != 0 and rid =" + regno;
        ResultSet rs = DBHandler.execQuery(query);
        while (rs.next()) {
            monthcode.add(rs.getInt("monthcode"));
            isDuesMonthAvailable = true;
        }
        return monthcode;
    }

    boolean getBusServices(String regid) throws SQLException {
        String query = "select bus from student where regid = '" + regid + "'";
        ResultSet rs = DBHandler.execQuery(query);
        while (rs.next()) {
            if (rs.getString("bus").equalsIgnoreCase("YES")) {
                return true;
            }
        }
        return false;
    }

    boolean getHostelServices(String regid) throws SQLException {
        String query = "select hostel from student where regid = '" + regid + "'";
        ResultSet rs = DBHandler.execQuery(query);
        while (rs.next()) {
            if (rs.getString("hostel").equalsIgnoreCase("YES")) {
                return true;
            }
        }
        return false;
    }

    int feeClassID() {
        String CLASS = classlist.getValue();
        int id = 1; // nur to kg
        if (Character.isDigit(CLASS.charAt(0))) {
            int cls = Integer.parseInt(CLASS);

            if (cls > 10) {
                id = 4; // 11 to 12
            } else if (cls > 5) {
                id = 3; // 6 to 10
            } else {
                id = 2; // 1 to 5
            }

        }
        return id;
    }

    String classBasedFee() throws SQLException {
        String cls = null;
        String query = "SELECT class FROM class WHERE class_id=" + feeClassID();
        ResultSet rs = DBHandler.execQuery(query);
        while (rs.next()) {
            cls = rs.getString("class");
        }
        return cls;
    }

    void setPayTime() throws SQLException {
        ObservableList<String> list1 = FXCollections.observableArrayList();
        String query = "SELECT fee_type FROM fee_type";
        ResultSet rs = DBHandler.execQuery(query);
        while (rs.next()) {
            list1.add(rs.getString("fee_type"));
        }
        paytime.setItems(list1);
        paytime.getSelectionModel().select(1);
    }

    void getFeeDetail() throws SQLException {
        feepane.setVisible(true);
        ObservableList<String> list = FXCollections.observableArrayList();
        ObservableList<String> list2 = FXCollections.observableArrayList();
        String query = "SELECT * FROM fee_structure WHERE time = '" + paytime.getValue()
                + "'  AND class = '" + classBasedFee() + "'"
                + "AND (fee_heading != 'BUS' AND  fee_heading != 'HOSTEL')";

        if (getBusServices(regno.getText()) == true) {

            query = "SELECT * FROM fee_structure WHERE time = '" + paytime.getValue()
                    + "'  AND class = '" + classBasedFee() + "'"
                    + "AND fee_heading != 'HOSTEL'";;

        }
        if (getHostelServices(regno.getText()) == true) {

            query = "SELECT * FROM fee_structure WHERE time = '" + paytime.getValue()
                    + "'  AND class = '" + classBasedFee() + "'"
                    + "AND fee_heading != 'BUS'";;

        }

        System.out.println(query);
        ResultSet rs = DBHandler.execQuery(query);
        while (rs.next()) {
            list.add(rs.getString("amount"));
            list2.add(rs.getString("fee_heading"));
        }
        feedetaillist.setItems(list);
        feedetaillistN.setItems(list2);
        calTotalFee();
    }

    int calTotalFee() {
        int total = 0;
        ObservableList<String> list = feedetaillist.getItems();
        for (int i = 0; i < list.size(); i++) {
            total = Integer.parseInt(list.get(i)) + total;
        }
        totalfee.setText(total + " Rs.");
        return total;
    }

    @FXML
    private void fetchFeeByTime(ActionEvent event) throws SQLException {
        getFeeDetail();
        payingamt.promptTextProperty().set(paytime.getValue() + " FEE");
    }

    int getFine(String regid) throws SQLException {
        int amt = 0;
        String query = "SELECT unpaid FROM Fine WHERE rid=" + regid + " AND status ='NOT CLEAR'";
        ResultSet rs = DBHandler.execQuery(query);
        while (rs.next()) {
            amt = rs.getInt("unpaid");
        }
        fine.setText(amt + "");
        return amt;

    }

    @FXML
    private void showTxnTf(ActionEvent event) {
        if (byonline.isSelected() == true) {
            chqno.setVisible(false);
            onlinetxn.setVisible(true);
        }

    }

    @FXML
    private void showChqTf(ActionEvent event) {
        if (bychq.isSelected() == true) {
            onlinetxn.setVisible(false);
            chqno.setVisible(true);
        }
    }

    @FXML
    private void hideTF(ActionEvent event) {
        if (bycash.isSelected() == true) {
            chqno.setVisible(false);
            onlinetxn.setVisible(false);
        }
    }

    int calDuesFee() throws SQLException {
        int paying = 0;
        payamt.setText(paying + "");
        if ((!payingamt.getText().isEmpty()) && (!finetf.getText().isEmpty())) {
            paying = Integer.parseInt(payingamt.getText()) + Integer.parseInt(finetf.getText());
            payamt.setText(paying + "");
        } else if ((payingamt.getText().isEmpty()) && (finetf.getText().isEmpty())) {
            paying = 0;
            payamt.setText(paying + "");
        } else if (payingamt.getText().isEmpty()) {
            paying = Integer.parseInt(finetf.getText());
            payamt.setText(paying + "");
        } else if (finetf.getText().isEmpty()) {
            paying = Integer.parseInt(payingamt.getText());
            payamt.setText(paying + "");
        }

        int dues = calGrandTotal() - Integer.parseInt(payamt.getText());
        if (dues == 0) {
            this.dues.setText("No Dues");
            returnamt.setText("");
        } else if (dues < 0) {
            this.dues.setText("No Dues");
            returnamt.setText("Return amount " + -1 * dues + " Rs. to " + name.getText());
        } else {
            returnamt.setText("");
            this.dues.setText(dues + " Rs.");
        }

        return dues;
    }

    @FXML
    private void showDues(KeyEvent event) throws SQLException, IOException {

        if ((Validation.isNummber(payingamt.getText())) && (Validation.isNummber(finetf.getText()))) {
            fineValidation();
            calDuesFee();
            invalid.setText("");
        } else {
            invalid.setText("Please Enter Valid Amount");
        }

    }

    String getPaidMode() {
        String mode = "CASH";
        if (byonline.isSelected() == true) {
            mode = "ONLINE PAYMENT";
        } else if (bychq.isSelected() == true) {
            mode = "CHEQUE";
        } else {
            mode = "CASH";
        }

        return mode;
    }

    final String FEE = "Fee Payment";

    void saveAmount() throws SQLException, IOException {
        String rid = this.regno.getText();
        String amt = payingamt.getText();
        int dues = getDuesFee();
        String act = "CR";
        String paidby = getPaidMode();
        String chqno = this.chqno.getText();
        String onlineid = onlinetxn.getText();
        String feetype = paytime.getValue();
        String month = monthlist.getValue();
        String com = FEE;

        String query = "INSERT INTO Txn(rid,amount,dues,action,paidby,chqno,onlineid,feetype,month,com,monthcode)"
                + "VALUES("
                + "'" + rid + "',"
                + "'" + amt + "',"
                + "'" + dues + "',"
                + "'" + act + "',"
                + "'" + paidby + "',"
                + "'" + chqno + "',"
                + "'" + onlineid + "',"
                + "'" + feetype + "',"
                + "'" + month + "',"
                + "'" + com + "',"
                + "'" + monthlist.getSelectionModel().getSelectedIndex() + "'"
                + ")";
        System.out.println(query);

        if (DBHandler.updateQuery(query)) {
            updateFine();
            Loader.getInstance().loadPop("Success", "Fee Submitied Successfully", 7);

        }

    }

    boolean updateFine() {
        String status = "CLEAR";
        if (getDuesFine() > 0) {
            status = "NOT CLEAR";
        }
        String query = "UPDATE Fine SET "
                + "paid = " + finetf.getText() + ","
                + "unpaid = " + getDuesFine() + ","
                + "isupdate = " + "'YES'" + ","
                + "status = '" + status + "'"
                + " WHERE rid = " + regno.getText();
        System.out.println(query);
        if (DBHandler.updateQuery(query)) {
            return true;
        }
        return false;
    }

    int calGrandTotal() {
        int total = 0;
        int fine = 0;
        if (addfine.isSelected() == true) {
            fine = Integer.parseInt(this.fine.getText());
        }
//        if(!finetf.getText().isEmpty()){
//            fine = Integer.parseInt(finetf.getText());
//        }
        total = calTotalFee() + fine;
        gtotal.setText(total + "");
        return total;
    }

    @FXML
    private void addFee(ActionEvent event) throws SQLException {
        if (addfine.isSelected() == true) {
            fineBox.setVisible(true);
            finetf.setText(fine.getText());
            calDuesFee();

        } else {
            fineBox.setVisible(false);
            finetf.setText("0");
            calDuesFee();

        }
    }
    int extra_fine = 0;

    boolean fineValidation() {
        boolean not_error = false;
        if (Validation.isNummber(finetf.getText()) && !finetf.getText().isEmpty()) {
            int finevalue = Integer.parseInt(finetf.getText());
            int fine = Integer.parseInt(this.fine.getText());
            if (finevalue > fine) {
                //invalidfine.setText("You are taking "+ (finevalue-fine) +"  Rs .extraa fine");
                extra_fine = finevalue - fine;
                finetf.setStyle("-fx-border-color:red; -fx-border-width:2px");
                not_error = false;
            } else {
                //invalidfine.setText("");
                finetf.setStyle("-fx-border-color:#006b33; -fx-border-width:2px");
                not_error = true;
            }
        }
        return not_error;
    }

    int getDuesFine() {
        int fine = 0;
        if (fineValidation() == true) {
            fine = Integer.parseInt(this.fine.getText()) - Integer.parseInt(finetf.getText());
        }
        return fine;
    }

    int getDuesFee() {
        int dues = 0;
        if (Validation.isNummber(payingamt.getText())) {
            dues = calTotalFee() - Integer.parseInt(payingamt.getText());
        }
        return dues;
    }

    @FXML
    private void makePayment(ActionEvent event) throws SQLException, IOException {

        if (Validation.isNummber(payingamt.getText()) && !payingamt.getText().isEmpty()) {
            if (fineValidation() == true) {
                saveAmount();
            } else {
                Loader.getInstance().loadPop("Invalid", "Cannot take extra fine", 5);
            }
        } else {
            System.out.println("something went wrong");
        }
    }
    int MONTH_CODE = 0;
    public static String Paid_Amt;
    public static String Dues_Amt;
    public static String Paid_by;
    public static String Paid_date;
    
    void getMonthDetail(int monthcode) throws SQLException {
        MONTH_CODE = monthcode;
        PAID_AMOUNT.setText("N/A");
        DUES_AMOUNT.setText("0");
        PAID_BY.setText("N/A");
        PAID_DATE.setText("N/A");
        String query = "SELECT amount,dues,paidby,date FROM Txn WHERE rid = '" + regno.getText() + "' AND monthcode = " + monthcode;
        System.out.println(query);
        ResultSet rs = DBHandler.execQuery(query);
        while (rs.next()) {
            PAID_AMOUNT.setText(rs.getString("amount"));
            DUES_AMOUNT.setText(rs.getString("dues"));
            PAID_BY.setText(rs.getString("paidby"));
            PAID_DATE.setText(rs.getString("date"));
            
            Paid_Amt = rs.getString("amount");
            Dues_Amt = rs.getString("dues");
            Paid_by = rs.getString("paidby");
            Paid_date = rs.getString("date");
        }
        
        if(Integer.parseInt(DUES_AMOUNT.getText())<=0){
            addduesbtn.setDisable(true);
        }
        else {
            addduesbtn.setDisable(false);
        }
    }

    @FXML
    private void getJanMonthDetail(MouseEvent event) throws SQLException, IOException {
        hintbox.setVisible(false);
        prevFeeAnim(jan, "January");
        getMonthDetail(0);
          loadMonthView();
    }

    @FXML
    private void getFebMonthDetail(MouseEvent event) throws SQLException {
        hintbox.setVisible(false);
        prevFeeAnim(feb, "Feburary");
        getMonthDetail(1);
    }

    @FXML
    private void getMarchMonthDetail(MouseEvent event) throws SQLException, IOException {
        hintbox.setVisible(false);
        prevFeeAnim(march, "March");
        getMonthDetail(2);
        loadMonthView();
    }

    @FXML
    private void getAprilMonthDetail(MouseEvent event) throws SQLException, IOException {
        hintbox.setVisible(false);
        prevFeeAnim(april, "April");
        getMonthDetail(3);
         loadMonthView();
    }

    @FXML
    private void getMayMonthDetail(MouseEvent event) throws SQLException {
        hintbox.setVisible(false);
        prevFeeAnim(july, "May");
        getMonthDetail(4);
    }

    @FXML
    private void getJuneMonthDetail(MouseEvent event) throws SQLException {
        hintbox.setVisible(false);
        prevFeeAnim(june, "June");
        getMonthDetail(5);
    }

    @FXML
    private void getJulyMonthDetail(MouseEvent event) throws SQLException {
        hintbox.setVisible(false);
        prevFeeAnim(july, "July");
        getMonthDetail(6);
    }

    @FXML
    private void getAugMonthDetail(MouseEvent event) throws SQLException {
        hintbox.setVisible(false);
        prevFeeAnim(aug, "August");
        getMonthDetail(7);
    }

    @FXML
    private void getSeptMonthDetail(MouseEvent event) throws SQLException {
        hintbox.setVisible(false);
        prevFeeAnim(sept, "September");
        getMonthDetail(8);
    }

    @FXML
    private void getOctMonthDetail(MouseEvent event) throws SQLException {
        hintbox.setVisible(false);
        prevFeeAnim(oct, "October");
        getMonthDetail(9);
    }

    @FXML
    private void getNovMonthDetail(MouseEvent event) throws SQLException {
        hintbox.setVisible(false);
        prevFeeAnim(nov, "Novemeber");
        getMonthDetail(10);
    }

    @FXML
    private void getDecMonthDetail(MouseEvent event) throws SQLException {
        hintbox.setVisible(false);
        prevFeeAnim(dec, "December");
        getMonthDetail(11);
    }

    void setSelectedColor() {
        addduesbtn.setStyle("-fx-background-color:GREEN");
        addduesbtn.setText("DUES ADDED");
        Rectangle[] tabs = {jan, feb, march, april, may, june, july,
            aug, sept, oct, nov, dec};
        tabs[MONTH_CODE].setFill(Color.YELLOW);

    }

    void setDeselectedColor() {
        addduesbtn.setStyle("-fx-background-color:RED");
        addduesbtn.setText("ADD DUES FEE");
        Rectangle[] tabs = {jan, feb, march, april, may, june, july,
            aug, sept, oct, nov, dec};
        tabs[MONTH_CODE].setFill(Color.web(COLOR_DUES));

    }

    void getDuesFeeFromMonth() {
        System.out.println(" DUES ADDED OF " + monthhead.getText().toUpperCase() + " RS ." + DUES_AMOUNT.getText()
                + " " + MONTH_CODE);
    }

    Color ORIGINAL_COLOR;
    int count_selected = 0;

    @FXML
    private void addDues(ActionEvent event) {
        if (count_selected % 2 == 0) {
            animReset();
            setSelectedColor();
            getDuesFeeFromMonth();
        } else {
            setDeselectedColor();
        }
        count_selected++;
    }
    
    public static AnchorPane loadpane;
    public static Parent pane;
    
    void loadMonthView() throws IOException{
        loadpane = rootpane;
        Parent pane = FXMLLoader.load(getClass().getResource("/FeeManagement/component/month.fxml"));
        this.pane = pane;
        pane.setLayoutX(1068);
        pane.setLayoutY(500);
        loadpane.getChildren().add(pane);
    }

    @FXML
    private void test(MouseEvent event) throws IOException {
        
    }

}
