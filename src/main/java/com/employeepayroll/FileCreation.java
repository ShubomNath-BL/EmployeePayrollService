package com.employeepayroll;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

/*In code below file and directory has been created.
* First we created two method, one is for creating file and another method
* is for creating directory.
*/
public class FileCreation {
//    below method is for creating file.
    public void createFile() {
//        path has been given for file creation.
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
    //    below method is for creating directory.
    public static void createDirectory() throws IOException {
//      path has been given for creation of directory.
        Path newPath= Paths.get("C:\\Users\\Lenovo\\IdeaProjects\\EmployeePayrollService\\src\\tempo");
        Files.createDirectory(newPath);
    }

}
