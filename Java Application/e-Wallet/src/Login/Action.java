/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Popup.Popup;
import java.sql.ResultSet;
import java.sql.SQLException;
import Query.Run;
import Validation.Validation;
import java.io.IOException;

/**
 *
 * @author rizwan
 */
public class Action {

    Run run;
    private static int userid;
    private static String name;
    private static String mobile;
    public Action() {
        
        run = new Run();
        
    }

    public boolean isValidUser(String mob, String pass) throws SQLException {
        boolean checked = false;
        ResultSet rs = run.readQuery("SELECT * FROM login");
        while (rs.next()) {
            if (mob.equals(rs.getString("mobile")) && pass.equals(rs.getString("pass"))) {
                checked = true;
                userid = rs.getInt("userid");
                mobile = rs.getString("mobile");
                name = rs.getString("name");
                System.out.println(rs.getString("mobile"));
            }
        }
        return checked;
    }
    private boolean isAlreadyUser(String mob) throws SQLException{
        boolean user = false;
        String query = "SELECT mobile FROM login";
        ResultSet rs = run.readQuery(query);
        while(rs.next()){
          if(rs.getString("mobile").equals(mob))
              user = true;
        }
        return user;
    }

    public void doSignup(String mob, String pass, String name) throws SQLException, IOException {
        if(mob.isEmpty() || pass.isEmpty() || name.isEmpty()){
            new Popup().infoPop("Field is empty");
        }
        else if (!new Validation().checkPhoneNum(mob)) {
            new Popup().infoPop("Mobile number not correct");
        }
        else if(isAlreadyUser(mob)){
            new Popup().infoPop("Mobile number already registered");
        }
        else{
        String query = "INSERT INTO login(mobile,pass,name) VALUES(" + "'" + mob + "'," + "'" + pass + "'," + "'" + name + "'" + ")";
        boolean done = run.insertQuery(query);
        if(done)
            new Popup().infoPop("Registered Sucessfully");
        }

    }
    
    public int getUserID(){
        return userid;
    }
    public String getUserName(){
        return name;
    }
    public String getMob(){
        return mobile;
    }

}
