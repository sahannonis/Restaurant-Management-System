package com.example.imagerecycler;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class UserLogin extends AppCompatActivity {

    private EditText name;
    private EditText password;

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private TextView tvforgotpwd;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);

        name= findViewById(R.id.etname);
        password = findViewById((R.id.etpassword));
        Button login=  (Button)findViewById(R.id.btnlogin);
        Button signup= (Button)findViewById(R.id.btnsignup);
        tvforgotpwd = findViewById(R.id.tvforgotpwd);

        firebaseAuth= FirebaseAuth.getInstance();
        FirebaseUser user= firebaseAuth.getCurrentUser();

        progressDialog= new ProgressDialog(this);

        if (user!=null)
        {
            finish();
            startActivity(new Intent(UserLogin.this,MainActivity.class));
        }

        login.setOnClickListener(new View.OnClickListener()
        {
             @Override
            public void onClick(View v) {


                 validate(name.getText().toString(),password.getText().toString() );
            }
         });


                signup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(UserLogin.this, register.class);
                        startActivity(intent);
                    }
                });
        tvforgotpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserLogin.this,forgotpassword.class));
            }
        });



    }

    protected void onStart()      //when user logged in, when opening app. user redirected to SecondActivity
    {
        super.onStart();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if(currentUser != null)
        {
            startActivity(new Intent(UserLogin.this,Userprofile.class));
            finish();
        }

    }

    private void validate(String username,String userpassword)
    {
        check();
        progressDialog.setMessage("Wait till we verify if it's really you");
        progressDialog.show();
       firebaseAuth.signInWithEmailAndPassword(username, userpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {
               if (task.isSuccessful())
               {
                   progressDialog.dismiss();
                   //Toast.makeText(MainActivity.this,"Login successful!",Toast.LENGTH_SHORT).show();
                   checkmail();

               }
               else
               {
                   progressDialog.dismiss();
                   Toast.makeText(UserLogin.this,"Login Failed!",Toast.LENGTH_SHORT).show();
               }
           }
       });
    }

    private Boolean check()
    {
        boolean result=false;
        String namee= name.getText().toString();
        String passwordd=password.getText().toString();
        if (namee.isEmpty()| passwordd.isEmpty())
        {
            Toast.makeText(UserLogin.this,"Fields cannot be left blank",Toast.LENGTH_SHORT).show();
            }
        else
        {
            result=true;
        }

        return result;
    }
    private void checkmail() //to check if hes verified his email
    {
        FirebaseUser firebaseUser = firebaseAuth.getInstance().getCurrentUser();
        Boolean emailflag = firebaseUser.isEmailVerified();
        if (emailflag)
        {
            finish();
            startActivity(new Intent(UserLogin.this,action_home.class));
        }
        else
        {
            Toast.makeText(this,"Please verify Your email",Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }
    }


}
