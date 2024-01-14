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

public class Myadapter2 extends FirebaseRecyclerAdapter<model2,Myadapter2.myviewholder>
{


    public Myadapter2(@NonNull FirebaseRecyclerOptions<model2> options) {
        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, @SuppressLint("RecyclerView") int position, @NonNull model2 model2)
    {
        holder.name.setText(model2.getName());
        holder.email.setText(model2.getEmail());
        holder.phone.setText(model2.getPhone());
        holder.subject.setText(model2.getSubject());
        holder.complaint.setText(model2.getComplaint());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.name.getContext());
                builder.setTitle("Delete");
                builder.setMessage("Delete....?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("Complaints").child(getRef(position).getKey()).removeValue();
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
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow1,parent,false);
        return new myviewholder(view);

    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView name,email,phone,subject,complaint;
        ImageView  delete;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.nametext);
            email=(TextView)itemView.findViewById(R.id.email);
            phone=(TextView)itemView.findViewById(R.id.phone);
            subject=(TextView)itemView.findViewById(R.id.subject);
            complaint=(TextView)itemView.findViewById(R.id.complaint);

            delete=(ImageView) itemView.findViewById(R.id.delete);
        }
    }
}
