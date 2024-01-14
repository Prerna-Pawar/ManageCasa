package com.example.managecasa;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Myadapter1 extends FirebaseRecyclerAdapter<model1,Myadapter1.myviewholder>
{


    public Myadapter1(@NonNull FirebaseRecyclerOptions<model1> options) {
        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, @SuppressLint("RecyclerView") int position, @NonNull model1 model1)
    {
        holder.date.setText(model1.getDate());
        holder.time.setText(model1.getTime());
        holder.agenda.setText(model1.getAgenda());
        holder.no.setText(model1.getNo());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.no.getContext());
                builder.setTitle("Delete");
                builder.setMessage("Delete....?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("Meeting").child(getRef(position).getKey()).removeValue();
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);

    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView date,time,agenda,no;
        ImageView edit, delete;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            date=(TextView)itemView.findViewById(R.id.datetext);
            time=(TextView) itemView.findViewById(R.id.timetext);
            agenda=(TextView)itemView.findViewById(R.id.agendatext);
            no=(TextView) itemView.findViewById(R.id.notext);

            delete=(ImageView) itemView.findViewById(R.id.delete);
        }
    }
}
