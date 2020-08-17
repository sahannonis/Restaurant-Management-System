package com.example.imagerecycler;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    RecyclerView pRecyclerView;
    FirebaseDatabase pFirebaseDatabase;
    DatabaseReference mRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("Menu");

        pRecyclerView = findViewById(R.id.recyclerView);
        pRecyclerView.setHasFixedSize(true);

        pRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        pFirebaseDatabase  = FirebaseDatabase.getInstance();
        mRef = pFirebaseDatabase.getReference("items/pizza");


    }
    public void switchpizza(View view){
        Intent StartPizza = new Intent(this, MainActivity.class);
        startActivity(StartPizza);
    }
    public void switchdrinks(View view){
        Intent StartDrinks = new Intent(this,DrinkActivity.class);
        startActivity(StartDrinks);
    }
    public void switchpasta(View view){
        Intent StartPasta = new Intent(this, PastaActivity.class);
        startActivity(StartPasta);
    }
    public void switchdesert(View view){
        Intent StartDessert = new Intent(this, DesertActivity.class);
        startActivity(StartDessert);
    }
    public void viewcart(View view){
        Intent StartDessert = new Intent(this, ViewCartActivity.class);
        startActivity(StartDessert);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ViewHolder>(
                        Model.class,
                        R.layout.imageview,
                        ViewHolder.class,
                        mRef


                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Model model, int i) {
                        viewHolder.setDetails(getApplicationContext(),model.getName(),model.getDescription(),model.getSmall(),model.getMedium(),model.getLarge(),model.getImagename());

                    }
                };

        pRecyclerView.setAdapter(firebaseRecyclerAdapter);

    }

}
