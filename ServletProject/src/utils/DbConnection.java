package utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by bmal on 5/27/16.
 */
public class DbConnection {

    private static Connection myConn;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/labproject";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";


    public static Connection getConnection(){
        if (myConn != null)
            return myConn;
        else {
            try {
                Class.forName(JDBC_DRIVER);

                String username = "root";
                String password = "root";
                String dbUrl = "jdbc:mysql://localhost:3306/labproject";
                myConn = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("myConn = " + myConn);
        System.out.println("Connected");
        return myConn;
    }
}
