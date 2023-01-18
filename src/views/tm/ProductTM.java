package views.tm;

import javafx.scene.control.Button;

public class ProductTM {
    private String productId;
    private String productName;
    private String productType;
    private String productDescription ;
    private String productUnitPrice;
    private String productQtyOnHand ;
    private Button btnPr;

    public ProductTM() {
    }

    public ProductTM(String productId, String productName, String productType, String productDescription, String productUnitPrice, String productQtyOnHand, Button btnPr) {
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.productDescription = productDescription;
        this.productUnitPrice = productUnitPrice;
        this.productQtyOnHand = productQtyOnHand;
        this.btnPr = btnPr;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductUnitPrice() {
        return productUnitPrice;
    }

    public void setProductUnitPrice(String productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

    public String getProductQtyOnHand() {
        return productQtyOnHand;
    }

    public void setProductQtyOnHand(String productQtyOnHand) {
        this.productQtyOnHand = productQtyOnHand;
    }

    public Button getBtnPr() {
        return btnPr;
    }

    public void setBtnPr(Button btnPr) {
        this.btnPr = btnPr;
    }

    @Override
    public String toString() {
        return "productCartTm{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productUnitPrice='" + productUnitPrice + '\'' +
                ", productQtyOnHand='" + productQtyOnHand + '\'' +
                ", btnPr=" + btnPr +
                '}';
    }
}
