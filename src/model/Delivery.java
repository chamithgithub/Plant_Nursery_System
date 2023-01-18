package model;

public class Delivery {
    private String  deliveryId;
    private String location;
    private String description;
    private String hireCost;

    public Delivery() {
    }

    public Delivery(String deliveryId, String location, String description, String hireCost) {
        this.deliveryId = deliveryId;
        this.location = location;
        this.description = description;
        this.hireCost = hireCost;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHireCost() {
        return hireCost;
    }

    public void setHireCost(String hireCost) {
        this.hireCost = hireCost;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryId='" + deliveryId + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", hireCost='" + hireCost + '\'' +
                '}';
    }
}
