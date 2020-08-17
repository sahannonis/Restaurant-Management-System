package com.example.imagerecycler;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChoiceActivity extends AppCompatActivity {

    FirebaseDatabase dFirebaseDatabase = FirebaseDatabase.getInstance();
    private FirebaseAuth firebaseAuth  = FirebaseAuth.getInstance();

    String user = firebaseAuth.getCurrentUser().getUid();
    DatabaseReference RedT = dFirebaseDatabase.getReference("Cart").child(user).push().child("type");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        Button dinein = findViewById(R.id.DineIn);
        Button takeaway = findViewById(R.id.Takeaway);
        Button delievery = findViewById(R.id.Delievery);

        dinein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String type = "DineIn";
                RedT.setValue(type);
                startActivity(new Intent(ChoiceActivity.this,PaymentAction.class));
                Toast.makeText(v.getContext(), "Chose: DineIn", Toast.LENGTH_SHORT).show();
            }
        });
        takeaway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = "TakeAway";
                RedT.setValue(type);
                startActivity(new Intent(ChoiceActivity.this,PaymentAction.class));
                Toast.makeText(v.getContext(), "Chose: Takeaway", Toast.LENGTH_SHORT).show();
            }
        });
        delievery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = "Delivery";
                RedT.setValue(type);
                startActivity(new Intent(ChoiceActivity.this,PaymentAction.class));
                Toast.makeText(v.getContext(), "Chose: Delivery", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
