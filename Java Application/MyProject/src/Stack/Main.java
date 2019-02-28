/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

/**
 *
 * @author rizwan
 */
public class Main {
    public static void main(String []args)
    {
        Stack s = new Stack(4);
        System.out.println(s.Empty());
        s.Push("1");
         System.out.println(s.Peek());
        s.Push("2");
        System.out.println(s.Peek());
        s.Push("3");
         System.out.println(s.Peek());
        s.Push("4");
        System.out.println(s.Peek());
        System.out.println(s.Empty());
        System.out.println(s.PopAll());
        System.out.println(s.Peek());
        System.out.println(s.Empty());
        
    }
}
