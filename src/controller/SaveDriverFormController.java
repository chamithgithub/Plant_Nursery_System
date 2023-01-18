package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Driver;
import util.CrudUtil;

import java.sql.SQLException;

public class SaveDriverFormController {
    public TextField txtName;
    public TextField txtId;
    public TextField txtLicence;
    public TextField txtContract;

    public void btnSaveOnAction(ActionEvent actionEvent) {
        Driver driver = new Driver(
                txtId.getText(), txtName.getText(), txtLicence.getText(), txtContract.getText()
        );


        try {
            if (CrudUtil.execute("INSERT INTO Driver VALUES (?,?,?,?)", driver.getDriverId(), driver.getDriverName(), driver.getDriverLicenceId(), driver.getDriverContract())) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

        }

    }
}
