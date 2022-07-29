package com.employeepayroll;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollDBServices {
    private PreparedStatement employeePayrollDataStatment;
    private static EmployeePayrollDBServices employeePayrollDBServices;

    private EmployeePayrollDBServices() {
    }

    public static EmployeePayrollDBServices getInstance(){
        if (employeePayrollDBServices == null)
            employeePayrollDBServices = new EmployeePayrollDBServices();
        return employeePayrollDBServices;
    }
    public List<EmployeePayrollData> readData() {
        String sql = "select * from employee_payroll";
        List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
        try (Connection connection = this.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            employeePayrollDataList = this.getEmployeePayrollData(resultSet);
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

    public int updateEmployeeData(String name, double salary) {
        return updateEmployeeDataUsingStatement(name,salary);
    }

    private int updateEmployeeDataUsingStatement(String name, double salary) {
        String sql = String.format("update  employee_payroll set salary = %.2f where name = '%s';", salary,name);
        try (Connection connection = this.getConnection()){
            Statement statement = connection.createStatement();
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<EmployeePayrollData> getEmployeePayrollData(String name) {
        List<EmployeePayrollData> employeePayrollList = null;
        if(this.employeePayrollDataStatment == null)
            this.prepareStatementForEmployeeData();
        try{
            employeePayrollDataStatment.setString(1,name);
            ResultSet resultSet = employeePayrollDataStatment.executeQuery();
            employeePayrollList = this.getEmployeePayrollData(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeePayrollList;
    }

    private List<EmployeePayrollData> getEmployeePayrollData(ResultSet resultSet) {
        List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        try {
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getInt("salary");
                LocalDate date = resultSet.getDate("start").toLocalDate();
                employeePayrollList.add(new EmployeePayrollData(id, name, salary, date));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeePayrollList;
    }

    private void prepareStatementForEmployeeData() {
        try {
            Connection connection = this.getConnection();
            String sql = "select * from employee_payroll where name = ?";
            employeePayrollDataStatment = connection.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
