package com.example.managecasa;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class meeting extends AppCompatActivity {
    Button b;
    EditText e1,e2,e3,e4;
    DatePickerDialog picker;
    String date,time,agenda;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting);
        b=findViewById(R.id.button);

        e4=findViewById(R.id.no);
        e1=findViewById(R.id.editTextDate);
        e2=findViewById(R.id.editTextTime);
        e3=findViewById(R.id.editTextTextMultiLine);


        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar=Calendar.getInstance();
                int day=calendar.get(Calendar.DAY_OF_MONTH);
                int month=calendar.get(Calendar.MONTH);
                int year=calendar.get(Calendar.YEAR);
                picker=new DatePickerDialog(meeting.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        e1.setText(dayOfMonth+"/"+(month+1)+"/"+year);

                    }
                },year,month,day);
                picker.show();
            }
        });
        e2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar=Calendar.getInstance();
                int hour=calendar.get(Calendar.HOUR_OF_DAY);
                int minute=calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog;
                timePickerDialog=new TimePickerDialog(meeting.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        calendar.set(Calendar.HOUR,hour);
                        calendar.set(Calendar.MINUTE,minute);
                        String amPm;
                        String myFormat="HH:MM:SS";
                        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.getDefault());
                        if(hour>=12)
                        {
                            amPm="PM";
                        }
                        else {
                            amPm = "AM";
                        }

                        e2.setText(dateFormat.format(calendar.getTime())+" "+ amPm);

                    }
                },hour,minute,false);
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String no=e4.getText().toString().trim();
                String date=e1.getText().toString().trim();
                String time=e2.getText().toString().trim();
                String agenda=e3.getText().toString().trim();
                if((!no.equals("")) && (!date.equals("")) && (!time.equals("")) && (!agenda.equals("")))
                {
                    dataholder obj = new dataholder(no, date, time, agenda);
                    FirebaseDatabase db = FirebaseDatabase.getInstance();
                    DatabaseReference node = db.getReference("Meeting");
                    node.child(no).setValue(obj);
                    e1.setText(" ");
                    e2.setText(" ");
                    e3.setText(" ");
                    e4.setText(" ");
                    Toast.makeText(getApplicationContext(), "Inserted", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(meeting.this,"Enter ALL the Fields",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}