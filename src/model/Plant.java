package model;

import javafx.scene.control.Button;

public class Plant {
     private String plantId;
     private String plantName;
     private String plantType;
     private String plantDescription ;
     private String plantUnitPrice;
     private String plantQtyOnHand ;



    public Plant() {
    }


    public Plant(String plantId, String plantName, String plantType, String plantDescription, String plantUnitPrice, String plantQtyOnHand) {
        this.plantId = plantId;
        this.plantName = plantName;
        this.plantType = plantType;
        this.plantDescription = plantDescription;
        this.plantUnitPrice = plantUnitPrice;
        this.plantQtyOnHand = plantQtyOnHand;
    }


    public String getPlantId() {
        return plantId;
    }

    public void setPlantId(String plantId) {
        this.plantId = plantId;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantType() {
        return plantType;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType;
    }

    public String getPlantDescription() {
        return plantDescription;
    }

    public void setPlantDescription(String plantDescription) {
        this.plantDescription = plantDescription;
    }

    public String getPlantUnitPrice() {
        return plantUnitPrice;
    }

    public void setPlantUnitPrice(String plantUnitPrice) {
        this.plantUnitPrice = plantUnitPrice;
    }

    public String getPlantQtyOnHand() {
        return plantQtyOnHand;
    }

    public void setPlantQtyOnHand(String plantQtyOnHand) {
        this.plantQtyOnHand = plantQtyOnHand;
    }

    @Override
    public String toString() {
        return "plant{" +
                "plantId='" + plantId + '\'' +
                ", plantName='" + plantName + '\'' +
                ", plantType='" + plantType + '\'' +
                ", plantDescription='" + plantDescription + '\'' +
                ", plantUnitPrice='" + plantUnitPrice + '\'' +
                ", plantQtyOnHand='" + plantQtyOnHand + '\'' +
                '}';
    }
}
