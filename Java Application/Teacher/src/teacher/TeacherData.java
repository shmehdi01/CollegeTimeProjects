/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher;

/**
 *
 * @author rizwan
 */
    
public class TeacherData {
 private String id, firstName, lastName, dob, gender, city, mobile, email, subject, quali, att ;
    
 public TeacherData(String id, String firstName,String lastName,String dob,String gender,String city,String mobile,String email,String subject,String quali,String att)
 {
     this.id = id;
     this.firstName = firstName;
     this.lastName = lastName;
     this.dob = dob;
     this.gender = gender;
     this.city = city;
     this.mobile = mobile;
     this.email = email;
     this.subject = subject;
     this.quali = quali;
     this.att = att;
     
 }
 
 public String getId()
 {
     return id;
 }
 
 public String getFirstname()
 {
     return firstName;
 }
 
 public String getLastname()
 {
     return lastName;
 }
 
 public String getDob()
 {
     return dob;
 }
 
 public String getGen()
 {
     return gender;
 }
 
 public String getCity()
 {
     return city;
 }
 public String getMob()
 {
     return mobile;
 }
 
 public String getEmail()
 {
     return email;
 }
 
 public String getSub()
 {
     return subject;
 }
 
 public String getQuali()
 {
     return quali;
 }
 
 public String getAttendence()
 {
     return att;
 }
 
}
