package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchProductFormController {
    public TextField txtName;
    public TextField txtId;
    public TextField txtType;
    public TextField txtDesc;
    public TextField txtUnitPrice;
    public TextField txtQty;

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
        ResultSet result = CrudUtil.execute("SELECT * FROM product WHERE productId=?",txtId.getText());
        if (result.next()) {
            txtName.setText(result.getString(2));
            txtType.setText(result.getString(3));
            txtDesc.setText(result.getString(4));
            txtUnitPrice.setText(result.getString(5));
            txtQty.setText(result.getString(6));
        } else {
            new Alert(Alert.AlertType.WARNING, "Empty Result").show();
        }
    }
}
