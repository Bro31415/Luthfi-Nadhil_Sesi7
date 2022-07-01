package com.example.tugassesi3.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tugassesi3.R;

public class LoginActivity extends AppCompatActivity {
    Button login, toReg;
    EditText loginUName, loginPass;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.btnLog);
        toReg = findViewById(R.id.btntoReg);
        loginUName = findViewById(R.id.logUName);
        loginPass = findViewById(R.id.logPass);
        sharedPref = getSharedPreferences("account", MODE_PRIVATE);

        login.setOnClickListener(v ->{
            if (!loginUName.getText().toString().equals(sharedPref.getString("account_username", ""))) {
                Toast.makeText(LoginActivity.this, "Username Invalid", Toast.LENGTH_SHORT).show();
            } else if(!loginPass.getText().toString().equals(sharedPref.getString("account_password", ""))) {
                Toast.makeText(LoginActivity.this, "Password Invalid", Toast.LENGTH_SHORT).show();
            } else if(loginUName.getText().toString().equals(sharedPref.getString("account_username", ""))
                    && loginPass.getText().toString().equals(sharedPref.getString("account_password", ""))){
                Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
                loginIntent.putExtra("account_username", sharedPref.getString("account_username", ""));
                startActivity(loginIntent);
            }
        });
        toReg.setOnClickListener(v -> {
            Intent toRegIntent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(toRegIntent);
        });
    }
}