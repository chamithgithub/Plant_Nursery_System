package controller;
import model.Delivery;

import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeliveryCrudController {
    public static ArrayList<String> getDeliveryIds() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT deliveryId FROM Delivery");
        ArrayList<String> ids= new ArrayList<>();
        while (result.next()){
            ids.add(result.getString(1));
        }
        System.out.println(ids);
        return ids;
    }

    public static Delivery getDelivery(String deliveryId) throws SQLException, ClassNotFoundException {
        ResultSet result= CrudUtil.execute("SELECT * FROM delivery WHERE deliveryId=?", deliveryId);
        System.out.println(deliveryId);
        if (result.next()){
            return new Delivery(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)

            );
        }
        return null;
    }
}
