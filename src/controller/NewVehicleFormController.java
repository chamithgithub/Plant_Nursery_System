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
import model.Driver;
import model.Vehicle;
import util.CrudUtil;
import util.ValidationUtil;
import views.tm.DriverTM;
import views.tm.VehicleTM;

import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class NewVehicleFormController implements Initializable {

    public TextField txtVlId;
    public TextField txtVlBrand;
    public TextField txtVlType;
    public TextField txtVlNumber;
    public TableView<VehicleTM> tblVehicle;
    public TableColumn colVlId;
    public TableColumn colVlType;
    public TableColumn colVlBrand;
    public TableColumn colVlNumber;
    public TableColumn colVlBtn;
    public JFXButton btnAddVehicle;
    LinkedHashMap<TextField, Pattern> map = new LinkedHashMap<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Initializing table columns with TableTM Properties
        tblVehicle.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("vehicleId"));
        tblVehicle.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("vehicleBrand"));
        tblVehicle.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        tblVehicle.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("vehicleNumberPlate"));

        //set edit and delete button from images to the table
        tblVehicle.getColumns().get(4).setCellValueFactory((param) -> {
            ImageView edit = new ImageView("/assert/icons/draw.png");
            ImageView delete = new ImageView("/assert/icons/trash.png");
            return new ReadOnlyObjectWrapper(new HBox(10, edit, delete));
        });


        //set click event for the Save Comment
        btnAddVehicle.setOnMouseClicked(event -> {
            //Gather information from inputs
            saveDriver();
        });

        btnAddVehicle.setDisable(true);

        //add pattern and text to the map
        //Create a pattern and compile it to use
        Pattern idPattern = Pattern.compile("^(Vl0-)[0-9]{3,5}$");
        Pattern namePattern = Pattern.compile("^[A-z ]{3,15}$");
        Pattern addressPattern = Pattern.compile("^[A-z0-9 ,/]{4,20}$");
        Pattern contractPattern = Pattern.compile("^[A-z0-9 ,-]{4,10}$");

        map.put(txtVlId,idPattern);
        map.put(txtVlBrand,namePattern);
        map.put(txtVlType,addressPattern);
        map.put(txtVlNumber,contractPattern);

    }

    private void saveDriver() {
        String driverId = txtVlId.getText();
        String driverName = txtVlBrand.getText();
        String driverLicenceId = txtVlType.getText();
        String driverContract = txtVlNumber.getText();


        // Add to the Table
        Button btn = new Button("Delete");

        VehicleTM vehicleTM = new VehicleTM(driverId,driverName,driverLicenceId,driverContract,btn);
        tblVehicle.getItems().add(vehicleTM);

        Vehicle vehicle = new Vehicle(
                txtVlId.getText(), txtVlBrand.getText(), txtVlType.getText(), txtVlNumber.getText()
        );
        try {
            if (CrudUtil.execute("INSERT INTO Vehicle VALUES (?,?,?,?)", vehicle.getVehicleId(), vehicle.getVehicleBrand(), vehicle.getVehicleType(), vehicle.getVehicleNumberPlate())) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

        }


        clearAllTexts();
    }

    public void textFields_Key_Released(KeyEvent keyEvent) {
        ValidationUtil.validate(map,btnAddVehicle);
//        TextField = error
//        boolean // validation ok

        //if the enter key pressed
        if (keyEvent.getCode() == KeyCode.ENTER) {
            Object response =  ValidationUtil.validate(map,btnAddVehicle);;
            //if the response is a text field
            //that means there is a error
            if (response instanceof TextField) {
                TextField textField = (TextField) response;
                textField.requestFocus();// if there is a error just focus it
            } else if (response instanceof Boolean) {
                System.out.println("Work");
                saveDriver();
            }
        }
    }

    public void clearAllTexts() {
        txtVlId.clear();
        txtVlBrand.clear();
        txtVlType.clear();
        txtVlNumber.clear();
        txtVlId.requestFocus();
        setBorders(txtVlId,txtVlBrand,txtVlType,txtVlNumber);
    }

    //reset border colors to default color
    public void setBorders(TextField... textFields){
        for (TextField textField : textFields) {
            textField.getParent().setStyle("-fx-border-color: rgba(76, 73, 73, 0.83)");
        }
    }
}
