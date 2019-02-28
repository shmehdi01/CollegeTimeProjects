/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raw;

import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author rizwan
 */
public class FileIO {
    
    public static void main(String []args){
      
        try {
            File dir = new File("fileIO");
            dir.mkdir();
            File file = new File(dir,"text.txt");
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            fw.write("this is a text file!!");
            fw.flush();
            fw.close();
            
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
