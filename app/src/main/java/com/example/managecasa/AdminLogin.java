package com.example.managecasa;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class AdminLogin extends AppCompatActivity {

    EditText t1,t2;

    int counter=0;
    Button b1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        t1=(EditText)findViewById(R.id.login_username);
        t2=(EditText)findViewById(R.id.login_password);

        b1=(Button)findViewById(R.id.login_button);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                            if(t1.getText().toString().trim().equals("admin") && t2.getText().toString().trim().equals("admin")){

                                Intent intent=new Intent(AdminLogin.this,User_Navigation.class);
                                startActivity(intent);

                                Toast.makeText(AdminLogin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(AdminLogin.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }


            }
        });

    }
}