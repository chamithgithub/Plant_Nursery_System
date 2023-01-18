package model;

public class Product {
     private String productId;
     private String productName;
     private String productType;
     private String productDescription;
     private String productUnitPrice;
     private String productQtyOnHand ;

    public Product() {
    }

    public Product(String productId, String productName, String productType, String productDescription, String productUnitPrice, String productQtyOnHand) {
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.productDescription = productDescription;
        this.productUnitPrice = productUnitPrice;
        this.productQtyOnHand = productQtyOnHand;
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

    @Override
    public String toString() {
        return "product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productUnitPrice='" + productUnitPrice + '\'' +
                ", productQtyOnHand='" + productQtyOnHand + '\'' +
                '}';
    }
}
