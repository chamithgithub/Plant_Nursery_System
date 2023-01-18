package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.*;
import views.tm.CartTM;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class PlaceOrderFormController {

    public Label lblDate;
    public Label lblTime;
    public ComboBox<String> cmbCustomerId;
    public TextField txtAddress;
    public TextField txtQtyOnHand;
    public TextField txtName;
    public TextField txtSalary;
    public ComboBox cmbItemCode;
    public TextField txtDescription;
    public TextField txtUnitPrice;
    public TextField txtQty;
    public TableView<CartTM> tblCart;
    public TableColumn colQty;
    public TableColumn colButton;
    public TableColumn colTotalCost;
    public Label lblTotalCost;
    public ComboBox<String> cmbPlantCode;
    public TextField txtPlantDescription;
    public TextField txtPlantQtyOnHand;
    public TextField txtplantUnitPrice;
    public TextField txtPlantQty;
    public TableColumn colDeliveryCost;
    public ComboBox cmbLocationCode;
    public TextField DeliveryDesc;
    public TextField txtHireCost;
    public TextField txtContract;
    public ComboBox<String> cmbProductCode;
    public TextField txtProductDescription;
    public TextField txtProductQtyOnHand;
    public TextField txtProductUnitPrice;
    public TextField txtProductQty;
    public ComboBox<String> cmbDeliveryCode;
    public TextField txtDeliveryDesc;
    public TableColumn colPlantId;
    public TableColumn colProductId;
    public TableColumn colPlantPrice;
    public TableColumn colProductPrice;
    public TableColumn colPlantQty;
    public TableColumn colProductQty;
    public TextField txtAddPlantQty;
    public TableColumn colPlantDesc;
    public TextField txtAddProductQty;
    public TableView<PlantCartTM> plantTbl;
    public TableColumn colPlantCode;
    public TableColumn colPlantUnitPrice;
    public TableColumn colPlantTotal;
    public TableColumn colPlantBtn;
    public TableView<ProductCartTM> productTbl;
    public TableColumn colProductCode;
    public TableColumn ColProductDesc;
    public TableColumn colProductUnitPrice;
    public TableColumn colProductTotalCost;
    public TableColumn colProductBtn;
    public TableColumn colPlantQtyCart;
    public TableColumn colProductQtyCart;

    public void initialize() {

        colPlantCode.setCellValueFactory(new PropertyValueFactory<>("plantCode"));
        colPlantDesc.setCellValueFactory(new PropertyValueFactory<>("PlantDescription"));
        colPlantUnitPrice.setCellValueFactory(new PropertyValueFactory<>("PlantUnitPrice"));
        colPlantQty.setCellValueFactory(new PropertyValueFactory<>("PlantQty"));
        colPlantTotal.setCellValueFactory(new PropertyValueFactory<>("PlantTotalCost"));
        colPlantBtn.setCellValueFactory(new PropertyValueFactory<>("PlantBtn"));
//product
        colProductCode.setCellValueFactory(new PropertyValueFactory<>("plantCode"));
        ColProductDesc.setCellValueFactory(new PropertyValueFactory<>("PlantDescription"));
        colProductUnitPrice.setCellValueFactory(new PropertyValueFactory<>("PlantUnitPrice"));
        colProductQty.setCellValueFactory(new PropertyValueFactory<>("PlantQty"));
        colProductTotalCost.setCellValueFactory(new PropertyValueFactory<>("PlantTotalCost"));
        colProductBtn.setCellValueFactory(new PropertyValueFactory<>("PlantBtn"));

      /*  colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colTotalCost.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
        colButton.setCellValueFactory(new PropertyValueFactory<>("btn"));
     */

        colPlantId.setCellValueFactory(new PropertyValueFactory<>("PlantIdTm"));
        colProductId.setCellValueFactory(new PropertyValueFactory<>("ProductIdTm"));
        colPlantPrice.setCellValueFactory(new PropertyValueFactory<>("PlantUnitPriceTm"));
        colProductPrice.setCellValueFactory(new PropertyValueFactory<>("ProductUnitPriceTm"));
        colPlantQtyCart.setCellValueFactory(new PropertyValueFactory<>("PlantQtyTm"));
        colProductQtyCart.setCellValueFactory(new PropertyValueFactory<>("ProductQtyTm"));
        colDeliveryCost.setCellValueFactory(new PropertyValueFactory<>("DeliveryCostTm"));
        colTotalCost.setCellValueFactory(new PropertyValueFactory<>("TotalCostTm"));
        colButton.setCellValueFactory(new PropertyValueFactory<>("btn"));

        loadDateAndTime();
        setCustomerIds();
        setPlantIds();
        setProductIds();
        setDeliveryIds();
        setOrderId();

        //--------------------
        cmbCustomerId.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    setCustomerDetails(newValue);
                });
        cmbPlantCode.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    setPlantDetails(newValue);
                });
        cmbProductCode.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    setProductDetails(newValue);
                });
        cmbDeliveryCode.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    setDeliveryDetails(newValue);
                });
        //--------------------
    }

    private void setOrderId() {

    }

    private void setCustomerIds() {
        try {
            ObservableList<String> cIdObList = FXCollections.observableArrayList(
                    CustomerCrudController.getCustomerIds()
            );
            cmbCustomerId.setItems(cIdObList);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void setPlantIds() {

        try {
            ObservableList<String> cIdObList = FXCollections.observableArrayList(
                    PlantCrudController.getPlantIds()
            );
            System.out.println(cIdObList);
            cmbPlantCode.setItems(cIdObList);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void setDeliveryIds() {

        try {
            ObservableList<String> cIdObList = FXCollections.observableArrayList(
                    DeliveryCrudController.getDeliveryIds()
            );
            System.out.println(cIdObList);
            cmbDeliveryCode.setItems(cIdObList);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void setProductIds() {
        try {

            ObservableList<String> cIdObList = FXCollections.observableArrayList(
                    ProductCrudController.getProductIds()
            );
            System.out.println(cIdObList);
            cmbProductCode.setItems(cIdObList);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void setCustomerDetails(String selectedCustomerId) {
        try {
            Customer c = CustomerCrudController.getCustomer(selectedCustomerId);
            if (c != null) {
                txtName.setText(c.getCustomerName());
                txtAddress.setText(c.getCustomerAddress());
                txtContract.setText(c.getCustomerContract());
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void setPlantDetails(String selectedItemCode) {
        try {

            Plant plant = PlantCrudController.getPlant(selectedItemCode);
//            System.out.println(plant.getPlantName());
            if (plant != null) {
                txtPlantDescription.setText(plant.getPlantName());
                txtplantUnitPrice.setText(String.valueOf(plant.getPlantQtyOnHand()));
                txtPlantQtyOnHand.setText(String.valueOf(plant.getPlantUnitPrice()));
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void setProductDetails(String selectedItemCode) {
        try {

            Product product = ProductCrudController.getProduct(selectedItemCode);
//            System.out.println(product.getProductName());
            if (product != null) {
                txtProductDescription.setText(product.getProductName());
                txtProductUnitPrice.setText(String.valueOf(product.getProductQtyOnHand()));
                txtProductQtyOnHand.setText(String.valueOf(product.getProductUnitPrice()));
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void setDeliveryDetails(String selectedItemCode) {
        try {

            Delivery delivery = DeliveryCrudController.getDelivery(selectedItemCode);
       //  System.out.println(delivery.getLocation());
            if (delivery != null) {
                txtDeliveryDesc.setText(delivery.getLocation());
                txtHireCost.setText(String.valueOf(delivery.getHireCost()));
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void loadDateAndTime() {
        /*set Date*/
        lblDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        /*set Time*/
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(currentTime.getHour() + ":" +
                    currentTime.getMinute() + ":" +
                    currentTime.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void placeOrderOnAction(ActionEvent actionEvent) {


    }

    ObservableList<PlantCartTM> PlTmList = FXCollections.observableArrayList();
    public void addPlantToCartOnAction(ActionEvent actionEvent) {
/*
        double plUnitPrice = Double.parseDouble(txtplantUnitPrice.getText());
        //int plQty = Integer.parseInt(txtPlantQty.getText());
        int plQty = Integer.parseInt(txtPlantQty.getText());
        double plTotalCost = plUnitPrice * plQty;

        System.out.println(plTotalCost);

        PlantCartTM isExistsPl = isExistsPl(cmbPlantCode.getValue());

        if (isExistsPl != null) {
            for (PlantCartTM temp : PlTmList
            ) {
                if (temp.equals(isExistsPl)) {
                    temp.setPlantQty((temp.getPlantQty() + plQty));
                    temp.setPlantTotalCost(temp.getPlantTotalCost() + plTotalCost);

                    System.out.println(plTotalCost);
                }
            }
        } else {
            Button PlantBtn = new Button("Delete");

            PlantCartTM PlTm = new PlantCartTM(
                    cmbPlantCode.getValue(),
                    txtPlantDescription.getText(),
                    plUnitPrice,
                    plQty,
                    plTotalCost,
                    PlantBtn
            );

            PlantBtn.setOnAction(e -> {
                PlTmList.remove(PlTm);
               // calculateTotal();
            });

            PlTmList.add(PlTm);
            plantTbl.setItems(PlTmList);
        }
        plantTbl.refresh();
       // calculateTotal();
       */

    }


/*
    private void calculateTotal() {
        double total = 0;
        for (PlantCartTM PlTm : PlTmList
        ) {
            total += PlTm.getPlantTotalCost();
        }
        lblTotalCost.setText(String.valueOf(total));
    }*/

    ObservableList<ProductCartTM> tmList = FXCollections.observableArrayList();

    public void addProductToCartOnAction(ActionEvent actionEvent) {

    }

    public void plantRemoveItemOnAction(ActionEvent actionEvent) {

    }
    public void productRemoveItemOnAction(ActionEvent actionEvent) {

    }
    public void deliveryRemoveItemOnAction(ActionEvent actionEvent) {

    }
    public void deliveryAddToCartOnAction(ActionEvent actionEvent) {

    }

    ObservableList<CartTM> tmListCart = FXCollections.observableArrayList();

    public void addToCartOnAction(ActionEvent actionEvent) {
        double plantUnitPrice = Double.parseDouble(txtplantUnitPrice.getText());
        double productUnitPrice = Double.parseDouble(txtProductUnitPrice.getText());
        int plantQty = Integer.parseInt(txtPlantQty.getText());
        int productQty = Integer.parseInt(txtProductQty.getText());
        double deliveryCost = Double.parseDouble(txtHireCost.getText());
        double totalCost = ((plantUnitPrice * plantQty) + (productUnitPrice * productQty) + deliveryCost);

            Button btn = new Button("Delete");

            CartTM tm = new CartTM(
                    cmbPlantCode.getValue(),
                    cmbProductCode.getValue(),
                    txtplantUnitPrice.getText(),
                    txtProductUnitPrice.getText(),
                    txtPlantQty.getText(),
                    txtProductQty.getText(),
                    txtHireCost.getText(),
                    totalCost,
                    btn
            );

    }

    public void RemoveItemOnAction(ActionEvent actionEvent) {

    }
    public void openNewCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/NewCustomerForm.fxml"))));
        stage.show();
    }

    //-----------------------------------------------------------

}

