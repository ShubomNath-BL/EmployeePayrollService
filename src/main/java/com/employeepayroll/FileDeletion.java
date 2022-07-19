package com.employeepayroll;

import java.io.File;

public class FileDeletion {
    public void deleteFile(){
        File file1 = new File("C:\\Users\\Lenovo\\IdeaProjects\\EmployeePayrollService\\src\\test.txt");
        if (file1.delete()){
            System.out.println(file1.getName()+" deleted");
        }else{
            System.out.println("failed");
            try {
                throw new Exception("already deleted");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
