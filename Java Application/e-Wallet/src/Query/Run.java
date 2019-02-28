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

/**
 *
 * @author rizwan
 */
public class Run {

    public Connection con;

    public Run() {
        con = DbConnect.dbConnection();
    }

    public ResultSet readQuery(String query) throws SQLException {
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        return rs;
    }

    public boolean insertQuery(String query) throws SQLException {
        PreparedStatement pst = con.prepareStatement(query);
        int i = pst.executeUpdate();
        if (i > 0) {
            return true;
        }
        return false;
    }
}
