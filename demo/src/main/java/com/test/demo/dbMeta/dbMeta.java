package com.test.demo.dbMeta;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbMeta {
    private static String host="localhost";
    private static String db="ABC_Shipping";
    private static String userName="postgres";
    private static String  password="admin";
    private static Integer port = 5432;

    public static Connection getDbConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db, userName,password);


        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return connection;
    }

}
