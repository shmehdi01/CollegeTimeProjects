/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher;

import java.sql.*;
import java.util.ArrayList;
import javafx.fxml.FXML;



/**
 *
 * @author rizwan
 */
public class TeacherModel {
    Connection conn;
    //@FXML
    //public String id, firstName, lastName, dob, gender, city, mobile, email, subject, qualification, attendence ;
    public TeacherModel()
    {
        conn = DbConnection.getConnection();
        if(conn==null) 
            System.exit(1);
    }
    
    public boolean isConnected()
    {
        try {
            return !conn.isClosed();
        } catch (Exception ex) {
            System.out.println("error in model");
            return false;
        }
    }
    
    public ArrayList <TeacherData> getTeacherList() throws SQLException
    {
        ArrayList <TeacherData> teacherlist = new  ArrayList <TeacherData> ();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "Select * from TeachersList";
        try 
        {
           pst = conn.prepareStatement(query);
           rs =  pst.executeQuery();
           
           TeacherData td;
           while(rs.next())
           {
              td = new TeacherData(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
              rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
              teacherlist.add(td);
           }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            pst.close();
            rs.close();
        }
        return teacherlist;
    }
    
}
