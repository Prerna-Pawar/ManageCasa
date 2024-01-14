package com.example.managecasa;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AdminDashboard extends AppCompatActivity {
ImageView i1,i2,i3,i4,i5;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        i1=(ImageView) findViewById(R.id.impnotice);
        i2=(ImageView)findViewById(R.id.complaints);
        i3=(ImageView)findViewById(R.id.uploadnotice);
        i4=(ImageView)findViewById(R.id.request);
        i5=(ImageView)findViewById(R.id.meeting);
        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminDashboard.this,meeting.class);
                startActivity(intent);
            }
        });
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminDashboard.this,Admin_view.class);
                startActivity(intent);
            }
        });


        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminDashboard.this,Notice_create.class);
                startActivity(intent);
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminDashboard.this,Main2.class);
                startActivity(intent);
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(AdminDashboard.this,View_Complaints.class);
                startActivity(intent1);
            }
        });


    }
}