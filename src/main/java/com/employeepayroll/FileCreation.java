package com.employeepayroll;

import java.io.File;
import java.io.IOException;

public class FileCreation {
    public void createFile() {
        File file=new File("C:\\Users\\Lenovo\\IdeaProjects\\EmployeePayrollService\\src\\test.txt");
        try{
            if(file.createNewFile()){
                System.out.println("File created: "+file.getName());
            }else {
                System.out.println("File exist: "+file.getName());
            }
        }catch (IOException e){
            System.out.println("Error is: "+ e);
        }

    }
}
