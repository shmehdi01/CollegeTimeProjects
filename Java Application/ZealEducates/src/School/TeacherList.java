
package School;

import java.util.ArrayList;


public class TeacherList {
    
    public static String Name, Email, Join_Date, Quali, Sub_Teacher;
    public static long Contact;
    public static int ID;
    
    public static ArrayList <TeacherList> List ; 
    
    
    
    
  public TeacherList()
  {
      Name = "Abc 123";
      Contact = 123456; //8755235450
      ID = 1001;
      Email = "abcd@xyz.com";
      Join_Date = "8/8/2016";
      Quali = "M.tech";
      Sub_Teacher = "Software Development";
  }
  
  public static void main(String []args)
  {
      new TeacherList();
      List = new ArrayList <TeacherList> ();
  }
 
       
            
    
}
