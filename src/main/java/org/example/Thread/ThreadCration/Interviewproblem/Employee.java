package org.example.Thread.ThreadCration.Interviewproblem;

import java.time.LocalDate;
import java.util.List;

public class Employee extends Abstractperson implements Employeedetails{

    private double salary;
    private LocalDate dob;
    private Spouse spouse;
    private List<Parent> parentList;
    private List<Child> childList;
    @Override
    public double getSalary() {
        return 0;
    }

    @Override
    public LocalDate dob() {
        return null;
    }

    @Override
    public String getFirstname() {
        return "";
    }

    @Override
    public String getlastname() {
        return "";
    }

    @Override
    public int getage() {
        return 0;
    }

    @Override
    public Address getAddress() {
        return null;
    }
}
