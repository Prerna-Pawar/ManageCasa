package com.example.managecasa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Forgot_Password extends AppCompatActivity {

    EditText Newpassword,ConfirmPassword,Username;
    Button Submit;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        Newpassword=findViewById(R.id.newpassword);
        ConfirmPassword=findViewById(R.id.conPass);
        Submit=findViewById(R.id.submit);
        Username=findViewById(R.id.username);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String NewPass=Newpassword.getText().toString().trim();
                String ConPass=ConfirmPassword.getText().toString().trim();
                String UserName=Username.getText().toString().trim();
                if(NewPass.equals(ConPass))
                {
                    DatabaseReference parent=FirebaseDatabase.getInstance().getReference().child("users");
                    DatabaseReference child=parent.child(UserName).child("password");
                    child.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String childdata=snapshot.getValue(String.class);
                            child.setValue(NewPass);
                            Toast.makeText(Forgot_Password.this, "New Password Updated", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(Forgot_Password.this, "Try Again", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else
                {
                    Toast.makeText(Forgot_Password.this, "Please enter correct password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}