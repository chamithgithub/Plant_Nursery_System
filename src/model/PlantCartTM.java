package model;

import javafx.scene.control.Button;

public class PlantCartTM {

    private String plantCode;
    private String PlantDescription;
    private double PlantUnitPrice;
    private int PlantQty;
    private double PlantTotalCost;
    private Button PlantBtn;

    public PlantCartTM() {
    }

    public PlantCartTM(String plantCode, String plantDescription, double plantUnitPrice, int plantQty, double plantTotalCost, Button plantBtn) {
        this.plantCode = plantCode;
        PlantDescription = plantDescription;
        PlantUnitPrice = plantUnitPrice;
        PlantQty = plantQty;
        PlantTotalCost = plantTotalCost;
        PlantBtn = plantBtn;
    }

    public String getPlantCode() {
        return plantCode;
    }

    public void setPlantCode(String plantCode) {
        this.plantCode = plantCode;
    }

    public String getPlantDescription() {
        return PlantDescription;
    }

    public void setPlantDescription(String plantDescription) {
        PlantDescription = plantDescription;
    }

    public double getPlantUnitPrice() {
        return PlantUnitPrice;
    }

    public void setPlantUnitPrice(double plantUnitPrice) {
        PlantUnitPrice = plantUnitPrice;
    }

    public int getPlantQty() {
        return PlantQty;
    }

    public void setPlantQty(int plantQty) {
        PlantQty = plantQty;
    }

    public double getPlantTotalCost() {
        return PlantTotalCost;
    }

    public void setPlantTotalCost(double plantTotalCost) {
        PlantTotalCost = plantTotalCost;
    }

    public Button getPlantBtn() {
        return PlantBtn;
    }

    public void setPlantBtn(Button plantBtn) {
        PlantBtn = plantBtn;
    }

    @Override
    public String toString() {
        return "PlantCartTM{" +
                "plantCode='" + plantCode + '\'' +
                ", PlantDescription='" + PlantDescription + '\'' +
                ", PlantUnitPrice=" + PlantUnitPrice +
                ", PlantQty=" + PlantQty +
                ", PlantTotalCost=" + PlantTotalCost +
                ", PlantBtn=" + PlantBtn +
                '}';
    }
}
