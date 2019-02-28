/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Update;

import Login.Action;
import Query.Run;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rizwan
 */
public class Refresh {

    Run run;
    private String name = null;
    private int userid = 0;

    public Refresh() {
        run = new Run();
    }

    public void getUserInfo(String number) throws SQLException {

        String query = "SELECT name,userid FROM login WHERE mobile = " + number;
        ResultSet rs = run.readQuery(query);
        while (rs.next()) {
            name = rs.getString("name");
            userid = rs.getInt("userid");
        }

    }

    public String getUserName() {
        return name;
    }

    public int getUserId() {
        return userid;
    }
}
