/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket.function;

import cricket.db.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author rizwan
 */
public class TeamList {
    DBConnection DBHandler;
    private ObservableList <String> teamlist;
    public TeamList() {
        teamlist = FXCollections.observableArrayList();
        DBHandler = DBConnection.getConnection();
        try {
            String query = "SELECT name FROM Teams";
            ResultSet rs = DBHandler.execQuery(query);
            while(rs.next()){
                teamlist.add(rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeamList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObservableList<String> getTeamlist() {
        return teamlist;
    }
      
    public static void main(String[] args) throws SQLException {
        System.out.println(new TeamList().getTeamlist());
        
    }
    
    
}
