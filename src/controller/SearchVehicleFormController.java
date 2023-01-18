package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchVehicleFormController {
    public TextField txtbrand;
    public TextField txtId;
    public TextField txtvehicleType;
    public TextField txtnumberPlate;

    public void txtSearchOnAction(ActionEvent actionEvent) {
        try {
            search();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        try {
            search();
        } catch (ClassNotFoundException |SQLException e) {
            e.printStackTrace();
        }
    }
    private void search() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Vehicle WHERE vehicleId=?",txtId.getText());
        if (result.next()) {
            txtbrand.setText(result.getString(2));
            txtvehicleType.setText(result.getString(3));
            txtnumberPlate.setText(result.getString(4));
        } else {
            new Alert(Alert.AlertType.WARNING, "Empty Result").show();
        }
    }
}
