package com.example.imagerecycler;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.paypal.android.sdk.payments.PaymentActivity;

import org.w3c.dom.Text;

public class PaymentAction extends AppCompatActivity {
    private long  total = 2780;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        TextView TotalPrice = (TextView) findViewById(R.id.TotalPrice);
        Intent intent = getIntent();

        TotalPrice.setText("Total Amount: 2780");
        Button payment = findViewById(R.id.Purchase);

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PaymentAction.this,Checkout_Activity.class));

                ProceedToPayment();
            }
        });
    }
    private void ProceedToPayment()
    {
        Intent goforpayment = new Intent(PaymentAction.this,Checkout_Activity.class);
        goforpayment.putExtra("Payment", total);
        startActivity(goforpayment);
    }
}
