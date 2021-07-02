package com.example.day2project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyLIstAdapter extends RecyclerView.Adapter<MyLIstAdapter.MyListViewHolder>{
    Context conText;
    ArrayList<String> data;

    MyLIstAdapter(Context conText,ArrayList<String> data){
        this.conText=conText;
        this.data=data;
    }

    @Override
    public MyListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(conText);
        View view=inflater.inflate(R.layout.list_item,null);
        return new MyListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyLIstAdapter.MyListViewHolder holder, int position) {
        holder.tv.setText(data.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tv;

        public MyListViewHolder(View itemView){
            super(itemView);
            tv=itemView.findViewById(R.id.tvTitle);
            tv.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            tv.setText("Clicked - " + tv.getText().toString());
        }
    }

}