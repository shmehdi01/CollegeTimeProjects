/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeeManagement.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rizwan
 */
public class DBConnect {
    private static DBConnect DB = null;
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private DBConnect(){
        createConnection();
    }
    
    public static DBConnect connectDB(){
        if(DB==null){
            DB = new DBConnect();
        }
        return DB;
    }
    void createConnection() {
        try {
            String path = "jdbc:sqlite:F:\\Work\\NetBeansProjects\\Fee Management\\src\\FeeManagement\\Database\\FeeManagement.sqlite";
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(path);   
            System.out.println("Database Connected");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet execQuery(String query){
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public boolean updateQuery(String query){
        boolean update = false;
        try {
            pst = con.prepareStatement(query);
            int i = pst.executeUpdate();
            if(i>0)
                update = true;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return update;
    }
}
