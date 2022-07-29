package com.employeepayroll;

import java.time.LocalDate;

public class EmployeePayrollData {
   private int id;
   private String name;
   private double salary;

   private LocalDate start;

    public EmployeePayrollData(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public EmployeePayrollData(int id, String name, double salary, LocalDate start) {
        this(id, name, salary);
        this.start = start;
    }

    public LocalDate getStart(String date) {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString(){
       return "id= "+id+", name= "+name+", salary= "+salary+", date= "+ start;
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeePayrollData that = (EmployeePayrollData) o;
        return id == that.id && Double.compare(that.salary, salary) == 0 && name.equals(that.name) && start.equals(that.start);
    }

}
