package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VehicleDashBoardFormController {
    public void loadAllVehicleOnAction(ActionEvent actionEvent) throws IOException {
        setUi("loadAllVehicle");
    }

    public void searchVehicleOnAction(ActionEvent actionEvent) throws IOException {
        setUi("searchVehicleForm");
    }

    public void deleteVehicleOnAction(ActionEvent actionEvent) throws IOException {
        setUi("deleteVehicleForm");
    }

    public void updateVehicleOnAction(ActionEvent actionEvent) throws IOException {
        setUi("updateVehicleForm");
    }

    public void saveVehicleOnAction(ActionEvent actionEvent) throws IOException {
        setUi("NewVehicleForm");
    }
    private void setUi(String URI) throws IOException {
        Parent parent  = FXMLLoader.load(getClass().getResource("../views/"+URI+".fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle(URI);
        stage.show();
    }
}
