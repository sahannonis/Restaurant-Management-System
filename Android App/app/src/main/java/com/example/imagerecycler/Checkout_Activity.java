package com.example.imagerecycler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.imagerecycler.Config.Config;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;

import java.math.BigDecimal;

public class Checkout_Activity extends Activity {

    private static final int PAYPAL_REQUEST_CODE = 7171;
    private static PayPalConfiguration config = new PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            .clientId(Config.Paypal_Client_ID);

    Button btnPaynow;
    TextView edtAmount;


    String amount="";

    @Override
    protected void onDestroy() {
        stopService(new Intent(this,PayPalService.class));
        super.onDestroy();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_);

        //start paypal Service

        Intent intent = new Intent(this,PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
        startService(intent);


        btnPaynow = (Button)findViewById(R.id.btnPayNow);
        edtAmount = (TextView)findViewById(R.id.editAmount);

        btnPaynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProcessPayment();
            }
        });
        getintent();



    }

    private void ProcessPayment()
    {
        amount=edtAmount.getText().toString();
        PayPalPayment PaypalPayment = new PayPalPayment(new BigDecimal(String.valueOf(amount)),"USD","Pay For Your Pizza",PayPalPayment.PAYMENT_INTENT_SALE);
        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT,PaypalPayment);
        startActivityForResult(intent,PAYPAL_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PAYPAL_REQUEST_CODE)
        {
            if(resultCode ==  RESULT_OK)
            {

                Intent paymentconfirm = new Intent(Checkout_Activity.this,PaymentConfirmedActivity.class);
                paymentconfirm.putExtra("PaymentConfirmation","Confirmed");
                startActivity(paymentconfirm);
                Toast.makeText(this,"Payment Confirmed",Toast.LENGTH_SHORT).show();

             /* PaymentConfirmation confirmation = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (confirmation !=  null)
                {
                    try
                    {
                        String paymetDetails = confirmation.toJSONObject().toString(4);
                        startActivity(new Intent(this,PaymentDetails.class)
                                .putExtra("PaymentDetails",paymetDetails)
                                .putExtra("PaymentAmount",amount)

                        );

                    }
                    catch (JSONException e)
                    {
                        e.printStackTrace();
                    }
                }*/
            }
            else if (resultCode == Activity.RESULT_CANCELED)
            {
                Toast.makeText(this,"",Toast.LENGTH_SHORT).show();

            }
        }
        else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID)
        {
            Toast.makeText(this,"Invalid",Toast.LENGTH_SHORT).show();
        }
    }

    private void getintent()
    {
        Long value = getIntent().getLongExtra("Payment",0);
        String AAA = Long.toString(value);
        edtAmount.setText(AAA);
    }
}
