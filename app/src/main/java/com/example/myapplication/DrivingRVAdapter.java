package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public abstract class DrivingRVAdapter extends RecyclerView.Adapter<DrivingRVAdapter.ViewHolder> {
    //creating variables for our list, context, interface and position.
    private ArrayList<DrivingRVModal> courseRVModalArrayList;
    private Context context;
    private CourseClickInterface courseClickInterface;
    int lastPos = -1;

    //creating a constructor.
    public DrivingRVAdapter(ArrayList<DrivingRVModal> courseRVModalArrayList, Context context, CourseClickInterface courseClickInterface) {
        this.courseRVModalArrayList = courseRVModalArrayList;
        this.context = context;
        this.courseClickInterface = courseClickInterface;
    }

    @NonNull
    @Override
    public DrivingRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating our layout file on below line.
        View view = LayoutInflater.from(context).inflate(R.layout.course_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrivingRVAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //setting data to our recycler view item on below line.
        DrivingRVModal courseRVModal = courseRVModalArrayList.get(position);
        holder.showDrivingName.setText(courseRVModal.getDrivingNameName());
        holder.showLocation.setText( courseRVModal.getLocation());
        holder.showContact.setText(courseRVModal.getContact());
        holder.showDesc.setText(courseRVModal.getContact());
        //adding animation to recycler view item on below line.
        setAnimation(holder.itemView, position);
        holder.showMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courseClickInterface.onCourseClick(position);
            }
        });
    }

    private void setAnimation(View itemView, int position) {
        if (position > lastPos) {
            //on below line we are setting animation.
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            itemView.setAnimation(animation);
            lastPos = position;
        }
    }

    @Override
    public int getItemCount() {
        return courseRVModalArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //creating variable for our image view and text view on below line.

        private  TextView showDrivingName,showLocation,showContact,showDesc,showMore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //initializing all our variables on below line.
            showDrivingName = itemView.findViewById(R.id.showDrivingName);
            showContact = itemView.findViewById(R.id.showContact);
            showLocation = itemView.findViewById(R.id.showLocation);
            showDesc = itemView.findViewById(R.id.showDescription);
            showMore = itemView.findViewById(R.id.showMore);

        }
    }

    //creating a interface for on click
    public interface CourseClickInterface {
        void onCourseClick(int position);
    }
}
