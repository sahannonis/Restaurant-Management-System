package com.example.imagerecycler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewCartActivity extends AppCompatActivity

    {

        RecyclerView dRecyclerView;
        FirebaseDatabase dFirebaseDatabase;
        DatabaseReference dRef;
        private FirebaseAuth firebaseAuth  = FirebaseAuth.getInstance();;

        String user = firebaseAuth.getCurrentUser().getUid();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_viewcart);
        FirebaseApp.initializeApp(this);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("Menu");

        dRecyclerView = findViewById(R.id.recyclerView1);
        dRecyclerView.setHasFixedSize(true);

        dRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        dFirebaseDatabase  = FirebaseDatabase.getInstance();
        dRef = dFirebaseDatabase.getReference("Cart/"+user);


    }

        public void BacktoCart (View view){
        Intent StartPizza = new Intent(this, MainActivity.class);
        startActivity(StartPizza);
    }
        public void placeorder (View view){

            Intent StartPizza = new Intent(this, ChoiceActivity.class);
            startActivity(StartPizza);
            Toast.makeText(view.getContext(), "Please choose your preference", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<ModelView, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ModelView, ViewHolder>(
                        ModelView.class,
                        R.layout.viewcart,
                        ViewHolder.class,
                        dRef


                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, ModelView model, int i) {
                        viewHolder.setViewCart(getApplicationContext(),model.getName(),model.getDescription(),model.getPrice(),model.getImagename());
                    }
                };

        dRecyclerView.setAdapter(firebaseRecyclerAdapter);

    }

    }