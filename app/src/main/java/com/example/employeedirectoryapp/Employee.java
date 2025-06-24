package com.example.employeedirectoryapp;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Employee {
@PrimaryKey
@NonNull
    public  String employeeId;
    String employeeName;
    String password;
    double salary;
    String dateOfJoining,role,department;


    public Employee(String employeeId, String employeeName, String password, double salary, String dateOfJoining, String role, String department) {

        this.employeeId = employeeId;
       this.employeeName  = employeeName;
        this.password = password;
        this.salary = salary;
        this.dateOfJoining = dateOfJoining;
        this.role = role;
        this.department = department;
    }
}

