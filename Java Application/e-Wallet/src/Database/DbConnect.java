/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rizwan
 */
public class DbConnect {

    public static Connection dbConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:ewallet.sqlite");
            
            System.out.println("connected");
            return con;
        } catch (Exception e) {
            System.out.println("failed");
            e.printStackTrace();
            return null;
        }

    }
    
}
