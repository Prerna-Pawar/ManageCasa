package com.example.managecasa;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Complaints_Requests extends AppCompatActivity {
EditText e1,e2,e3,e4,e5;
Button b;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaints_requests);
        e1=(EditText)findViewById(R.id.name_edit_text);
        e2=(EditText)findViewById(R.id.email_edit_text);
        e3=(EditText) findViewById(R.id.phone_edit_text);
        e4=(EditText) findViewById(R.id.subject_edit_text);
        e5=(EditText) findViewById(R.id.complaint_edit_text);
        b=(Button) findViewById(R.id.submit_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=e1.getText().toString().trim();
                String email=e2.getText().toString().trim();
                String phone=e3.getText().toString().trim();
                String subject=e4.getText().toString().trim();
                String complaint=e5.getText().toString().trim();
                if((!name.equals(""))&& (!email.equals(""))&& (!phone.equals(""))&& (!subject.equals(""))&&(!complaint.equals(""))) {
                    dataholder1 obj = new dataholder1(name, email, phone, subject, complaint);
                    FirebaseDatabase db = FirebaseDatabase.getInstance();
                    DatabaseReference node = db.getReference("Complaints");
                    node.child(name).setValue(obj);
                    e1.setText(" ");
                    e2.setText(" ");
                    e3.setText(" ");
                    e4.setText(" ");
                    e5.setText(" ");
                    Toast.makeText(getApplicationContext(), "Inserted", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(Complaints_Requests.this,"Enter ALL the Fields",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}