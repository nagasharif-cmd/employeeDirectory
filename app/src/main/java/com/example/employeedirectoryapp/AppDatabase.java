package com.example.employeedirectoryapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Employee.class},version = 1)
public  abstract  class AppDatabase extends RoomDatabase {
    public  abstract EmployeeDao employeeDao();

    public static class DashboardActivity {
    }
}
