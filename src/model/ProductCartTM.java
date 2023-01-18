package model;

import javafx.scene.control.Button;

public class ProductCartTM {
    private String ProductCode;
    private String ProductDescription;
    private double ProductUnitPrice;
    private int ProductQty;
    private double ProductTotalCost;
    private Button ProductBtn;

    public ProductCartTM(Object value, String text, double unitPrice, int qty, double totalCost, Button btn) {
    }

    public ProductCartTM(String productCode, String productDescription, double productUnitPrice, int productQty, double productTotalCost, Button productBtn) {
        ProductCode = productCode;
        ProductDescription = productDescription;
        ProductUnitPrice = productUnitPrice;
        ProductQty = productQty;
        ProductTotalCost = productTotalCost;
        ProductBtn = productBtn;
    }

    public String getProductCode() {
        return ProductCode;
    }

    public void setProductCode(String productCode) {
        ProductCode = productCode;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }

    public double getProductUnitPrice() {
        return ProductUnitPrice;
    }

    public void setProductUnitPrice(double productUnitPrice) {
        ProductUnitPrice = productUnitPrice;
    }

    public int getProductQty() {
        return ProductQty;
    }

    public void setProductQty(int productQty) {
        ProductQty = productQty;
    }

    public double getProductTotalCost() {
        return ProductTotalCost;
    }

    public void setProductTotalCost(double productTotalCost) {
        ProductTotalCost = productTotalCost;
    }

    public Button getProductBtn() {
        return ProductBtn;
    }

    public void setProductBtn(Button productBtn) {
        ProductBtn = productBtn;
    }

    @Override
    public String toString() {
        return "ProductCartTM{" +
                "ProductCode='" + ProductCode + '\'' +
                ", ProductDescription='" + ProductDescription + '\'' +
                ", ProductUnitPrice=" + ProductUnitPrice +
                ", ProductQty=" + ProductQty +
                ", ProductTotalCost=" + ProductTotalCost +
                ", ProductBtn=" + ProductBtn +
                '}';
    }
}
