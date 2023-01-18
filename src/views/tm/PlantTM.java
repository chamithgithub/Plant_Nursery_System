package views.tm;

import javafx.scene.control.Button;

public class PlantTM {
    private String plantId;
    private String plantName;
    private String plantType;
    private String plantDescription ;
    private String plantUnitPrice;
    private String plantQtyOnHand ;
    private Button btnPl;

    public PlantTM() {
    }

    public PlantTM(String plantId, String plantName, String plantType, String plantDescription, String plantUnitPrice, String plantQtyOnHand, Button btnPl) {
        this.plantId = plantId;
        this.plantName = plantName;
        this.plantType = plantType;
        this.plantDescription = plantDescription;
        this.plantUnitPrice = plantUnitPrice;
        this.plantQtyOnHand = plantQtyOnHand;
        this.btnPl = btnPl;
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

    public Button getBtnPl() {
        return btnPl;
    }

    public void setBtnPl(Button btnPl) {
        this.btnPl = btnPl;
    }

    @Override
    public String toString() {
        return "plantCartTm{" +
                "plantId='" + plantId + '\'' +
                ", plantName='" + plantName + '\'' +
                ", plantType='" + plantType + '\'' +
                ", plantDescription='" + plantDescription + '\'' +
                ", plantUnitPrice='" + plantUnitPrice + '\'' +
                ", plantQtyOnHand='" + plantQtyOnHand + '\'' +
                ", btnPl=" + btnPl +
                '}';
    }
}
