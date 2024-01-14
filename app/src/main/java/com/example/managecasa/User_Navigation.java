package com.example.managecasa;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class User_Navigation extends AppCompatActivity {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawableLayout;
    Toolbar toolbar;
    ImageView i1,i2,i3,i4,i5,i6;


    private final int REQ=1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_navigation);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nav = (NavigationView) findViewById(R.id.navmenu);
        i1=(ImageView) findViewById(R.id.impnotice);
        i2=(ImageView)findViewById(R.id.complaints);
        i3=(ImageView)findViewById(R.id.uploadnotice);
        i4=(ImageView)findViewById(R.id.request);
        i5=(ImageView)findViewById(R.id.meeting);
        i6=(ImageView)findViewById(R.id.viewcomplaint);
        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(User_Navigation.this,Complaint_display.class);
                startActivity(intent);
            }
        });
        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(User_Navigation.this,meeting.class);
                startActivity(intent);
            }
        });
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(User_Navigation.this,Admin_view.class);
                startActivity(intent);
            }
        });


        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(User_Navigation.this,Notice_create.class);
                startActivity(intent);
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(User_Navigation.this,Main2.class);
                startActivity(intent);
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(User_Navigation.this,View_Complaints.class);
                startActivity(intent1);
            }
        });




        drawableLayout = (DrawerLayout) findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this, drawableLayout, toolbar, R.string.open, R.string.close);
        drawableLayout.addDrawerListener(toggle);
        toggle.syncState();
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home:
                        Intent intent6=new Intent(User_Navigation.this,AdminDashboard.class);
                        startActivity(intent6);
                        Toast.makeText(getApplicationContext(),"Dashboard Panel is open",Toast.LENGTH_SHORT).show();

                        drawableLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_profile:
                        Intent intent1=new Intent(User_Navigation.this,Admin_view.class);
                        startActivity(intent1);
                        Toast.makeText(getApplicationContext(),"Profile Panel is open",Toast.LENGTH_SHORT).show();
                        drawableLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu_notice:
                        Intent intent=new Intent(User_Navigation.this,Notice_create.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),"Notice Panel is open",Toast.LENGTH_SHORT).show();
                        drawableLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu_uploadnotice:
                        Intent intent8=new Intent(User_Navigation.this,Main2.class);
                        startActivity(intent8);
                        Toast.makeText(getApplicationContext(),"Documents Notice Panel is open",Toast.LENGTH_SHORT).show();
                        drawableLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.upload_complaint:
                        Intent intent9=new Intent(User_Navigation.this,Complaint_display.class);
                        startActivity(intent9);
                        Toast.makeText(getApplicationContext(),"Documents Complaint Panel is open",Toast.LENGTH_SHORT).show();
                        drawableLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu_meetings:
                        Intent intent2=new Intent(getApplicationContext(),meeting.class);
                        startActivity(intent2);
                        Toast.makeText(getApplicationContext(),"Meetings Panel is open",Toast.LENGTH_SHORT).show();
                        drawableLayout.closeDrawer(GravityCompat.START);
                        break;
                        case R.id.menu_viewmeetings:
                          Intent intent3=new Intent(getApplicationContext(),recycler.class);
                          startActivity(intent3);
                          Toast.makeText(getApplicationContext(),"View Meetings Panel is open",Toast.LENGTH_SHORT).show();
                           drawableLayout.closeDrawer(GravityCompat.START);
                           break;
                    case R.id.menu_complaints_request:
                        Intent intent4=new Intent(getApplicationContext(),View_Complaints.class);
                        startActivity(intent4);
                        Toast.makeText(getApplicationContext(),"Complaints Panel is open",Toast.LENGTH_SHORT).show();
                        drawableLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_logout:
                        Intent intent7=new Intent(getApplicationContext(),AdminLogin.class);
                        startActivity(intent7);
                        finish();
                        Toast.makeText(getApplicationContext(),"You may log out",Toast.LENGTH_SHORT).show();
                        drawableLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });
    }
}