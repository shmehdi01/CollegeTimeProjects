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

/**
 *
 * @author rizwan
 */
public class Team {
    private int teamid;
    private String name;
    private String nickname;
    private String logo;
    DBConnection DBHandler;

    public Team() {
        this.teamid = 0;
        this.name = "";
        this.nickname = "";
        this.logo = "";
        System.out.println("helo");
    }

    public Team(Object attr, Object value) {
        DBHandler = DBConnection.getConnection();
       String query = "SELECT * FROM Teams WHERE " +  attr + "=" + "'" + value + "'";
        System.out.println(query);
        ResultSet rs = DBHandler.execQuery(query);
        try {
            while(rs.next()){
                teamid = rs.getInt("teamid");
                name = rs.getString("name");
                nickname = rs.getString("nickname");
                logo = rs.getString("logo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Team.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getTeamid() {
        return teamid;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getLogo() {
        return logo;
    }
    
    
    
    public static void main(String[] args) throws SQLException {
        Team t = new Team("teamid", 3);
        System.out.println(t.getNickname());
    }
    
    
}
