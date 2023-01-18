package controller;

import model.Customer;
import model.Plant;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlantCrudController {
    public static ArrayList<String> getPlantIds() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT plantId FROM plant");
        ArrayList<String> ids= new ArrayList<>();
        while (result.next()){
            ids.add(result.getString(1));
        }
        System.out.println(ids);
        return ids;
    }

    public static Plant getPlant(String plantId) throws SQLException, ClassNotFoundException {
        ResultSet result= CrudUtil.execute("SELECT * FROM plant WHERE plantId=?", plantId);
        System.out.println(plantId);
        if (result.next()){
            return new Plant(
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
