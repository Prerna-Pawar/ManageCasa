package com.example.managecasa;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class View_Complaints extends AppCompatActivity {
    RecyclerView recyclerView;
    Myadapter2 myadapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_complaints);
        recyclerView=findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<model2> options =
                new FirebaseRecyclerOptions.Builder<model2>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Complaints"), model2.class)
                        .build();
        myadapter=new Myadapter2(options);
        recyclerView.setAdapter(myadapter);


    }
    @Override
    protected void onStart() {
        super.onStart();
        myadapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        myadapter.stopListening();
    }

}