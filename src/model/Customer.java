package model;

public class Customer {
       private String customerId;
       private String customerName;
       private String customerAddress;
       private String customerContract ;

    public Customer() {
    }

    public Customer(String customerId, String customerName, String customerAddress, String customerContract) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerContract = customerContract;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerContract() {
        return customerContract;
    }

    public void setCustomerContract(String customerContract) {
        this.customerContract = customerContract;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerContract='" + customerContract + '\'' +
                '}';
    }
}
