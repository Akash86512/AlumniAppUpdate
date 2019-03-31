package com.example.alumniapp.Home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alumniapp.HomePageData;
import com.example.alumniapp.R;
import com.example.alumniapp.RecyclerAdapterHomepage;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;


public class HomeFragment extends Fragment {

    private FirebaseAuth mAuth;
    private RecyclerView recyclerView;
    DatabaseReference mDatabaseRef;
    FirebaseDatabase database;
    List<HomePageData> homePageData=new ArrayList<HomePageData>();
    RecyclerAdapterHomepage recyclerAdapterHomepage;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("allpost");

        recyclerView =view.findViewById(R.id.home);


        RecyclerView.LayoutManager recyce = new GridLayoutManager(getActivity(),1);
        /// RecyclerView.LayoutManager recyce = new LinearLayoutManager(MainActivity.this);
        // recycle.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setLayoutManager(recyce);
        recyclerView.setItemAnimator( new DefaultItemAnimator());

        show();


        return view;
    }

    void show()
    {




            mDatabaseRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.


                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {


                        HomePageData homePageData1=postSnapshot.getValue(HomePageData.class);

                        homePageData.add(homePageData1);

                    }


                    recyclerAdapterHomepage=new RecyclerAdapterHomepage(homePageData,getActivity());
                    recyclerView.setAdapter(recyclerAdapterHomepage);




                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w(TAG, "Failed to read value.", error.toException());
                }
            });

        }


}
