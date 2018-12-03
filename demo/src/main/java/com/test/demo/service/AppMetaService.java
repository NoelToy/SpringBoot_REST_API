package com.test.demo.service;

import com.test.demo.dbMeta.dbMeta;
import com.test.demo.model.City;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

@Service
public class AppMetaService {

    public HashMap<Integer, City> getCustomerList() throws SQLException
    {
        int i=0;
        String query1="Select * public.city";
        Connection connection = null;
        connection= dbMeta.getDbConnection();
        PreparedStatement queryStatement1 = connection.prepareStatement(query1);
        ResultSet result1 = queryStatement1.executeQuery();
        connection.close();
        HashMap<Integer, City> cityList = new HashMap<Integer, City>();
        while (result1.next())
        {
            City newCity = new City(result1.getString(1));
            cityList.put(i,newCity);
            i++;

        }
        return cityList;
    }

}
