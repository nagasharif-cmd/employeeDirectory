package com.example.employeedirectoryapp;

import android.os.Bundle;
import android.widget.EditText;

public class DashboardActivity extends AddEmployeeActivity {
    EditText editTextSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        editTextSearch = findViewById(R.id.editTextSearch);
    }

}
