package com.example.managecasa;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class
Admin_view extends AppCompatActivity {

    RecyclerView recyclerView;
    Myadapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        recyclerView=findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("users"), model.class)
                        .build();
        myadapter=new Myadapter(options);
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