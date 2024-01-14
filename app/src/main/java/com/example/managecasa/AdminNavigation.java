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

public class AdminNavigation extends AppCompatActivity {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawableLayout;
    Toolbar toolbar;
    ImageView i1,i2,i3,i5,i6;
    private final int REQ=1;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_navigation);
        Intent intent = getIntent();
        i1=(ImageView)findViewById(R.id.impnotice);
        i2=(ImageView)findViewById(R.id.complaints);
        i3=(ImageView)findViewById(R.id.uploadnotice);

        i5=(ImageView) findViewById(R.id.meeting);
        i6=(ImageView)findViewById(R.id.uploadcomplaint);


        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminNavigation.this,Notice_display.class);
                startActivity(intent);

            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(AdminNavigation.this,Complaints_Requests.class);
                startActivity(intent1);

            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(AdminNavigation.this,UserActivity.class);
                startActivity(intent1);

            }
        });

        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(AdminNavigation.this,recycler.class);
                startActivity(intent1);

            }
        });
        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent10=new Intent(AdminNavigation.this,Main3.class);
                startActivity(intent10);
            }
        });




        String nameUser = intent.getStringExtra("name");
        String contact=intent.getStringExtra("contactno");
        String flat=intent.getStringExtra("flatno");
        String emailUser = intent.getStringExtra("email");
        String usernameUser = intent.getStringExtra("username");
        String passwordUser = intent.getStringExtra("password");


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nav = (NavigationView) findViewById(R.id.navmenu);
        drawableLayout = (DrawerLayout) findViewById(R.id.drawer);

        toggle = new ActionBarDrawerToggle(this, drawableLayout, toolbar, R.string.open, R.string.close);
        drawableLayout.addDrawerListener(toggle);
        toggle.syncState();



        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home:
                        Intent intent4=new Intent(AdminNavigation.this,UserDashboard.class);
                        startActivity(intent4);
                        Toast.makeText(AdminNavigation.this,"Home Panel is open",Toast.LENGTH_SHORT).show();
                        drawableLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_uploadnotice:

                        Intent intent5=new Intent(getApplicationContext(),UserActivity.class);
                        startActivity(intent5);
                        Toast.makeText(getApplicationContext(),"Notices Opened",Toast.LENGTH_LONG).show();
                        drawableLayout.closeDrawer(GravityCompat.START);
                        break;


                    case R.id.menu_profile:
                        Intent intent1=new Intent(AdminNavigation.this,UserProfile.class);
                        intent1.putExtra("name", nameUser);
                        intent1.putExtra("email", emailUser);
                        intent1.putExtra("username", usernameUser);
                        intent1.putExtra("password", passwordUser);
                        intent1.putExtra("contactno", contact);
                        intent1.putExtra("flatno", flat);
                        startActivity(intent1);
                        Toast.makeText(getApplicationContext(),"Profile Panel is open",Toast.LENGTH_SHORT).show();
                        drawableLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_notice:

                        Intent intent6=new Intent(AdminNavigation.this,Notice_display.class);
                        startActivity(intent6);
                        Toast.makeText(getApplicationContext(),"Notice Panel is open",Toast.LENGTH_SHORT).show();
                        drawableLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu_meetings:
                        Intent intent2=new Intent(getApplicationContext(),recycler.class);
                        startActivity(intent2);
                        Toast.makeText(getApplicationContext(),"Meetings Panel is open",Toast.LENGTH_SHORT).show();
                        drawableLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.upload_complaint:
                        Intent intent7=new Intent(AdminNavigation.this,Main3.class);
                        startActivity(intent7);
                        Toast.makeText(getApplicationContext(),"Complaint Panel is open",Toast.LENGTH_SHORT).show();
                        drawableLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_complaints_request:
                        Intent intent3=new Intent(AdminNavigation.this,Complaints_Requests.class);
                        startActivity(intent3);
                        Toast.makeText(getApplicationContext(),"Complaints Panel is open",Toast.LENGTH_SHORT).show();
                        drawableLayout.closeDrawer(GravityCompat.START);
                        break;
                  /*  case R.id.menu_polls:
                        Toast.makeText(getApplicationContext(),"Polls Panel is open",Toast.LENGTH_SHORT).show();
                        drawableLayout.closeDrawer(GravityCompat.START);
                        break;*/
                    case R.id.menu_logout:
                        Intent intent8=new Intent(AdminNavigation.this,UserLogin1.class);
                        startActivity(intent8);
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