package com.example.managecasa;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class UserLogin1 extends AppCompatActivity {

    EditText loginUsername, loginPassword;
    Button loginButton;
    TextView signupRedirectText,ForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login1);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        loginUsername = findViewById(R.id.login_user_name);
        loginPassword = findViewById(R.id.login_user_password);
        signupRedirectText = findViewById(R.id.signupRedirectText);
        loginButton = findViewById(R.id.login_user_button);
        ForgotPassword=findViewById(R.id.forgotpassword);

        ForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserLogin1.this,Forgot_Password.class);
                startActivity(intent);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateUsername() | !validatePassword()){


                } else {
                    checkUser();
                }
            }
        });

        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserLogin1.this, UserSignup1.class);
                startActivity(intent);
            }
        });
    }

    public Boolean validateUsername(){
        String val = loginUsername.getText().toString();
        if (val.isEmpty()){
            loginUsername.setError("Username cannot be empty");
            return false;
        } else {
            loginUsername.setError(null);
            return true;
        }
    }

    public Boolean validatePassword(){
        String val = loginPassword.getText().toString();
        if (val.isEmpty()){
            loginPassword.setError("Password cannot be empty");
            return false;
        } else {
            loginPassword.setError(null);
            return true;
        }
    }

    public void checkUser(){
        String userUsername = loginUsername.getText().toString().trim();
        String userPassword = loginPassword.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()){
                    loginUsername.setError(null);
                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);
                    String status=snapshot.child(userUsername).child("status").getValue(String.class);
                    if (passwordFromDB.equals(userPassword)){
                        if(status.equals("Verified"))
                        {
                            loginUsername.setError(null);

                            //Pass the data using intent

                            String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
                            String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
                            String usernameFromDB = snapshot.child(userUsername).child("username").getValue(String.class);
                            String contactnoFromDB = snapshot.child(userUsername).child("contactno").getValue(String.class);
                            String flatnoFromDB = snapshot.child(userUsername).child("flatno").getValue(String.class);
                            Intent intent = new Intent(UserLogin1.this, onboardingscreen.class);

                            intent.putExtra("name", nameFromDB);
                            intent.putExtra("email", emailFromDB);
                            intent.putExtra("username", usernameFromDB);
                            intent.putExtra("password", passwordFromDB);
                            intent.putExtra("contactno", contactnoFromDB);
                            intent.putExtra("flatno", flatnoFromDB);

                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(UserLogin1.this, "Not yet Verified by admin", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        loginPassword.setError("Invalid Credentials");

                        loginPassword.requestFocus();
                    }
                } else {
                    loginUsername.setError("User does not exist");
                    loginUsername.requestFocus();
                }
                loginUsername.setText("");
                loginPassword.setText("");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}