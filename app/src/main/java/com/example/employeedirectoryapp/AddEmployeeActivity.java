package com.example.employeedirectoryapp;
import  android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class AddEmployeeActivity  extends  AppCompatActivity{
    protected   void onCreate(Bundle savedInstanceState)
    {
        EditText etNewEmployeeName,etCreatePassword,
                etRePassword,etNewEmployeeID,etRoleAssigned,
        etDepartment,etSalary, etDateOfJoining;
        Button btnSaveEmployee;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        etDepartment = findViewById(R.id.etDepartment);
        etCreatePassword =findViewById(R.id.etCreatePassword);
        etRePassword =findViewById(R.id.etRePassword);
        etSalary =findViewById(R.id.etSalary);
        etNewEmployeeID = findViewById(R.id.etNewEmployeeID);
        etRoleAssigned = findViewById(R.id.etRoleAssigned);
        etNewEmployeeName =findViewById(R.id.etNewEmployeeName);
etDateOfJoining = findViewById(R.id.etDateOfJoining);
btnSaveEmployee =findViewById(R.id.btnSaveEmployee);
btnSaveEmployee.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "employee-database").allowMainThreadQueries().build();
        EmployeeDao employeeDao = db.employeeDao();
        String name = etNewEmployeeName.getText().toString();
        String password = etCreatePassword.getText().toString();
        String salaryInput = etSalary.getText().toString();
        double salary = 0.0;
        if (!salaryInput.isEmpty()) {
            salary = Double.parseDouble(salaryInput);
        }

        String department = etDepartment.getText().toString();
        String employeeId = etNewEmployeeID.getText().toString();
        String role = etRoleAssigned.getText().toString();
        String rePassword = etRePassword.getText().toString();
        String dateOfJoining =etDateOfJoining.getText().toString();

        if(name.isEmpty() || password.isEmpty() || rePassword.isEmpty()  || role.isEmpty()  || department.isEmpty()  || employeeId.isEmpty()  || salaryInput.isEmpty() || dateOfJoining.isEmpty()) {
    Toast.makeText(AddEmployeeActivity.this, "please enter all the deatils ", Toast.LENGTH_SHORT).show();
}
if(!password.equals(rePassword))
{
    Toast.makeText(AddEmployeeActivity.this, "password mismatch", Toast.LENGTH_SHORT).show();
}

else {
    Toast.makeText(AddEmployeeActivity.this, "Details saved ", Toast.LENGTH_SHORT).show();
}
        Employee employee = new Employee(employeeId, name, password, salary, dateOfJoining, role, department);

        try {
            employeeDao.insert(employee);
            Toast.makeText(AddEmployeeActivity.this, "Employee Added Successfully!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(AddEmployeeActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
      //  Toast.makeText(AddEmployeeActivity.this, "details saved", Toast.LENGTH_SHORT).show();


    });

    }


}

