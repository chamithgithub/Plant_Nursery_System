package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchDriverFormController {

    public TextField txtDriverId;
    public TextField txtDriverName;
    public TextField txtDriverLicenceId;
    public TextField txtDriverContract;

    public void txtSearchOnAction(ActionEvent actionEvent) {
        try {
            search();
        } catch (ClassNotFoundException |SQLException e) {
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
        ResultSet result = CrudUtil.execute("SELECT * FROM Driver WHERE driverId=?",txtDriverId.getText());
        if (result.next()) {
            txtDriverName.setText(result.getString(2));
            txtDriverLicenceId.setText(result.getString(3));
            txtDriverContract.setText(result.getString(4));
        } else {
            new Alert(Alert.AlertType.WARNING, "Empty Result").show();
        }
    }
}
