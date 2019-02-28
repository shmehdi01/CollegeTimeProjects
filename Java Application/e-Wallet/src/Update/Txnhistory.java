/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Update;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author rizwan
 */
public class Txnhistory {

    private final SimpleStringProperty amount;
    private final SimpleStringProperty action;
    private final SimpleStringProperty date;

    public Txnhistory() {
        this.amount = null;
        this.action = null;
        this.date = null;
    }

    public Txnhistory(String amount, String action, String date) {
        this.amount = new SimpleStringProperty(amount);
        this.action = new SimpleStringProperty(action);
        this.date = new SimpleStringProperty(date);
    }

    public String getAmount() {
        return amount.get();
    }

    public String getAction() {
        return action.get();
    }

    public String getDate() {
        return date.get();
    }

}
