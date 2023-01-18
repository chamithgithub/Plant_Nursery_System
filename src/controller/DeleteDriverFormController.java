package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteDriverFormController {

    public TextField txtDriverName;
    public TextField txtDriverId;
    public TextField txtDriverLicenceId;
    public TextField txtDriverContract;

    public void txtSearchOnAction(ActionEvent actionEvent) {
        search();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        try{
            if (CrudUtil.execute("DELETE FROM Driver WHERE driverId=?",txtDriverId.getText())){
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted!").show();
            }else{
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }

        }catch (SQLException | ClassNotFoundException e){

        }

    }

    private void search() {
        try {
            ResultSet result = CrudUtil.execute("SELECT * FROM Driver WHERE driverId=?", txtDriverId.getText());
            if (result.next()) {
                txtDriverName.setText(result.getString(2));
                txtDriverLicenceId.setText(result.getString(3));
                txtDriverContract.setText(result.getString(4));

            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
