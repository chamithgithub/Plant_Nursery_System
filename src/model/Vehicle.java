package model;

public class Vehicle {
      private String vehicleId;
      private String vehicleBrand;
      private String vehicleType;
      private String vehicleNumberPlate;

    public Vehicle() {
    }

    public Vehicle(String vehicleId, String vehicleBrand, String vehicleType, String vehicleNumberPlate) {
        this.vehicleId = vehicleId;
        this.vehicleBrand = vehicleBrand;
        this.vehicleType = vehicleType;
        this.vehicleNumberPlate = vehicleNumberPlate;
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

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", vehicleBrand='" + vehicleBrand + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", vehicleNumberPlate='" + vehicleNumberPlate + '\'' +
                '}';
    }
}
