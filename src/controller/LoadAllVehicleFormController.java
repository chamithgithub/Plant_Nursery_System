package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Driver;
import model.Vehicle;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoadAllVehicleFormController {

    public TableView<Vehicle> tblVehicle;
    public TableColumn colId;
    public TableColumn colbrand;
    public TableColumn colvehicleType;
    public TableColumn colnumberPlate;

    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory<>("vehicleId"));
        colbrand.setCellValueFactory(new PropertyValueFactory<>("vehicleBrand"));
        colvehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colnumberPlate.setCellValueFactory(new PropertyValueFactory<>("vehicleNumberPlate"));


        try {
            loadAllVehicle();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    private void loadAllVehicle() throws ClassNotFoundException, SQLException {
        ResultSet result = CrudUtil.execute("SELECT * FROM vehicle");
        ObservableList<Vehicle> obList = FXCollections.observableArrayList();

        while (result.next()){
            obList.add(
                    new Vehicle(
                            result.getString(1),
                            result.getString(2),
                            result.getString(3),
                            result.getString(4)

                    )
            );
        }
        tblVehicle.setItems(obList);

    }

}
