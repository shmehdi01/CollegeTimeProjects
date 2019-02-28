/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package add;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author rizwan
 */
public class Add {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager sen = new ScriptEngineManager();
        ScriptEngine eng = sen.getEngineByName("JavaScript");
        eng.eval("print('document.write(5)')");
    }
    
}
