/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Query;

import Database.DbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rizwan
 */
public class Run {

        public Connection con = null;
        public PreparedStatement pst = null;
        public ResultSet rs = null;

    public Run() {
        
    }

    public ResultSet readQuery(String query) throws SQLException  {
        
       
            con = DbConnect.dbConnection();
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            return rs;
       
    }

    public boolean insertQuery(String query) throws SQLException {
         con = DbConnect.dbConnection();
         pst = con.prepareStatement(query);
        int i = pst.executeUpdate();
        if (i > 0) {
            return true;
        }
        else return false;
    }
    
}
