package com.tutorial.ScientToolsApp;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MyViewHolder> {
    ArrayList<username> list;
    public  AdapterClass(ArrayList<username> list){
        this.list = list;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listlayout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder,int i) {
        myViewHolder.name.setText(list.get(i).getName());
        myViewHolder.rollno.setText(list.get(i).getRollno());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,rollno;
        public  MyViewHolder(@NonNull View ItemView){
            super(ItemView);
            name = itemView.findViewById(R.id.tvname);
            rollno = itemView.findViewById(R.id.tvrollno);
        }
    }

}
