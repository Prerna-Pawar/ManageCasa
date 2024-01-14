package com.example.managecasa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserSignup1 extends AppCompatActivity {
    EditText signupName, signupEmail, signupUsername, signupPassword,Flatno,Contactno;
    TextView loginRedirectText,Status;
    Button signupButton;
    FirebaseDatabase database;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signup1);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        signupName = findViewById(R.id.signup_name);
        signupEmail = findViewById(R.id.signup_email);
        signupUsername = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        signupButton = findViewById(R.id.signup_button);
        Status=(TextView)findViewById(R.id.status);
        Flatno=(EditText)findViewById(R.id.flatno);
        Contactno=(EditText)findViewById(R.id.contactno);
        loginRedirectText = findViewById(R.id.loginRedirectText);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               database=FirebaseDatabase.getInstance();
               reference=database.getReference("users");
                String flatno=Flatno.getText().toString();
                String contactno=Contactno.getText().toString();
                String name = signupName.getText().toString();
                String email = signupEmail.getText().toString();
                String username = signupUsername.getText().toString();
                String password = signupPassword.getText().toString();
                String status=Status.getText().toString();
                if((!flatno.equals(""))&&(!contactno.equals(""))&&(!name.equals(""))&&(!email.equals(""))&&(!username.equals(""))&&(!password.equals("")))
                {
                    HelperClass helperClass = new HelperClass(name, email, username, password, flatno, contactno, status);
                    reference.child(username).setValue(helperClass);

                    Toast.makeText(UserSignup1.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
                    signupName.setText("");
                    signupEmail.setText("");
                    signupUsername.setText("");
                    signupPassword.setText("");
                    Flatno.setText("");
                    Contactno.setText("");
                    Intent intent = new Intent(UserSignup1.this, UserLogin1.class);
                    startActivity(intent);
                }else
                {
                    Toast.makeText(UserSignup1.this, "Please Enter all the Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserSignup1.this, UserLogin1.class);
                startActivity(intent);
            }
        });
    }
}

