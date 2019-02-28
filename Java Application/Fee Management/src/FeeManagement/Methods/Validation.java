/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeeManagement.Methods;

/**
 *
 * @author rizwan
 */
public class Validation {
        public static boolean isNummber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i)) || Character.isSpace(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
