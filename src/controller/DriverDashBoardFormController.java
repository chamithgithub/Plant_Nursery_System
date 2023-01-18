package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DriverDashBoardFormController {

    public void loadAllDriverOnAction(ActionEvent actionEvent) throws IOException {
        setUi("loadAllDriverForm");
    }

    public void searchDriverOnAction(ActionEvent actionEvent) throws IOException {
        setUi("searchDriverForm");
    }

    public void updateDriverOnAction(ActionEvent actionEvent) throws IOException {
        setUi("updateDriverForm");
    }

    public void deleteDriverOnAction(ActionEvent actionEvent) throws IOException {
        setUi("deleteDriverForm");
    }

    public void saveDriverOnAction(ActionEvent actionEvent) throws IOException {
        setUi("NewDriverForm");
    }
    private void setUi(String URI) throws IOException {
        Parent parent  = FXMLLoader.load(getClass().getResource("../views/"+URI+".fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle(URI);
        stage.show();
    }
}
