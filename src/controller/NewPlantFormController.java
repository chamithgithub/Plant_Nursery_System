package controller;

import com.jfoenix.controls.JFXButton;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import model.Customer;
import model.Plant;
import util.CrudUtil;
import util.ValidationUtil;
import views.tm.CustomerTM;
import views.tm.PlantTM;

import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class NewPlantFormController implements Initializable {
    public TextField txtPlId;
    public TextField txtPlName;
    public TextField txtPlType;
    public TextField txtPlDescription;
    public TextField txtPlUnitPrice;
    public TextField txtPlQtyOnHand;
    public TableView<PlantTM> tblPlant;
    public TableColumn colPlId;
    public TableColumn colPlName;
    public TableColumn colPlType;
    public TableColumn colPlDesc;
    public TableColumn colPlUnitPrice;
    public TableColumn colPlQtyOnHand;
    public TableColumn colPlBtn;
    public JFXButton btnAddPlant;
    LinkedHashMap<TextField, Pattern> map = new LinkedHashMap<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Initializing table columns with TableTM Properties
        tblPlant.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("plantId"));
        tblPlant.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("plantName"));
        tblPlant.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("plantType"));
        tblPlant.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("plantDescription"));
        tblPlant.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("plantUnitPrice"));
        tblPlant.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("plantQtyOnHand"));

        //set edit and delete button from images to the table
        tblPlant.getColumns().get(6).setCellValueFactory((param) -> {
            ImageView edit = new ImageView("/assert/icons/draw.png");
            ImageView delete = new ImageView("/assert/icons/trash.png");
            return new ReadOnlyObjectWrapper(new HBox(10, edit, delete));
        });


        //set click event for the Save Comment
        btnAddPlant.setOnMouseClicked(event -> {
            //Gather information from inputs
            savePlant();
        });

        btnAddPlant.setDisable(true);

        //add pattern and text to the map
        //Create a pattern and compile it to use
        Pattern idPattern = Pattern.compile("^(Pl0-)[0-9]{3,5}$");
        Pattern namePattern = Pattern.compile("^[A-z ]{3,15}$");
        Pattern typePattern = Pattern.compile("^[A-z0-9 ,/]{4,20}$");
        Pattern descPattern = Pattern.compile("^[A-z0-9 ,/]{4,20}$");
        Pattern pricePattern = Pattern.compile("^[1-9][0-9]*(.[0-9]{2})?$");
        Pattern qtyOnPattern = Pattern.compile("^[0-9]{1,6}");

        map.put(txtPlId,idPattern);
        map.put(txtPlName,namePattern);
        map.put(txtPlType,typePattern);
        map.put(txtPlDescription,descPattern);
        map.put(txtPlUnitPrice,pricePattern);
        map.put(txtPlQtyOnHand,qtyOnPattern);

    }
    private void savePlant() {
        String plantId = txtPlId.getText();
        String plantName = txtPlName.getText();
        String plantType = txtPlType.getText();
        String plantDescription = txtPlDescription.getText();
        String plantUnitPrice = txtPlUnitPrice.getText();
        String plantQtyOnHand = txtPlQtyOnHand.getText();


        // Add to the Table
        Button btnPl = new Button("Delete");

        PlantTM plantTM = new PlantTM(plantId,plantName,plantType,plantDescription,plantUnitPrice,plantQtyOnHand,btnPl);
        tblPlant.getItems().add(plantTM);

        Plant plant = new Plant(
                txtPlId.getText(), txtPlName.getText(), txtPlType.getText(), txtPlDescription.getText(),txtPlUnitPrice.getText(), txtPlQtyOnHand.getText()
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


        clearAllTexts();
    }

    public void textFields_Key_Released(KeyEvent keyEvent) {
        ValidationUtil.validate(map,btnAddPlant);
//        TextField = error
//        boolean // validation ok

        //if the enter key pressed
        if (keyEvent.getCode() == KeyCode.ENTER) {
            Object response =  ValidationUtil.validate(map,btnAddPlant);;
            //if the response is a text field
            //that means there is a error
            if (response instanceof TextField) {
                TextField textField = (TextField) response;
                textField.requestFocus();// if there is a error just focus it
            } else if (response instanceof Boolean) {
                System.out.println("Work");
                savePlant();
            }
        }

    }
    public void clearAllTexts() {
        txtPlId.clear();
        txtPlName.clear();
        txtPlType.clear();
        txtPlDescription.clear();
        txtPlUnitPrice.clear();
        txtPlQtyOnHand.clear();
        txtPlId.requestFocus();
        setBorders(txtPlId,txtPlName,txtPlType,txtPlDescription,txtPlUnitPrice,txtPlQtyOnHand);
    }

    //reset border colors to default color
    public void setBorders(TextField... textFields){
        for (TextField textField : textFields) {
            textField.getParent().setStyle("-fx-border-color: rgba(76, 73, 73, 0.83)");
        }
    }
}
