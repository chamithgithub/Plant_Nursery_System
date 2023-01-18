package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import views.tm.PlantTM;

public class PlantPlaceOrderFormController {
    public Label lblDate;
    public Label lblTime;
    public ComboBox cmbCustomerId;
    public TextField txtName;
    public TextField txtAddress;
    public ComboBox cmbPlantCode;
    public TextField txtPlantDescription;
    public TextField txtPlantQtyOnHand;
    public TextField txtplantUnitPrice;
    public TextField txtPlantQty;
    public TableView<PlantTM> tblCart;
    public TableColumn colPlantId;
    public TableColumn colPlantPrice;
    public TableColumn colPlantQty;
    public TableColumn colDeliveryCost;
    public TableColumn colTotalCost;
    public TableColumn colButton;
    public Label lblTotalCost;
    public ComboBox cmbDeliveryCode;
    public TextField txtDeliveryDesc;
    public TextField txtHireCost;
    public TextField txtContract;

    public void addPlantToCartOnAction(ActionEvent actionEvent) {
       /* double unitPrice =Double.parseDouble(txtplantUnitPrice.getText());
        int plantQty =Integer.parseInt(txtPlantQty.getText());
        double deliveryCost  =Double.parseDouble(txtHireCost.getText());
        double totalCost= unitPrice*plantQty+deliveryCost;

        Button btn =new Button("Delete");
        plantCartTm pTm=new plantCartTm(
                cmbCustomerId.getValue(),
                txtplantUnitPrice.getText(),
                plantQty,
                txtHireCost.getText(),
                totalCost,
                btn);
*/

    }

    public void plantRemoveItemOnAction(ActionEvent actionEvent) {
    }

    public void plantPlaceOrderOnAction(ActionEvent actionEvent) {
    }

    public void openNewCustomerOnAction(ActionEvent actionEvent) {
    }

    public void deliveryAddToCartOnAction(ActionEvent actionEvent) {
    }

    public void deliveryRemoveItemOnAction(ActionEvent actionEvent) {
    }
}
