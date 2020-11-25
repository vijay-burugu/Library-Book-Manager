package com.example.librarybookmanage;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {
    Activity activity; ArrayList<Product_Books> arrayList;
    public BooksAdapter(Activity activity, ArrayList<Product_Books> arrayList) {
        this.activity = activity;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(activity.getLayoutInflater().inflate(R.layout.list_details,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Product_Books u = arrayList.get(position);
        holder.name.setText("Book Name : "+u.getName());
        holder.qty.setText(u.getQty());
        holder.price.setText(u.getPrice());
        holder.description.setText(u.getDescription());
        holder.nvaliddays.setText(u.getPvaliddays());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(
                        new Intent(activity, UpdateBookDetails.class)
                                .putExtra("books",u)
                );
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,qty,price,description,nvaliddays;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.name);
            qty=  itemView.findViewById(R.id.qty);
            price=  itemView.findViewById(R.id.price);
            description=  itemView.findViewById(R.id.description);
            nvaliddays=itemView.findViewById(R.id.validndays);
        }
    }
}
