package model;

public class Order {
     private String orderId;
     private String orderDate;
     private String orderCustomerId;

    public Order() {
    }

    public Order(String orderId, String orderDate, String orderCustomerId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderCustomerId = orderCustomerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderCustomerId() {
        return orderCustomerId;
    }

    public void setOrderCustomerId(String orderCustomerId) {
        this.orderCustomerId = orderCustomerId;
    }
}

