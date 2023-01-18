package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Vehicle;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateVehicleFormController {
    public TextField txtbrand;
    public TextField txtId;
    public TextField txtvehicleType;
    public TextField txtnumberPlate;

    public void txtSearchOnAction(ActionEvent actionEvent) {
        try {
            ResultSet result =  CrudUtil.execute("SELECT * FROM Vehicle WHERE vehicleId=?",txtId.getText());
            if (result.next()) {
                txtbrand.setText(result.getString(2));
                txtvehicleType.setText(result.getString(3));
                txtnumberPlate.setText(String.valueOf(result.getDouble(4)));
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        Vehicle vehicle = new Vehicle(
                txtId.getText(),txtbrand.getText(), txtvehicleType.getText(),txtnumberPlate.getText()

        );

        try{
            boolean isUpdated = CrudUtil.execute("UPDATE Vehicle SET vehicleBrand=? , vehicleType=? , vehicleBrand=? WHERE vehicleId=?",vehicle.getVehicleBrand(),vehicle.getVehicleType(),vehicle.getVehicleNumberPlate(),vehicle.getVehicleId());
            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();
            }else{
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }

        }catch (SQLException | ClassNotFoundException e){

        }
    }
}
