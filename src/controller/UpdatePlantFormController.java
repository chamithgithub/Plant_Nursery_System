package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Customer;
import model.Plant;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdatePlantFormController {
    public TextField txtName;
    public TextField txtId;
    public TextField txtType;
    public TextField txtDesc;
    public TextField txtUnitPrice;
    public TextField txtQty;

    public void txtSearchOnAction(ActionEvent actionEvent) {
        try {
            ResultSet result =  CrudUtil.execute("SELECT * FROM plant WHERE plantId=?",txtId.getText());
            if (result.next()) {
                txtName.setText(result.getString(2));
                txtType.setText(result.getString(3));
                txtDesc.setText(result.getString(4));
                txtUnitPrice.setText(result.getString(5));
                txtQty.setText(result.getString(6));
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        Plant plant = new Plant(
                txtId.getText(),txtName.getText(), txtType.getText(),txtDesc.getText(),txtUnitPrice.getText(),txtQty.getText()

        );

        try{
            boolean isUpdated = CrudUtil.execute("UPDATE plant SET plantName=? , plantType=? , plantDescription=?, plantUnitPrice=?, plantQtyOnHand=? WHERE plantId=?",plant.getPlantName(),plant.getPlantType(),plant.getPlantDescription(),plant.getPlantUnitPrice(),plant.getPlantQtyOnHand(),plant.getPlantId());
            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();
            }else{
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }

        }catch (SQLException | ClassNotFoundException e){

        }
    }
}
