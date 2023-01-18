package views.tm;

import javafx.scene.control.Button;

public class CartTM {
    private String PlantIdTm;
    private String ProductIdTm;
    private double PlantUnitPriceTm;
    private double ProductUnitPriceTm;
    private int PlantQtyTm;
    private int ProductQtyTm;
    private double DeliveryCostTm;
    private double TotalCostTm;
    private Button btn;

    public CartTM(Object value, Object cmbProductCodeValue, String text, String txtProductUnitPriceText, String txtPlantQtyText, String txtProductQtyText, String txtHireCostText, double totalCost, Button btn) {
    }

    public CartTM(String plantIdTm, String productIdTm, double plantUnitPriceTm, double productUnitPriceTm, int plantQtyTm, int productQtyTm, double deliveryCostTm, double totalCostTm, Button btn) {
        PlantIdTm = plantIdTm;
        ProductIdTm = productIdTm;
        PlantUnitPriceTm = plantUnitPriceTm;
        ProductUnitPriceTm = productUnitPriceTm;
        PlantQtyTm = plantQtyTm;
        ProductQtyTm = productQtyTm;
        DeliveryCostTm = deliveryCostTm;
        TotalCostTm = totalCostTm;
        this.btn = btn;
    }

    public String getPlantIdTm() {
        return PlantIdTm;
    }

    public void setPlantIdTm(String plantIdTm) {
        PlantIdTm = plantIdTm;
    }

    public String getProductIdTm() {
        return ProductIdTm;
    }

    public void setProductIdTm(String productIdTm) {
        ProductIdTm = productIdTm;
    }

    public double getPlantUnitPriceTm() {
        return PlantUnitPriceTm;
    }

    public void setPlantUnitPriceTm(double plantUnitPriceTm) {
        PlantUnitPriceTm = plantUnitPriceTm;
    }

    public double getProductUnitPriceTm() {
        return ProductUnitPriceTm;
    }

    public void setProductUnitPriceTm(double productUnitPriceTm) {
        ProductUnitPriceTm = productUnitPriceTm;
    }

    public int getPlantQtyTm() {
        return PlantQtyTm;
    }

    public void setPlantQtyTm(int plantQtyTm) {
        PlantQtyTm = plantQtyTm;
    }

    public int getProductQtyTm() {
        return ProductQtyTm;
    }

    public void setProductQtyTm(int productQtyTm) {
        ProductQtyTm = productQtyTm;
    }

    public double getDeliveryCostTm() {
        return DeliveryCostTm;
    }

    public void setDeliveryCostTm(double deliveryCostTm) {
        DeliveryCostTm = deliveryCostTm;
    }

    public double getTotalCostTm() {
        return TotalCostTm;
    }

    public void setTotalCostTm(double totalCostTm) {
        TotalCostTm = totalCostTm;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "CartTM{" +
                "PlantIdTm='" + PlantIdTm + '\'' +
                ", ProductIdTm='" + ProductIdTm + '\'' +
                ", PlantUnitPriceTm=" + PlantUnitPriceTm +
                ", ProductUnitPriceTm=" + ProductUnitPriceTm +
                ", PlantQtyTm=" + PlantQtyTm +
                ", ProductQtyTm=" + ProductQtyTm +
                ", DeliveryCostTm=" + DeliveryCostTm +
                ", TotalCostTm=" + TotalCostTm +
                ", btn=" + btn +
                '}';
    }
}
