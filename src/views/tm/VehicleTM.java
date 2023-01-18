package views.tm;

import javafx.scene.control.Button;

public class VehicleTM {
    private String vehicleId;
    private String vehicleBrand;
    private String vehicleType;
    private String vehicleNumberPlate;
    private Button btnVl;

    public VehicleTM() {
    }

    public VehicleTM(String vehicleId, String vehicleBrand, String vehicleType, String vehicleNumberPlate, Button btnVl) {
        this.vehicleId = vehicleId;
        this.vehicleBrand = vehicleBrand;
        this.vehicleType = vehicleType;
        this.vehicleNumberPlate = vehicleNumberPlate;
        this.btnVl = btnVl;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumberPlate() {
        return vehicleNumberPlate;
    }

    public void setVehicleNumberPlate(String vehicleNumberPlate) {
        this.vehicleNumberPlate = vehicleNumberPlate;
    }

    public Button getBtnVl() {
        return btnVl;
    }

    public void setBtnVl(Button btnVl) {
        this.btnVl = btnVl;
    }

    @Override
    public String toString() {
        return "VehicleTM{" +
                "vehicleId='" + vehicleId + '\'' +
                ", vehicleBrand='" + vehicleBrand + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", vehicleNumberPlate='" + vehicleNumberPlate + '\'' +
                ", btnVl=" + btnVl +
                '}';
    }
}
