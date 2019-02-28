package addMoney;


import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AddMoneyController {

    @FXML
    Button next;

    @FXML
    public void goNext() throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("CardDetail.fxml"));
     Scene scene = new Scene(root);
     Stage stage = ModelView.ModelView.stage;
     stage.setScene(scene);
     stage.show();
    }
}
