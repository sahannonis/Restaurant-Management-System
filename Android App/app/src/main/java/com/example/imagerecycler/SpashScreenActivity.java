package com.example.imagerecycler;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;



public class SpashScreenActivity extends AppCompatActivity {

    private ImageView logo;
    private static int spashTimeout = 6500;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_screen);
        logo = (ImageView)findViewById(R.id.ImgViewSplash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SpashScreenActivity.this,action_home.class);
                startActivity(intent);

                finish();
            }
        },spashTimeout);


        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.spashscreen);
        logo.startAnimation(myanim);


    }
}
