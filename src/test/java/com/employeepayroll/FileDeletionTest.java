package com.employeepayroll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class FileDeletionTest {
    @Test
    public void givenPathWhenCheckConfirmIfDeleted(){
        FileDeletion fileDeletion=new FileDeletion();
        File file=new File("C:\\Users\\Lenovo\\IdeaProjects\\EmployeePayrollService\\src\\test.txt");
        if(file.exists()){
            fileDeletion.deleteFile();
        }
        Assertions.assertFalse(file.exists());
    }
}
