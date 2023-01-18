package views.tm;

import javafx.scene.control.Button;

public class DriverTM {
    private String driverId;
    private String driverName;
    private String driverLicenceId;
    private String driverContract ;
    private Button btn;

    public DriverTM() {
    }

    public DriverTM(String driverId, String driverName, String driverLicenceId, String driverContract, Button btn) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.driverLicenceId = driverLicenceId;
        this.driverContract = driverContract;
        this.btn = btn;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverLicenceId() {
        return driverLicenceId;
    }

    public void setDriverLicenceId(String driverLicenceId) {
        this.driverLicenceId = driverLicenceId;
    }

    public String getDriverContract() {
        return driverContract;
    }

    public void setDriverContract(String driverContract) {
        this.driverContract = driverContract;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "DriverTM{" +
                "driverId='" + driverId + '\'' +
                ", driverName='" + driverName + '\'' +
                ", driverLicenceId='" + driverLicenceId + '\'' +
                ", driverContract='" + driverContract + '\'' +
                ", btn=" + btn +
                '}';
    }
}
