package com.employeepayroll;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EmployeePayrollDBServices {
    public List<EmployeePayrollData> readData() {
        String sql = "select * from employee_payroll";
        List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
        try (Connection connection = this.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getInt("salary");
                LocalDate date = resultSet.getDate("start").toLocalDate();
                employeePayrollDataList.add(new EmployeePayrollData(id, name, salary, date));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeePayrollDataList;
    }

    private Connection getConnection() throws SQLException {
        String jdbcURL="jdbc:mysql://localhost:3306/payroll_services?useSSL=false";
        String userName="root";
        String password="Shubom@88";
        Connection connection;
        System.out.println("Connecting "+jdbcURL);
        connection = DriverManager.getConnection(jdbcURL,userName,password);
        System.out.println("Successful");
        return connection;
    }
}
