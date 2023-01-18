package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Plant;
import util.CrudUtil;

import java.sql.SQLException;

public class SavePlantFormController {
    public TextField txtName;
    public TextField txtId;
    public TextField txtType;
    public TextField txtDesc;
    public TextField txtUnitPrice;
    public TextField txtQty;

    public void btnSaveOnAction(ActionEvent actionEvent) {
        Plant plant = new Plant(
                txtId.getText(), txtName.getText(), txtType.getText(), txtDesc.getText(),txtUnitPrice.getText(), txtQty.getText()
        );


        try {
            if (CrudUtil.execute("INSERT INTO Plant VALUES (?,?,?,?,?,?)",
                    plant.getPlantId(), plant.getPlantName(), plant.getPlantType(), plant.getPlantDescription() ,
                    plant.getPlantUnitPrice() , plant.getPlantQtyOnHand()))
            {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

        }
    }
}
