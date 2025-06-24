package com.example.employeedirectoryapp;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


public class MainActivity  extends AppCompatActivity{
    EditText etEmployeeName,etPassword;
    Button btLogin;
    TextView tvNewEmployee;

@Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etEmployeeName = findViewById(R.id.etEmployeeName);
        etPassword =findViewById(R.id.etPassword);
        btLogin = findViewById(R.id.btLogin);
        tvNewEmployee = findViewById(R.id.tvNewEmployee);


        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etEmployeeName.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "employee-database").allowMainThreadQueries().build();

                EmployeeDao employeeDao = db.employeeDao();
                Employee employee = employeeDao.login(name, password);

                if(employee != null) {
                    Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvNewEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(MainActivity.this, AddEmployeeActivity.class);
                startActivity(i);
            }
        });

    }
}
