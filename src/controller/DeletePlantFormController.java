package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeletePlantFormController {
    public TextField txtName;
    public TextField txtId;
    public TextField txtType;
    public TextField txtDesc;
    public TextField txtUnitPrice;
    public TextField txtQty;

    public void txtSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        search();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        try{
            if (CrudUtil.execute("DELETE FROM plant WHERE plantId=?",txtId.getText())){
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted!").show();
            }else{
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }

        }catch (SQLException | ClassNotFoundException e){

        }
    }
    private void search() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM plant WHERE plantId=?",txtId.getText());
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
