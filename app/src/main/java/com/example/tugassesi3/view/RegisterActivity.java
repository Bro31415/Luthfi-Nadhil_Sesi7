package com.example.tugassesi3.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.tugassesi3.R;

public class RegisterActivity extends AppCompatActivity {
    EditText regEmail, regUname, regPass;
    Button register, toLog;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regEmail =findViewById(R.id.regEmail);
        regUname = findViewById(R.id.regUName);
        regPass = findViewById(R.id.regPass);
        register = findViewById(R.id.buttonReg);
        toLog = findViewById(R.id.buttontoLog);

        sharedPref = getSharedPreferences("account", MODE_PRIVATE);

        register.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("account_email", regEmail.getText().toString());
            editor.putString("account_username", regUname.getText().toString());
            editor.putString("account_password", regPass.getText().toString());
            editor.apply();
            Toast.makeText(RegisterActivity.this, "Your account has been successfully registered!", Toast.LENGTH_SHORT).show();
        });
        toLog.setOnClickListener(v -> {
            Intent toLogIntent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(toLogIntent);
        });

    }
}