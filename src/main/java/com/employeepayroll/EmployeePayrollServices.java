package com.employeepayroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollServices {

    public List<EmployeePayrollData> employeePayrollDataList;


    public EmployeePayrollServices(ArrayList<EmployeePayrollData>employeePayrollDataList){
        this.employeePayrollDataList = employeePayrollDataList;
    }
    public enum IOServices{CONSOLE_IO, FILE_IO}
    public static void main(String[] args) {
        System.out.println("Welcome to Employee payroll services");
        ArrayList<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
        EmployeePayrollServices employeePayrollServices=new EmployeePayrollServices(employeePayrollDataList);
        Scanner ConsoleInputReader = new Scanner(System.in);
        employeePayrollServices.readEmployeePayrollData(ConsoleInputReader);
        employeePayrollServices.writeEmployeePayrollData();
    }

    private void readEmployeePayrollData(Scanner consoleReadInput){
        System.out.println("Enter Employee id: ");
        int id=consoleReadInput.nextInt();
        System.out.println("Enter Employee name: ");
        String name=consoleReadInput.next();
        System.out.println("Enter Employee salary");
        double salary=consoleReadInput.nextDouble();
        employeePayrollDataList.add(new EmployeePayrollData(id, name, salary));
    }
    private void writeEmployeePayrollData(){
        System.out.println("\n Writing employee payroll roaster to console: "+ employeePayrollDataList);
    }
}
