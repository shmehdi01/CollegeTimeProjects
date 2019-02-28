/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

/**
 *
 * @author rizwan
 */
public class Validation {

    public boolean checkPhoneLen(String number) {
        int len = number.length();
        if (len != 10) {
            return false;
        } 
        else {
            return true;
        }
    }

    public boolean checkPhoneNum(String number) {
        for (int i = 0; i < number.length(); i++) {
            if(number.startsWith(i +"") || !checkPhoneLen(number)){
                if(i>6)
                    break;
                return false;
            }
            else if (Character.isLetter(number.charAt(i)) || Character.isSpace(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
