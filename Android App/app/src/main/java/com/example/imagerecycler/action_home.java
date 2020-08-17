package com.example.imagerecycler;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;


public class action_home extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_home);

     Button todaysmenu = findViewById(R.id.todaymenu);
     Button logout = findViewById(R.id.Logout);

     todaysmenu.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             startActivity(new Intent(action_home.this,MainActivity.class));
         }
     });

     logout.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             FirebaseAuth.getInstance().signOut();
             Intent intent=new Intent(action_home.this,UserLogin.class);
             startActivity(intent);
             finish();
         }
     });
}
}