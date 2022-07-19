package com.employeepayroll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCreationTest {

    @Test
    public void givenPathWhenCheckConfirmIfFileExist(){
        FileCreation fileCreation=new FileCreation();
        fileCreation.createFile();
        File file = new File("C:\\Users\\Lenovo\\IdeaProjects\\EmployeePayrollService\\src\\test.txt");
        boolean fileExist=file.exists();
        Assertions.assertTrue(fileExist);
    }
    @Test
    public void givenPathWhenCheckConfirmIfDirectoryExist() throws IOException {
        FileCreation fileCreation=new FileCreation();
        fileCreation.createDirectory();
        Assertions.assertTrue(Files.exists(Path.of("C:\\Users\\Lenovo\\IdeaProjects\\EmployeePayrollService\\src\\tempo")));
    }
}
