package com.example.managecasa;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class Myadapter3 extends FirebaseRecyclerAdapter<model3,Myadapter3.myviewholder>
{


    public Myadapter3(@NonNull FirebaseRecyclerOptions<model3> options) {
        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, @SuppressLint("RecyclerView") int position, @NonNull model3 model3)
    {
        holder.date.setText(model3.getDate());
        holder.title.setText(model3.getTitle());
        holder.notice.setText(model3.getNotice());


    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow3,parent,false);
        return new myviewholder(view);

    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView date,title,notice;


        public myviewholder(@NonNull View itemView) {
            super(itemView);
            date=(TextView)itemView.findViewById(R.id.datetext);
            title=(TextView) itemView.findViewById(R.id.titletext);
            notice=(TextView)itemView.findViewById(R.id.desctext);

        }
    }
}
