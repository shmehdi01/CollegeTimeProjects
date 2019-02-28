/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket.function;

/**
 *
 * @author rizwan
 */
public class Combination {

    public Combination() {
        System.out.println(calculate(8, 7));
        arrange();
    }
    
    
    int calculate(int n, int r){
        int c = (fact(n)/(fact(n-r)*fact(r)));
        return c;
        
    }
    
    int fact(int num){
        int fact = 1;
        while(num>1){
            fact = fact*num;
            num--;
        }
        return fact;
    }
    
    void arrange(){
        String []a = {"a","b","c","d"};
        String b;
        for(int i=0;i<a.length;i++){
            if(i<a.length){
               b = a[i]+a[i+1];
            System.out.println(b); 
            }
            
        }
    }
    
    public static void main(String[] args) {
        new Combination();
    }
}
