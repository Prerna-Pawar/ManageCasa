package com.example.managecasa;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class UserDashboard extends AppCompatActivity {
ImageView i1,i2,i3,i5;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        i1=(ImageView)findViewById(R.id.impnotice);
        i2=(ImageView)findViewById(R.id.complaints);
        i3=(ImageView)findViewById(R.id.uploadnotice);

        i5=(ImageView) findViewById(R.id.meeting);


        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserDashboard.this,Notice_display.class);
                startActivity(intent);

            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(UserDashboard.this,Complaints_Requests.class);
                startActivity(intent1);

            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(UserDashboard.this,UserActivity.class);
                startActivity(intent1);

            }
        });

        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(UserDashboard.this,recycler.class);
                startActivity(intent1);

            }
        });

    }
}