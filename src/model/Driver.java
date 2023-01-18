package model;

public class Driver {
      private String driverId;
      private String driverName;
      private String driverLicenceId;
      private String driverContract ;

    public Driver() {
    }

    public Driver(String driverId, String driverName, String driverLicenceId, String driverContract) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.driverLicenceId = driverLicenceId;
        this.driverContract = driverContract;
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

    @Override
    public String toString() {
        return "Driver{" +
                "driverId='" + driverId + '\'' +
                ", driverName='" + driverName + '\'' +
                ", driverLicenceId='" + driverLicenceId + '\'' +
                ", driverContract='" + driverContract + '\'' +
                '}';
    }
}
