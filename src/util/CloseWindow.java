package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public interface CloseWindow {

     void CloseWindowUi(AnchorPane x) throws IOException;
    /* private void CloseWindow(String URI) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("../views/"+URI+".fxml"));
          Scene scene = new Scene(root);
          Stage stage = new Stage();
          stage.setScene(scene);
          stage.show();
     }*/
}
