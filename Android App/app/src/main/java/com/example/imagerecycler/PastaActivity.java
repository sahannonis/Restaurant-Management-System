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

public class PastaActivity extends AppCompatActivity {

    RecyclerView dRecyclerView;
    FirebaseDatabase dFirebaseDatabase;
    DatabaseReference dRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("Menu");

        dRecyclerView = findViewById(R.id.recyclerView);
        dRecyclerView.setHasFixedSize(true);

        dRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        dFirebaseDatabase  = FirebaseDatabase.getInstance();
        dRef = dFirebaseDatabase.getReference("items/Pasta");


    }
    public void switchpizza(View view){
        Intent StartPizza = new Intent(this, MainActivity.class);
        startActivity(StartPizza);
    }
    public void switchdrinks(View view){
        Intent StartPizza = new Intent(this,DrinkActivity.class);
        startActivity(StartPizza);
    }
    public void switchpasta(View view){
        Intent StartPizza = new Intent(this, PastaActivity.class);
        startActivity(StartPizza);
    }
    public void switchdesert(View view){
        Intent StartPizza = new Intent(this, DesertActivity.class);
        startActivity(StartPizza);
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
                        R.layout.imageviewpasta,
                        ViewHolder.class,
                        dRef


                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Model model, int i) {
                        viewHolder.setDetailspasta(getApplicationContext(),model.getName(),model.getDescription(),model.getMedium(),model.getSmall(),model.getLarge(),model.getImagename());
                    }
                };

        dRecyclerView.setAdapter(firebaseRecyclerAdapter);

    }

}
