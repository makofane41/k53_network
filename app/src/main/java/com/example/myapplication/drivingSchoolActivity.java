package com.example.myapplication;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;

public class drivingSchoolActivity extends AppCompatActivity implements DrivingRVAdapter.CourseClickInterface {

    //creating variables for fab, firebase database, progress bar, list, adapter,firebase auth, recycler view and relative layout.
    private FloatingActionButton Home;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private RecyclerView drivingSchoolRV;
    private FirebaseAuth mAuth;
    private ProgressBar loadingPB;
    private ArrayList<DrivingRVModal> drivingRVModalArrayList;
    private DrivingRVAdapter drivingRVAdapter;
    private RelativeLayout homeRL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initializing all our variables.
        drivingSchoolRV = findViewById(R.id.drivingSchoolRV);
        homeRL = findViewById(R.id.idRLBSheet);
        loadingPB = findViewById(R.id.idPBLoading);
        Home = findViewById(R.id.idFABAddCourse);
        firebaseDatabase = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        drivingRVModalArrayList = new ArrayList<>();
        //on below line we are getting database reference.
        databaseReference = firebaseDatabase.getReference("Driving Schools").child("DrvingID");
        //on below line adding a click listener for our floating action button.
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //opening a new activity for adding a course.
                Intent i = new Intent(drivingSchoolActivity.this, Home.class);
                startActivity(i);
            }
        });
        //on below line initializing our adapter class.
        drivingRVAdapter = new DrivingRVAdapter(drivingRVModalArrayList, this, this::onCourseClick);
        //setting layout malinger to recycler view on below line.
        drivingSchoolRV.setLayoutManager(new LinearLayoutManager(this));
        //setting adapter to recycler view on below line.
        drivingSchoolRV.setAdapter(drivingRVAdapter);
        //on below line calling a method to fetch courses from database.
        getDrivingSchool();
    }

    private void getDrivingSchool() {
        //on below line clearing our list.
        drivingRVModalArrayList.clear();
        //on below line we are calling add child event listener method to read the data.
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                //on below line we are hiding our progress bar.
                loadingPB.setVisibility(View.GONE);
                //adding snapshot to our array list on below line.
                drivingRVModalArrayList.add(snapshot.getValue(DrivingRVModal.class));
                //notifying our adapter that data has changed.
                drivingRVAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                //this method is called when new child is added we are notifying our adapter and making progress bar visibility as gone.
                loadingPB.setVisibility(View.GONE);
                drivingRVAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                //notifying our adapter when child is removed.
                drivingRVAdapter.notifyDataSetChanged();
                loadingPB.setVisibility(View.GONE);

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                //notifying our adapter when child is moved.
                drivingRVAdapter.notifyDataSetChanged();
                loadingPB.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onCourseClick(int position) {
        //calling a method to display a bottom sheet on below line.
        displayBottomSheet(drivingRVModalArrayList.get(position));
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //on below line we are inflating our menu file for displaying our menu options.
        return true;
    }

    private void displayBottomSheet(DrivingRVModal modal) {
        //on below line we are creating our bottom sheet dialog.
        final BottomSheetDialog bottomSheetTeachersDialog = new BottomSheetDialog(this, R.style.BottomSheetDialogTheme);
        //on below line we are inflating our layout file for our bottom sheet.
        View layout = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_layout, homeRL);
        //setting content view for bottom sheet on below line.
        bottomSheetTeachersDialog.setContentView(layout);
        //on below line we are setting a cancelable
        bottomSheetTeachersDialog.setCancelable(false);
        bottomSheetTeachersDialog.setCanceledOnTouchOutside(true);
        //calling a method to display our bottom sheet.
        bottomSheetTeachersDialog.show();
        //on below line we are creating variables for our text view and image view inside bottom sheet
        //and initialing them with their ids.
        TextView courseNameTV = layout.findViewById(R.id.drivingName);
        TextView courseDescTV = layout.findViewById(R.id.desc);
        TextView suitedForTV = layout.findViewById(R.id.contact);

        //on below line we are setting data to different views on below line.
        courseNameTV.setText(modal.getDrivingNameName());
        courseDescTV.setText(modal.getDescription());
        suitedForTV.setText( modal.getLocation());

        Button viewBtn = layout.findViewById(R.id.idBtnVIewDetails);





    }


}