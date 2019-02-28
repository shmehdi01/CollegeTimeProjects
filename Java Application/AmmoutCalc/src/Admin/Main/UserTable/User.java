/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin.Main.UserTable;

/**
 *
 * @author rizwan
 */
public class User {
    private int uid;
    private String name;
    private String mobile;

    public User(int uid, String name, String mobile) {
        this.uid = uid;
        this.name = name;
        this.mobile = mobile;
    }

    public int getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }
    
}


