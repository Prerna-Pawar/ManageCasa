package com.example.managecasa;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditProfileActivitry extends AppCompatActivity {

    EditText editName, editEmail, editUsername, editPassword,editContactno,editFlatno;
    Button saveButton;
    String nameUser, emailUser, usernameUser, passwordUser,contactnouser,flatnouser;
    DatabaseReference reference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_activitry);

        reference = FirebaseDatabase.getInstance().getReference("users");

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editContactno=findViewById(R.id.editContactno);
        editFlatno=findViewById(R.id.editFlatno);
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        saveButton = findViewById(R.id.saveButton);

        showData();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNameChanged() || isEmailChanged() || isPasswordChanged()||isContactChanged()||isFlatChanged()||isUsernameChanged()) {
                    Toast.makeText(EditProfileActivitry.this, "Saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditProfileActivitry.this, "No Changes Found", Toast.LENGTH_SHORT).show();
                }
                editName.setText("");
                editEmail.setText("");
                editUsername.setText("");
                editPassword.setText("");
                editContactno.setText("");
                editFlatno.setText("");

            }
        });
    }

    public boolean isNameChanged(){
        if (!nameUser.equals(editName.getText().toString())){
            reference.child(usernameUser).child("name").setValue(editName.getText().toString());
            nameUser = editName.getText().toString();
            return true;
        } else{
            return false;
        }
    }

    public boolean isEmailChanged(){
        if (!emailUser.equals(editName.getText().toString())){
            reference.child(usernameUser).child("email").setValue(editEmail.getText().toString());
            emailUser = editEmail.getText().toString();
            return true;
        } else{
            return false;
        }
    }

    public boolean isPasswordChanged(){
        if (!passwordUser.equals(editPassword.getText().toString())){
            reference.child(usernameUser).child("password").setValue(editPassword.getText().toString());
            passwordUser = editPassword.getText().toString();
            return true;
        } else{
            return false;
        }
    }
    public boolean isContactChanged()
    {
        if (!contactnouser.equals(editContactno.getText().toString())){
            reference.child(usernameUser).child("contactno").setValue(editContactno.getText().toString());
            contactnouser = editContactno.getText().toString();
            return true;
        } else{
            return false;
        }

    }
    public boolean isUsernameChanged()
    {
        if (!usernameUser.equals(editUsername.getText().toString())){
            reference.child(usernameUser).child("username").setValue(editUsername.getText().toString());
            usernameUser = editUsername.getText().toString();
            return true;
        } else{
            return false;
        }
    }
    public boolean isFlatChanged()
    {
        if (!flatnouser.equals(editFlatno.getText().toString())){
            reference.child(usernameUser).child("flatno").setValue(editFlatno.getText().toString());
            flatnouser = editFlatno.getText().toString();
            return true;
        } else{
            return false;
        }
    }
    public void showData(){
        Intent intent = getIntent();

        nameUser = intent.getStringExtra("name");
        emailUser = intent.getStringExtra("email");
        usernameUser = intent.getStringExtra("username");
        passwordUser = intent.getStringExtra("password");
       contactnouser=intent.getStringExtra("contactno").toString();
       flatnouser=intent.getStringExtra("flatno").toString();
        editName.setText(nameUser);
        editEmail.setText(emailUser);
        editUsername.setText(usernameUser);
        editPassword.setText(passwordUser);
        editContactno.setText(contactnouser);
        editFlatno.setText(flatnouser);
    }
}