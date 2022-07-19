package com.employeepayroll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class FileCreationTest {

    @Test
    public void givenPathWhenCheckConfirmIfExist(){
        FileCreation fileCreation=new FileCreation();
        fileCreation.createFile();
        File file = new File("C:\\Users\\Lenovo\\IdeaProjects\\EmployeePayrollService\\src\\test.txt");
        boolean fileExist=file.exists();
        Assertions.assertTrue(fileExist);
    }
}
