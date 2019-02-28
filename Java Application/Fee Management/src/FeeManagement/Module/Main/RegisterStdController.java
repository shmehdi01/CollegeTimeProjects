/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeeManagement.Module.Main;

import FeeManagement.Database.DBConnect;
import FeeManagement.Methods.LoadExternalFx;
import FeeManagement.Methods.Loader;
import FeeManagement.Methods.Validation;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class RegisterStdController implements Initializable {

    @FXML
    private AnchorPane rootpane;
    @FXML
    private BorderPane area;
    @FXML
    private Text name;
    @FXML
    private Text cls;
    @FXML
    private Text sess;
    @FXML
    private Text rid;
    @FXML
    private JFXTextField ridtf;

    /**
     * Initializes the controller class.
     */
    DBConnect db;
    @FXML
    private Text father;
    @FXML
    private Text cat;

    @FXML
    private JFXListView<String> feenamelist;
    @FXML
    private JFXListView<String> feeamntlist;
    @FXML
    private Label totalonetime;
    @FXML
    private VBox detailpane;
    @FXML
    private JFXComboBox<String> selcls;
    @FXML
    private JFXComboBox<String> admchrgcls;
    @FXML
    private JFXComboBox<String> paytime;
    @FXML
    private JFXListView<String> feeDT;
    @FXML
    private JFXListView<String> feeDTN;
    @FXML
    private JFXCheckBox bus;
    @FXML
    private JFXCheckBox hostel;
    @FXML
    private Label totfee;
    @FXML
    private JFXRadioButton bycash;
    @FXML
    private JFXRadioButton byonline;
    @FXML
    private JFXRadioButton bychq;
    @FXML
    private JFXTextField chqno;
    @FXML
    private JFXTextField onlinetxn;
    @FXML
    private Label grandtot;
    @FXML
    private Label dues;
    @FXML
    private JFXTextField payingamt;
    @FXML
    private Label returnamt;
    @FXML
    private Label invalid;
    @FXML
    private Text alreg;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        NumberValidator(ridtf, "Enter Valid Registration Number");
        bycash.selectedProperty().set(true);
        chqno.setVisible(false);
        onlinetxn.setVisible(false);
        ToggleGroup tg = new ToggleGroup();
        bycash.setToggleGroup(tg);
        bychq.setToggleGroup(tg);
        byonline.setToggleGroup(tg);
        detailpane.setVisible(false);
//        bus.selectedProperty().setValue(Boolean.TRUE);
//        hostel.selectedProperty().setValue(Boolean.TRUE);
        db = DBConnect.connectDB();
        new LoadExternalFx().loadFxml(area, rootpane);
       }
    
    void NumberValidator(JFXTextField tf, String msg){
        NumberValidator vb = new NumberValidator();
        tf.getValidators().add(vb);
        vb.setMessage(msg);
        vb.setIcon(new ImageView(new Image("/FeeManagement/Icon/error.png")));
        tf.setOnKeyReleased(e->{
            tf.validate();
        });
    }

    @FXML
    private void fetchStd(ActionEvent event) throws SQLException {
        if (getStd()) {
            detailpane.setVisible(true);
            setClsID();
            setServices();
            setPayTime();
            getOneTimeFee();
            fetchPayDetail();
            
            if(isStdRegister(ridtf.getText())){
                alreg.setFill(Color.GREEN);
                alreg.setText("Registered");
            }
            else{
                alreg.setFill(Color.RED);
                alreg.setText("Not Registered");
            }

        } else {
            System.out.println((ridtf.getText() + " not in Record"));
            // JOptionPane.showMessageDialog(null, ridtf.getText() + " not in Record");
//            detailpane.setVisible(false);
        }
    }
    
    void setServices() throws SQLException{
        if(getBusServices(ridtf.getText())==true)
            bus.selectedProperty().set(true);
        else bus.selectedProperty().set(false);
        if(getHostelServices(ridtf.getText())==true)
            hostel.selectedProperty().set(true);
        else hostel.selectedProperty().set(false);
    }

    String CLASS;

    boolean getStd() throws SQLException {
        String rid = ridtf.getText();
        String query = "SELECT * FROM student WHERE regid = '" + rid + "'";
        ResultSet rs = db.execQuery(query);

        while (rs.next()) {
            String gen = "S/o";
            CLASS = (rs.getString("class"));
            name.setText(rs.getString("fname") + " " + rs.getString("lname"));
            if(rs.getString("gender").equalsIgnoreCase("Female"))
                gen = "D/o";
            father.setText(gen + " " + rs.getString("father"));
            cls.setText(rs.getString("class"));
            cat.setText(rs.getString("category"));
            sess.setText(rs.getString("session"));
            this.rid.setText(rs.getString("regid"));
            return true;
        }

        return false;
    }
    
    boolean getBusServices(String regid) throws SQLException{
        String query = "select bus from student where regid = '"+regid+"'";
        ResultSet rs = db.execQuery(query);
        while(rs.next()){
            if(rs.getString("bus").equalsIgnoreCase("YES"))
                return true;
        }
        return false;
    }
     boolean getHostelServices(String regid) throws SQLException{
        String query = "select hostel from student where regid = '"+regid+"'";
        ResultSet rs = db.execQuery(query);
        while(rs.next()){
            if(rs.getString("hostel").equalsIgnoreCase("YES"))
                return true;
        }
        return false;
    }

    int devFeeClassID() {
        int clsid = 5; // pre-primaery
        if (Character.isDigit(CLASS.charAt(0))) {
            clsid = 6; // I to XII
        }
        return clsid;
    }

    int feeClassID() {
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

    void getOneTimeFee() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ObservableList<String> list2 = FXCollections.observableArrayList();
        String query = "SELECT * FROM fee_structure WHERE time = 'ONE TIME' AND class = '" + admchrgcls.getValue() + "'";
        ResultSet rs = db.execQuery(query);
        while (rs.next()) {
            list.add(rs.getString("fee_heading"));
            list2.add(rs.getString("amount"));
//            onetimehead.getChildren().add(new Label(rs.getString("fee_heading")));
//            onetimeamt.getChildren().add(new Label(rs.getString("amount")));
        }
        feenamelist.setItems(list);
        feeamntlist.setItems(list2);
        getTotalOneTime();
    }

    void setClsID() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        //String query = "SELECT * FROM fee_structure WHERE time = 'MONTHLY' and class = 'I to V'";
        String query2 = "SELECT class FROM class"; // WHERE class_id=" + feeClassID();
        ResultSet rs2 = db.execQuery(query2);
        while (rs2.next()) {
            list.add(rs2.getString("class"));
            //System.out.println(rs.getString("fee_type"));

        }
        selcls.setItems(list);
        admchrgcls.setItems(list);
        selcls.getSelectionModel().select(feeClassID() - 1);
        admchrgcls.getSelectionModel().select(devFeeClassID() - 1);
    }

    void setPayTime() throws SQLException {
        ObservableList<String> list1 = FXCollections.observableArrayList();
        String query = "SELECT fee_type FROM fee_type";
        ResultSet rs = db.execQuery(query);
        while (rs.next()) {
            list1.add(rs.getString("fee_type"));
        }
        paytime.setItems(list1);
        paytime.getSelectionModel().select(1);
    }

    int getTotalOneTime() {
        int total = 0;
        ObservableList<String> list = feeamntlist.getItems();
        for (int i = 0; i < list.size(); i++) {
            total = Integer.parseInt(list.get(i)) + total;
        }
        totalonetime.setText(total + "");
        System.out.println(total);
        return total;
    }

    @FXML
    private void getPayDetailByTime(ActionEvent event) throws SQLException {
        fetchPayDetail();
    }

    void fetchPayDetail() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ObservableList<String> list2 = FXCollections.observableArrayList();
        String query = "SELECT * FROM fee_structure WHERE (time = '" + paytime.getValue() + "' OR time = 'ONE TIME') and class = '" + selcls.getValue() + "'";
        //System.out.println(query);
        ResultSet rs = db.execQuery(query);
        while (rs.next()) {
            list.add(rs.getString("amount"));
            list2.add(rs.getString("fee_heading"));
        }
        feeDT.setItems(list);
        feeDTN.setItems(list2);
        calDuesFee();

    }

    int getBusFee() throws SQLException {
        int BusFee = 0;
        String query = "SELECT * FROM fee_structure WHERE (time = '" + paytime.getValue() + "' OR time = 'ONE TIME') and class = '" + selcls.getValue() + "'"
                + "and fee_heading='BUS'";
        ResultSet rs = db.execQuery(query);
        while (rs.next()) {
            BusFee = rs.getInt("amount");
        }
        return BusFee;
    }

    int getHostelFee() throws SQLException {
        int HostelFee = 0;
        String query = "SELECT * FROM fee_structure WHERE (time = '" + paytime.getValue() + "' OR time = 'ONE TIME') and class = '" + selcls.getValue() + "'"
                + "and fee_heading='HOSTEL'";
        ResultSet rs = db.execQuery(query);
        while (rs.next()) {
            HostelFee = rs.getInt("amount");
        }
        return HostelFee;
    }

    int getFeeTot() throws SQLException {
        int total = 0;
        ObservableList<String> list = feeDT.getItems();
        for (int i = 0; i < list.size(); i++) {
            total = Integer.parseInt(list.get(i)) + total;
        }
        if (bus.isSelected() != true) {
            total = total - getBusFee();
        }
        if (hostel.isSelected() != true) {
            total = total - getHostelFee();
        }
        totfee.setText(total + "");
        System.out.println(total);
        return total;
    }

    @FXML
    private void minBusFee(ActionEvent event) throws SQLException {
        calDuesFee();
    }

    @FXML
    private void minHostFee(ActionEvent event) throws SQLException {
        calDuesFee();
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

    int calGrandTotal() throws SQLException {
        int total = getTotalOneTime() + getFeeTot();
        grandtot.setText(total + " Rs.");
        return total;
    }
    int calDuesFee() throws SQLException{
        int paying = 0;
        if(!payingamt.getText().isEmpty())
            paying = Integer.parseInt(payingamt.getText());
        int dues = calGrandTotal() - paying;
        if(dues==0){
            this.dues.setText("No Dues");
            returnamt.setText("");
        }
        else if(dues<0){
            this.dues.setText("No Dues");
            returnamt.setText("Return amount " + -1*dues + " Rs. to " + name.getText());
        }
        else {
            returnamt.setText("");
            this.dues.setText(dues + " Rs.");
        }
            
       
        return dues;
    }
  
    @FXML
    private void showDues(KeyEvent event) throws SQLException, IOException {
        
        if(Validation.isNummber(payingamt.getText())){
            calDuesFee();
            invalid.setText("");
        }
        
        else {
            invalid.setText("Please Enter Valid Amount");
        }
    }
    
    String getPaidMode(){
        String mode = "CASH";
        if(byonline.isSelected() == true)
            mode = "ONLINE PAYMENT";
        else if(bychq.isSelected() == true)
            mode = "CHEQUE";
        else mode = "CASH";
        
        return mode;
    }
    final String REG = "Registration";
    void saveAmount() throws SQLException, IOException{
        String rid = this.rid.getText();
        String amt = payingamt.getText();
        int dues = calDuesFee();
        String act = "CR";
        String paidby = getPaidMode();
        String chqno = this.chqno.getText();
        String onlineid = onlinetxn.getText();
        String feetype = paytime.getValue();
        String month = "MARCH";
        String com = REG;
        
        String query = "INSERT INTO Txn(rid,amount,dues,action,paidby,chqno,onlineid,feetype,month,com,month)"
                + "VALUES(" +
                "'" + rid +"'," +
                "'" + amt +"'," +
                "'" + -1*dues +"'," +
                "'" + act +"'," +
                "'" + paidby +"'," +
                "'" + chqno +"'," +
                "'" + onlineid +"'," +
                "'" + feetype +"'," +
                "'" + month +"'," +
                "'" + com +"'," + 
                "'" + "2" +"'"
                + ")";
        System.out.println(query);
        if(db.updateQuery(query)){
            Loader.getInstance().loadPop("Success", "Fee Submitied Successfully", 7);
        }
        
    }

    @FXML
    private void makePayment(ActionEvent event) throws SQLException, IOException {
        
        if(Validation.isNummber(payingamt.getText()) && !payingamt.getText().isEmpty()){
            if(!isStdRegister(this.rid.getText())){
                saveAmount();
            }
            else{
                Loader.getInstance().loadPop("Invalid", "Student is already registered", 5);
            }
        }
        else System.out.println("something went wrong");
    }
    
    boolean isStdRegister(String regid) throws SQLException{
        String query = "SELECT * FROM Txn Where rid = " + regid + " and com = '" + REG + "'";
        if(db.execQuery(query).next())
            return true;
        else return false;
    }

}
