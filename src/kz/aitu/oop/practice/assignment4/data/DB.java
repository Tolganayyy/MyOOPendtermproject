package kz.aitu.oop.practice.assignment4.data;

import kz.aitu.oop.practice.assignment4.data.interfaces.IDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        //1.connection database
        String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
        try {
            // 2.Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");
            //3. establish the connection
            Connection con = DriverManager.getConnection(connectionUrl,"postgres","TLHNY520");
            return con;
        }catch (Exception e){
        System.out.println(e);
        return null;
        }
    }
}
