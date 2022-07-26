package com.employeepayroll;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class EmployeePayrollUsingDataBase {

    public static void main(String[] args) {

        String jdbcURL="jdbc:mysql://localhost:3306/payroll_services?useSSL=false";
        String userName="root";
        String password="Shubom@88";
        Connection connection;
        try {
             Class.forName("com.mysql.jdbc.Driver");
             System.out.println("Driver loaded");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        listDrivers();
        try {
            System.out.println("Connecting "+jdbcURL);
            connection = DriverManager.getConnection(jdbcURL,userName,password);
            System.out.println("Successful");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void listDrivers(){
        Enumeration<Driver> driverList=DriverManager.getDrivers();
        while (driverList.hasMoreElements()){
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println(" "+driverClass.getClass().getName());
        }
    }
}
