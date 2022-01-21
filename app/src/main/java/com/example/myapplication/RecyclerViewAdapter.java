package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewholder> {
    Context context;
    List<DrivingSchool> list;

    public RecyclerViewAdapter(Context context,List<DrivingSchool>list){

    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate((R.layout.single_view_item),parent,false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewholder holder, int position) {
        holder.drivingProfile.setImageResource(list.get(position).getDrivingSchoolProfile());
        holder.drivingName.setText(list.get(position).getDrivingName());
        holder.DescLocation.setText(list.get(position).getDrivingLocation());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        CircleImageView drivingProfile;
        TextView DescLocation;
        TextView drivingName;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            DescLocation =itemView.findViewById(R.id.DescLocation);
            drivingName = itemView.findViewById(R.id.drivingName);
            drivingProfile = itemView.findViewById(R.id.drivivingProfile);
        }
    }
}
