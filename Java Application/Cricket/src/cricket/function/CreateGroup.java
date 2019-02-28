/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket.function;

import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author rizwan
 */
public class CreateGroup {
    ObservableList<String> list1 = FXCollections.observableArrayList();
    ObservableList<String> list2 = FXCollections.observableArrayList();

    public CreateGroup(ObservableList<String> list) {
        int len = list.size()/2;
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        int i =0;
        while(i<len){
            if(!isExist(list.get(index))){
                list1.add(list.get(index));
                list.remove(index);
                list2 = list;
                index = rand.nextInt(list.size());
                i++;
            }
            else{
                index = rand.nextInt(list.size());
            }
            
        }   
    }

    boolean isExist(String value) {
        for(int i=0;i<list1.size(); i++){
            if(value.equals(list1.get(i))){
                return true;
            }
        }
        return false;
    }
    
    public ObservableList<String> getGroupA(){
        return list1;
    }
    public ObservableList<String> getGroupB(){
        return list2;
    }
}
