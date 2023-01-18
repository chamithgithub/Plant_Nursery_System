package controller;

import model.Customer;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerCrudController {
    public static ArrayList<String> getCustomerIds() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT id FROM customer");
        ArrayList<String> ids= new ArrayList<>();
        while (result.next()){
            ids.add(result.getString(1));
        }
        return ids;
    }

    public static Customer getCustomer(String id) throws SQLException, ClassNotFoundException {
        ResultSet result= CrudUtil.execute("SELECT * FROM customer WHERE id=?", id);
        if (result.next()){
            return new Customer(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
            );
        }
        return null;
    }
}
