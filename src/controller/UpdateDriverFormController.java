package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Customer;
import model.Driver;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateDriverFormController {

    public TextField txtDriverName;
    public TextField txtDriverId;
    public TextField txtDriverLicenceId;
    public TextField txtDriverContract;

    public void txtSearchOnAction(ActionEvent actionEvent) {
        try {
            ResultSet result =  CrudUtil.execute("SELECT * FROM Driver WHERE driverId=?",txtDriverId.getText());
            if (result.next()) {
                txtDriverName.setText(result.getString(2));
                txtDriverLicenceId.setText(result.getString(3));
                txtDriverContract.setText(String.valueOf(result.getDouble(4)));
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        Driver driver = new Driver(
                txtDriverId.getText(),txtDriverName.getText(), txtDriverLicenceId.getText(),txtDriverContract.getText()

        );

        try{
            boolean isUpdated = CrudUtil.execute("UPDATE Driver SET driverName=? , driverLicenceId=? , driverContract=? WHERE driverId=?",driver.getDriverName(),driver.getDriverLicenceId(),driver.getDriverContract(),driver.getDriverId());
            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();
            }else{
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }

        }catch (SQLException | ClassNotFoundException e){

        }
    }
 }

