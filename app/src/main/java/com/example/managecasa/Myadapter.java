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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Myadapter extends FirebaseRecyclerAdapter<model,Myadapter.myviewholder>
{
    public Myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, @SuppressLint("RecyclerView") int position, @NonNull model model) {
        holder.name.setText(model.getName());
        holder.contactno.setText(model.getContactno());
        holder.flatno.setText(model.getFlatno());
        holder.email.setText(model.getEmail());
        holder.status.setText(model.getStatus());
        holder.username.setText(model.getUsername());


        holder.verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog
                        .Builder(holder.username.getContext());
                builder.setTitle("Allow");
                builder.setMessage("Are you sure...?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DatabaseReference parent = FirebaseDatabase.getInstance().getReference().child("users");
                        DatabaseReference child = parent.child(model.getUsername()).child("status");
                        child.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {

                                child.setValue("Verified");



                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
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

        holder.disallow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.username.getContext());
                builder.setTitle("Disallow");
                builder.setMessage("Deny...?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("users").child(getRef(position).getKey()).removeValue();
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
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_source,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView name,contactno,flatno,email,username,status;
        ImageView disallow,verify;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.fullname);
            contactno=(TextView)itemView.findViewById(R.id.contact);
            disallow=(ImageView)itemView.findViewById(R.id.disallow);
            flatno=(TextView) itemView.findViewById(R.id.flat);
            email=(TextView)itemView.findViewById(R.id.email);
            verify=(ImageView)itemView.findViewById(R.id.verify);
            username=(TextView)itemView.findViewById(R.id.username);
            status=(TextView)itemView.findViewById(R.id.status);

        }
    }
}