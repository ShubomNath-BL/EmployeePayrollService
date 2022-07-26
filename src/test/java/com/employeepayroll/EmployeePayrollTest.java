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
}
