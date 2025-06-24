package com.example.employeedirectoryapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EmployeeDao {
    @Insert
    void insert(Employee employee);

    @Query("SELECT * FROM Employee WHERE employeeName = :name AND password = :password")
    Employee login(String name, String password);  // variable names match here

    @Query("SELECT * FROM Employee")
    List<Employee> getAllEmployees();
}
