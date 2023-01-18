package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Customer;
import model.Vehicle;
import util.CrudUtil;

import java.sql.SQLException;

public class SaveVehicleFormController {
    public TextField txtbrand;
    public TextField txtId;
    public TextField txtvehicleType;
    public TextField txtnumberPlate;

    public void btnAddOnAction(ActionEvent actionEvent) {
        Vehicle vehicle = new Vehicle(
                txtId.getText(), txtbrand.getText(), txtvehicleType.getText(), txtnumberPlate.getText()
        );
        try {
            if (CrudUtil.execute("INSERT INTO Vehicle VALUES (?,?,?,?)", vehicle.getVehicleId(), vehicle.getVehicleBrand(), vehicle.getVehicleType(), vehicle.getVehicleNumberPlate())) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

        }
    }
}
