
package AdmissionCell;

import java.awt.Label;
import javafx.fxml.FXML;



public class EnquiryGUIController  {
    @FXML
    Label l;
    @FXML
    public void loginclicked()
    {
        l.setText("welcome");
        System.out.println("you clicked");
    }
}
