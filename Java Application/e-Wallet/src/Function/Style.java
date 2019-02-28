/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import javafx.scene.Parent;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author rizwan
 */
public class Style {
       public void roundCorner(Parent root, int w, int h, double r){
        Rectangle rect = new Rectangle(w,h);
        rect.setArcHeight(r);
        rect.setArcWidth(r);
        root.setClip(rect);
   }
}
