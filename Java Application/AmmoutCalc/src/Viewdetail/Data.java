/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewdetail;

/**
 *
 * @author rizwan
 */
public class Data {
    private int entid;
    private String name;
    private int amount;
    private String purpose;
    private String date;

    public Data(int entid, String name, int amount, String purpose, String date) {
        this.entid = entid;
        this.name = name;
        this.amount = amount;
        this.purpose = purpose;
        this.date = date;
    }

    public int getEntid() {
        return entid;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getDate() {
        return date;
    }
    
}
