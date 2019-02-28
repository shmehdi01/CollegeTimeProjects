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
public class Test {

    public static void main(String[] args) {
       
    }
    ObservableList<String> list1 = FXCollections.observableArrayList();
    ObservableList<String> list2 = FXCollections.observableArrayList();

    void createGroup(ObservableList<String> list) {
       // ObservableList<String> list1 = FXCollections.observableArrayList("Andhra Pradesh & Telengana", "Assam", "Bihar & Jharkhand", "Chennai");
        int len = list.size()/2;
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        int i =0;
        while(i<len){
           
            if(!isExist(list.get(index))){
                list1.add(list.get(index));
                list.remove(index);
                list2 = list;
                System.out.println(list1.get(i));
                index = rand.nextInt(list.size());
                i++;
            }
            else{
                index = rand.nextInt(list.size());
            }
            
        }
        System.out.println("list 2");
        for(int j=0; j<list2.size();j++){
            System.out.println(list2.get(j));
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
}
