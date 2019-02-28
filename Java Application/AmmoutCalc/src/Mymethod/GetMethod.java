/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mymethod;

import Query.Run;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

/**
 *
 * @author rizwan
 */
public class GetMethod {

    public Run run = new Run();

    public void userNameList(JComboBox<String> list) throws SQLException {

        String query = "SELECT name FROM user";
        ResultSet rs = run.readQuery(query);
        while (rs.next()) {
            list.addItem(rs.getString("name"));

        }
        
    }
    
    public void tableNameList(JComboBox<String> list) throws SQLException{
         String query = "SELECT name FROM tableInfo";
        ResultSet rs = run.readQuery(query);
        while (rs.next()) {
            list.addItem(rs.getString("name"));

        }
    }
    
    public void getEntryUserName(JComboBox<String> list, String tableName) throws SQLException{
         String query = "SELECT DISTINCT name FROM " + tableName;
        ResultSet rs = run.readQuery(query);
        while (rs.next()) {
            
            list.addItem(rs.getString("name"));

        }
    }

    public int getID(Object name) throws SQLException {
        //Object name = namelist.getSelectedItem();
        String query = "SELECT uid FROM user WHERE name ='" + name + "'";
        ResultSet rs = run.readQuery(query);
        while (rs.next()) {
            int id = rs.getInt("uid");
            return id;
        }
       
        return 0;

    }

    public int countMember(String tableName) throws SQLException {
       String query = "SELECT COUNT(DISTINCT uid) as COUNT FROM " + tableName;
        int c = 0;
        ResultSet rs = run.readQuery(query);
        while (rs.next()) {
            
            c = rs.getInt("COUNT");
            

        }
        return c;
    }
}
