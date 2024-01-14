package com.example.managecasa;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class recycler extends AppCompatActivity {
    RecyclerView recyclerView;
    Myadapter1 myadapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView=findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<model1> options =
                new FirebaseRecyclerOptions.Builder<model1>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Meeting"), model1.class)
                        .build();
        myadapter=new Myadapter1(options);
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