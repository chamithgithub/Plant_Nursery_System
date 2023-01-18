package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteVehicleFormController {
    public TextField txtId;
    public TextField Strand;
    public TextField vehicleType;
    public TextField txtNumberPlate;

    public void txtSearchOnAction(ActionEvent actionEvent) {
        search();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        try{
            if (CrudUtil.execute("DELETE FROM Vehicle WHERE vehicleId=?",txtId.getText())){
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted!").show();
            }else{
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }

        }catch (SQLException | ClassNotFoundException e){

        }
    }
    private void search() {
        try {
            ResultSet result = CrudUtil.execute("SELECT * FROM Vehicle WHERE vehicleId=?",txtId.getText());
            if (result.next()) {
                Strand.setText(result.getString(2));
                vehicleType.setText(result.getString(3));
                txtNumberPlate.setText(result.getString(4));

            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
