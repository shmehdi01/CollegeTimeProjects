
package RandomKey;

import java.util.Random;

public class RandomKeyGenerator 
{
  
    int Max;
    int counter;
    int lower,upper,digit;
    String Key = null;
   
        
    
    public RandomKeyGenerator()
    {
        Max = 8;
        counter = 0;
        digit =4;
        lower=2;
        upper=2;
        getKey();
       
    }
     public RandomKeyGenerator(int max, int Digit, int Lower, int Upper)
    {
        Max = max;
        counter = 0;
        digit =Digit;
        lower=Lower;
        upper=Upper;
        
       
    }
    public void getKey()
    {
        Random getRandom ;getRandom = new Random();
        int count =0;
 
        StringBuilder  sb = new StringBuilder();
        String[] charList = {"a", "b", "c", "d", "e", "f", "g", "e", "h", "i", "j", "k", "l", "m", "n",
                      "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "E", "H", "I", "J", "K", "L", "M", "N",
                      "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", 
                      "1", "2", "30","4","5","6","7","8","9","0" };
        String getChar;
        String tempKey = null;
        while(count<Max)
        {
        getChar = charList[getRandom.nextInt(charList.length)];
        tempKey = (sb.append(getChar)).toString(); 
        count++;
        }
        
        Condition(tempKey);
        
       
    }
    public void Condition(String getKey)
    {
       String temp = getKey;
       char Check;
       int d=0, l=0, U=0;
       for(int i = 0; i<temp.length(); i++)
       {
          Check = temp.charAt(i);
          if(Character.isDigit(Check))
             d++;
          if(Character.isLetter(Check) && Character.isUpperCase(Check))
              U++;
          if(Character.isLetter(Check) && Character.isLowerCase(Check))
              l++;      
       }
       if(d!=digit)
           getKey();
       else if(l!=lower)
           getKey();
       else if(U!=upper)
           getKey();
       else System.out.println(temp);
         
    }
   
    public static void main(String []args)
    {
        new RandomKeyGenerator();
        new RandomKeyGenerator(8,4,2,2);
    }
}
