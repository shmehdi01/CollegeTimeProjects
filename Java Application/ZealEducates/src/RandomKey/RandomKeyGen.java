
package RandomKey;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


public class RandomKeyGen {
    public RandomKeyGen()
    {
       String KEY;
        Random CAPS = new Random();
        Random small = new Random();
        Random digit1 = new Random();
        Random digit2 = new Random();
        char C1 = (char) (CAPS.nextInt(90-65) + 65);
        char C2 = (char) (CAPS.nextInt(90-65) + 65);
        char c1 = (char) (small.nextInt(122-97) + 97);
        char c2 = (char) (small.nextInt(122-97) + 97);
        int d1  = digit1.nextInt(99);
        int d2 = digit2.nextInt(99);
        
           
           String posb1 = C1+ "" + c2 + "" +  d1 + "" + C2 + "" + c1 + "" + d2;
           String posb2 = c2 + "" + C1 + "" +  d1 + "" + d2 + "" + C2 + "" + c1;
           String posb3 = C2 + "" + c2 + "" +  d1 + "" + c1 + "" + C1 + "" + d2;
           String posb4 = d1 + "" + c1 + "" +  C2 + "" + C1 + "" + c2 + "" + d2;
           String posb5 = d2 + "" + c1 + "" +  C2 + "" + C1 + "" + c2 + "" + d1;
           String posb6 = d1 + "" + c2 + "" +  C2 + "" + C1 + "" + c1+ "" + d2;
           String posb7=  C2 + "" + d1 + "" +  c2 + "" + c1 + "" + d2 + "" + C1;
           String posb8=  c2 + "" + d1 + "" +  C2 + "" + C1 + "" + d2 + "" + c2;
           
           String rand[] = {posb1, posb2, posb3, posb4, posb5, posb6, posb7, posb8};
           Random key = new Random();
           KEY = rand [key.nextInt(rand.length)];
           System.out.println(KEY);
           Method2();
    }
    
    public void Method2()
    {
        Random ran = new Random();
        int c = 0;
        int count_d = 0;
        int count_a = 0;
        int count_A= 0;
        int Max = 8;
        String Key = null;
        String getChar ;
        StringBuilder sb = new StringBuilder();
        String[] s = {"a", "b", "c", "d", "e", "f", "g", "e", "h", "i", "j", "k", "l", "m", "n",
                      "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "E", "H", "I", "J", "K", "L", "M", "N",
                      "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", 
                      "1", "2", "30","4","5","6","7","8","9","0" };
        
       
       while(c<Max)
        {
           getChar = s[ran.nextInt(s.length)];
            Key = (sb.append(getChar)).toString();
           
           if(Character.isDigit(getChar.charAt(0)))
           {
                count_d++;
                
           }
          
           if(Character.isLetter(getChar.charAt(0)) && Character.isLowerCase(getChar.charAt(0)))
           {
               count_a++;
           }
          
           if(Character.isLetter(getChar.charAt(0)) && Character.isUpperCase(getChar.charAt(0)))
           {
               count_A++;
           }
           /*for(int i=0; i<Key.length(); i++)
           {
               
           }*/
           if(count_d>4 && count_a>2 && count_A>2)
               continue;
           
          
           c ++; //count_d + count_a + count_A;
        }
       
       /*while(count_d<4)
       {
           getChar = s[ran.nextInt(s.length)];
           if(!Character.isDigit(getChar.charAt(0)))
                 continue; 
            Key = (sb.append(getChar)).toString();
            count_d++;
   
             
       }*/
        System.out.println("Digit: " + count_d);
        System.out.println("LowerCase : " + count_a);
        System.out.println("UpperCase : " + count_A);
        
        System.out.println(Key);
    }
        
       
        
    
    public static void main(String []args)
    {
            
        new RandomKeyGen();
        
    }
}
