/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket.function;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author rizwan
 */
public class SelectedPlayer {
    private ObservableList <String> list;

    public SelectedPlayer(ObservableList<String> list) {
        this.list = FXCollections.observableArrayList();
        this.list = list;
    }

    public ObservableList<String> getList() {
        return list;
    }
    
    
}
