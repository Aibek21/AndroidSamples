package com.example.lifecycleapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Contact> items;
    Context context;

    MyRecyclerAdapter(ArrayList<Contact> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        if (viewType == 1) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item, parent, false);
            return new SimpleViewHolder(view, context);
        }

        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_new, parent, false);
//        Log.e("MyRecyclerAdapter", "onCreateViewHolder");
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        Log.e("MyRecyclerAdapter", "Bind");
        if (holder instanceof SimpleViewHolder) {
            SimpleViewHolder sholder = ((SimpleViewHolder) holder);
            sholder.textView.setText(items.get(position).getName());
            sholder.setPosition(position);
        } else {
            CustomViewHolder cholder = ((CustomViewHolder) holder);
            cholder.textView.setText(items.get(position).getName());
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 4 == 3)
            return 2;
        return 1;
    }

    class SimpleViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        int position;

        public SimpleViewHolder(@NonNull View itemView, final Context context) {
            super(itemView);
            textView = itemView.findViewById(R.id.mytext);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("SimpleViewHolder", "item click");
                    Toast.makeText(context, "Item click " + position, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("contact", items.get(position));
                    context.startActivity(intent);
                }
            });
        }


        public void setPosition(int position) {
            this.position = position;
        }
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.title);
        }
    }
}
