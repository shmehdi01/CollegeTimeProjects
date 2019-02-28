/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket.db;

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
public class DBConnection {
    private static DBConnection DB;
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public DBConnection() {
        createConnection();
    }
    
     public static DBConnection getConnection(){
        if(DB==null){
            DB = new DBConnection();
        }
        return DB;
    }
    
    void createConnection() {
        try {
            String path = "jdbc:sqlite:cricket.sqlite";
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(path);   
            System.out.println("Database Connected");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet execQuery(String query){
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return update;
    }
    
    public boolean existTable(String tablename) {
        boolean exist = false;
        try (ResultSet rs = con.getMetaData().getTables(null, null, tablename, null)) {
            while (rs.next()) {
                String tblname = rs.getString("TABLE_NAME");
                if (tblname != null && tblname.equals(tablename)) {
                    exist = true;
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exist;
    }
    
    public static void main(String[] args) {
        new DBConnection();
    }
    
}
