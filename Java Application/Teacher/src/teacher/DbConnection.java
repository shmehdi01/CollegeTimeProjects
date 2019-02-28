/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher;

import java.sql.*;
import java.util.logging.Level;


/**
 *
 * @author rizwan
 */
public class DbConnection {
    
    public static Connection getConnection()
    {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\db\\Teachers.sqlite");
            return conn;
        } catch (Exception ex) {
            System.out.println("Error in Db");
            return null;
        }
        
    }
    
}
