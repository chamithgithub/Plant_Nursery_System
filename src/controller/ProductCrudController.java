package controller;


import model.Product;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductCrudController {
        public static ArrayList<String> getProductIds() throws SQLException, ClassNotFoundException {
            ResultSet result = CrudUtil.execute("SELECT productId FROM Product");
            ArrayList<String> ids= new ArrayList<>();
            while (result.next()){
                ids.add(result.getString(1));
            }
            System.out.println(ids);
            return ids;
        }

        public static Product getProduct(String productId) throws SQLException, ClassNotFoundException {
            ResultSet result= CrudUtil.execute("SELECT * FROM product WHERE productId=?", productId);
            System.out.println(productId);
            if (result.next()){
                return new Product(
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6)
                );
            }
            return null;
        }
    }

