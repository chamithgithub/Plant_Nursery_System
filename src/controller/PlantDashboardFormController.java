package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PlantDashboardFormController {
    public void loadAllPlantOnAction(ActionEvent actionEvent) throws IOException {

        setUi("loadAllPlantForm");
    }

    public void searchPlantOnAction(ActionEvent actionEvent) throws IOException {

        setUi("searchPlantForm");
    }

    public void deletePlantOnAction(ActionEvent actionEvent) throws IOException {

        setUi("deletePlantForm");
    }

    public void savePlantOnAction(ActionEvent actionEvent) throws IOException {

        setUi("NewPlantForm");
    }

    public void updatePlantOnAction(ActionEvent actionEvent) throws IOException {

        setUi("updatePlantForm");
    }
    private void setUi(String URI) throws IOException {
        Parent parent  = FXMLLoader.load(getClass().getResource("../views/"+URI+".fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle(URI);
        stage.show();
    }
}
