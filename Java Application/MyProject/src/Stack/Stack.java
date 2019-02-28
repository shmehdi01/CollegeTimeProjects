
package Stack;

public class Stack {
    String data[] ;
    int maxSize ;
    int top;
    public Stack(int n)
    {
        maxSize = n;
        data = new String[maxSize];
        top = 0;
    }
    
    public boolean Empty()
    {
        if(top == 0)
            return true;
        else 
            return false;
    }
    
    public void Push(String str)
    {
       if(top< maxSize) 
       {
         data[top] = str;
         top++;
       } else 
           System.out.println("OverFlow");
    }
    
    public String Pop()
    {
        if(!this.Empty())
        {
            String temp = this.Peek();
            data[top-1]= null;
            top --;
            return temp;
        } else return null;
    }
    
    public String PopAll()
    {
        String temp;
        do{
            temp = this.Peek();
            data[top-1]= null;
            top --;
        } while(!this.Empty());
        if(!this.Empty())
        {
            return temp;
        } else return null;
    }
    
    public String Peek()
    {
        if(top>0)
        {
            return data[top-1];
        } else return null;
    }
}
