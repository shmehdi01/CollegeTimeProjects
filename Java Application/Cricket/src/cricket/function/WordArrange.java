/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket.function;

import javax.swing.text.html.HTML;

/**
 *
 * @author rizwan
 */
public class WordArrange {
    static void combinationUtil(Object arr[],int n, int r, int index, Object data[], int i){
        if(index==r){
            for(int j=0;j<r;j++){
                System.out.print(data[j]+"  ");
            }
            System.out.println("");
            return;
        }
        
        if(i>=n)
            return;
        data[index]=arr[i];
        combinationUtil(arr, n, r, index+1, data, i+1);
        
        combinationUtil(arr, n, r, index, data, i+1);
   
    }
    
    static void printCombination(Object arr[],int n, int r){
        Object data[] = new Object[r];
        
        combinationUtil(arr, n, r, 0, data, 0);
    }
    
    public static void main(String[] args) {
        Object arr[] = {"A", "B", "C", "D"};
        int r =2;
        int n = arr.length;
        printCombination(arr, n, r);
    }
}
