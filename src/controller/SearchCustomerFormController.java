package controller;

import db.DBConnection;
import db.DataSet;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Customer;
import util.CrudUtil;

import java.sql.*;

public class SearchCustomerFormController {

    public TextField txtName;
    public TextField txtAddress;
    public TextField txtContract;
    public TextField txtId;

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
        ResultSet result = CrudUtil.execute("SELECT * FROM customer WHERE CustomerId=?",txtId.getText());
        if (result.next()) {
            txtName.setText(result.getString(2));
            txtAddress.setText(result.getString(3));
            txtContract.setText(result.getString(4));
        } else {
            new Alert(Alert.AlertType.WARNING, "Empty Result").show();
        }
    }

}
