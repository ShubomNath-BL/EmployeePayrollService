package com.employeepayroll;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
* The code below is to read and write employee data from console.
* First we created a list to store the data of employee in it such as ID, name & salary.
* Then created two methods, one is for reading the data and second one is
* for writing the data in the list.
* And then created the main method in which both method has been called so, that they
* get executed properly.
*/
public class EmployeePayrollServices {
    Scanner ConsoleInputReader = new Scanner(System.in);

    public List<EmployeePayrollData> employeePayrollDataList;


    public EmployeePayrollServices(ArrayList<EmployeePayrollData>employeePayrollDataList){
        this.employeePayrollDataList = employeePayrollDataList;
    }

    public enum IOServices{CONSOLE_IO, FILE_IO}
    public static void main(String[] args) {
        System.out.println("Welcome to Employee payroll services");
        ArrayList<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
        EmployeePayrollServices employeePayrollServices=new EmployeePayrollServices(employeePayrollDataList);
        employeePayrollServices.operations();
    }

    public void operations(){

        boolean change=true;
        do{
            System.out.println("\n Choose operations:-");
            System.out.println("1.Read & write\n2.Content count\n3.Exit");
            switch (ConsoleInputReader.nextInt()){
                case 1:
                    readEmployeePayrollData(ConsoleInputReader);
                    writeEmployeePayrollData();
                    break;
                case 2:
                    countContent();
                    break;
                case 3:
                    change=false;
                    System.out.println("Exiting");
            }
        }while (change);
    }

    public void readEmployeePayrollData(Scanner consoleReadInput){
        System.out.println("Enter Employee id: ");
        int id=consoleReadInput.nextInt();
        System.out.println("Enter Employee name: ");
        String name=consoleReadInput.next();
        System.out.println("Enter Employee salary");
        double salary=consoleReadInput.nextDouble();
        employeePayrollDataList.add(new EmployeePayrollData(id, name, salary));
    }
    public void writeEmployeePayrollData(){
        FileWriter file;
        try {
            file = new FileWriter("C:\\Users\\Lenovo\\IdeaProjects\\EmployeePayrollService\\src\\test.txt");
            for(EmployeePayrollData str: employeePayrollDataList){
                file.write(str + System.lineSeparator());
            }file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //System.out.println("\n Writing employee payroll roaster to console: "+ employeePayrollDataList);
    }
    public void countContent(){
        File file = new File("C:\\Users\\Lenovo\\IdeaProjects\\EmployeePayrollService\\src\\test.txt");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        int wordCount = 0;
        int lineCount = 0;
        try{
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals("")) {
                    lineCount += 1;
                }else {
                    String words[] = line.split("\\s+");
                    wordCount += words.length;
                }lineCount++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Numbers of line: "+ lineCount);
        System.out.println("Numbers of words: "+ wordCount);
    }
}
