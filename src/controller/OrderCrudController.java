package controller;

import model.Order;
import model.OrderDetails;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderCrudController {

    public boolean saveOrder(Order order) throws SQLException, ClassNotFoundException {
       return CrudUtil.execute("INSERT INTO Orders VALUES(?,?,?)",
                order.getOrderId(), order.getOrderDate(), order.getOrderCustomerId());
    }
    public boolean saveOrderDetails(ArrayList<OrderDetails> details) throws SQLException, ClassNotFoundException {
        for (OrderDetails det:details
             ) {
            boolean isDetailsSaved=CrudUtil.execute("INSERT INTO OrderDetail VALUES(?,?,?,?)",
                    det.getOrderId(),det.getItemCode(),det.getQty(),det.getUnitPrice());
            if (isDetailsSaved){
                if (!updateQty(det.getItemCode(), det.getQty())){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }

    private boolean updateQty(String itemCode, int qty) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Item SET qtyOnHand=qtyOnHand-? WHERE code=?", qty,itemCode);
    }
    public String getOrderId() throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.execute("SELECT id FROM Orders ORDER BY id DESC LIMIT 1");
        if (set.next()){
            return set.getString(1);
            /*-----D001-> D002----*/
        }else{
            return "D001";
        }
    }
}
