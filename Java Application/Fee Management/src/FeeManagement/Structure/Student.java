/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeeManagement.Structure;

/**
 *
 * @author rizwan
 */
public class Student {
    private int regid;
    private int roll;
    private String fname;
    private String lname;
    private String father;
    private String mobile;
    private String email;
    private String cls;
    private String sec;
    private String session;
    private String add;
    private String cat;

    public Student(int regid, int roll, String fname, String lname, String father, String mobile, String email, String cls, String sec, String session, String add, String cat) {
        this.regid = regid;
        this.roll = roll;
        this.fname = fname;
        this.lname = lname;
        this.father = father;
        this.mobile = mobile;
        this.email = email;
        this.cls = cls;
        this.sec = sec;
        this.session = session;
        this.add = add;
        this.cat = cat;
    }

    public int getRegid() {
        return regid;
    }

    public int getRoll() {
        return roll;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getFather() {
        return father;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getCls() {
        return cls;
    }

    public String getSec() {
        return sec;
    }

    public String getSession() {
        return session;
    }

    public String getAdd() {
        return add;
    }
     public String getCat() {
        return cat;
    }
}
