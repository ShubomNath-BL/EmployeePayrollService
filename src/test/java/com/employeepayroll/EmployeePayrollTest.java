package com.employeepayroll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.employeepayroll.EmployeePayrollServices.IOservice.DB_IO;

public class EmployeePayrollTest {
    @Test
    void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeCount() {
        EmployeePayrollServices employeePayrollServices = new EmployeePayrollServices();
        List<EmployeePayrollData> employeePayrollData = employeePayrollServices.readEmployeePayrollData(DB_IO);
        Assertions.assertEquals(3, employeePayrollData.size());
    }

    @Test
    void givenNameAndSalaryforEmployee_WhenUpdate_ShouldSyncWithDB() {
        EmployeePayrollServices employeePayrollServices = new EmployeePayrollServices();
        List<EmployeePayrollData> employeePayrollData = employeePayrollServices.readEmployeePayrollData(DB_IO);
        employeePayrollServices.updateSalary("Terisa", 300000.00);
        boolean result = employeePayrollServices.checkEmployeePayrollInSyncWithDB("Terisa");
        Assertions.assertTrue(result);
    }
}
