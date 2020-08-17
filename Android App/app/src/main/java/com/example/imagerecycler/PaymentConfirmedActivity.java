package com.example.imagerecycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;



public class PaymentConfirmedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_confirmed);

        TextView tv1,tv2;

        tv1 = (TextView)findViewById(R.id.tvPayment);
        tv2 = (TextView)findViewById(R.id.tvPaymentStatus);

        String confrimation =  getIntent().getStringExtra("PaymentConfirmation");
        tv2.setText(confrimation);


    }
}
