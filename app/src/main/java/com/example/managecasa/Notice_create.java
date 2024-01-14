package com.example.managecasa;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Notice_create extends AppCompatActivity {
    EditText e1,e2;
    TextView t1;
    Button b,b1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_create);
        e1=(EditText) findViewById(R.id.title);
        t1=(TextView) findViewById(R.id.editTextDate);
        e2=(EditText) findViewById(R.id.notice);
        b1=(Button)findViewById(R.id.display);
        b=(Button) findViewById(R.id.send);
        Date date1= Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String date= dateFormat.format(date1);
        t1.setText("Date: "+date);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5=new Intent(getApplicationContext(),Notice_display.class);
                startActivity(intent5);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title=e1.getText().toString().trim();
                String date2=t1.getText().toString().trim();
                String notice=e2.getText().toString().trim();
                if(!title.equals("") && (!date2.equals(""))&& (!notice.equals("")))
                {
                    dataholder2 obj=new dataholder2(title,date2,notice);
                    FirebaseDatabase db = FirebaseDatabase.getInstance();
                    DatabaseReference node = db.getReference("Notice");
                    node.child(title).setValue(obj);
                    e1.setText("");
                    e2.setText("");
                    Toast.makeText(getApplicationContext(), "Inserted", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(Notice_create.this,"Enter ALL the Fields",Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}