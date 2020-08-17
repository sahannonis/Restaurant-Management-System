package com.example.imagerecycler;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;



public class forgotpassword extends AppCompatActivity {

    private TextView frgtpwdmail;
    private Button rstpwd;
    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        frgtpwdmail=(TextView)findViewById(R.id.etfrgtmail);
        rstpwd=(Button)findViewById(R.id.btnresetpwd);
        firebaseAuth= FirebaseAuth.getInstance();

        rstpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=frgtpwdmail.getText().toString().trim();
                if(email.isEmpty())
                {
                    Toast.makeText(forgotpassword.this,"Enter your email",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful())
                            {
                                Toast.makeText(forgotpassword.this,"Password reset link has been sent!",Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(forgotpassword.this,MainActivity.class));

                            }
                            else
                            {
                                Toast.makeText(forgotpassword.this,"Error. User not found",Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }

            }
        });



    }
}
