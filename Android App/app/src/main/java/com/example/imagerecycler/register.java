package com.example.imagerecycler;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class register<firebaseAuth> extends AppCompatActivity {

    private EditText username,useremail,userpassword,useraddress,fullname;
    private Button signup;
    private Button login;
    private FirebaseAuth firebaseAuth;
    String email,Fullname,name,address,password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setupUiViews();
        firebaseAuth = firebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(register.this,MainActivity.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate())
                {
                    String user_email= useremail.getText().toString().trim();
                    String user_password= userpassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful())
                            {
                                senduserdata();
                                Toast.makeText(register.this,"Registration succesfull.",Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(register.this,MainActivity.class));
                               Toast.makeText(register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                               sendverificationmail();
                                startActivity(new Intent(register.this,MainActivity.class));
                            }
                            else
                            {
                                Toast.makeText(register.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }

                    });
                }
            }
        });

    }




    private void setupUiViews () {
        signup = (Button) findViewById(R.id.btnsignup2);
        login = (Button) findViewById((R.id.btnlogin2));
        username = (EditText) findViewById(R.id.etusername);
        userpassword = (EditText) findViewById(R.id.etpassword);
        useremail = (EditText) findViewById(R.id.etemail);
        fullname=(EditText)findViewById(R.id.etfullname);
        useraddress=(EditText)findViewById(R.id.etaddress);


    }

    private Boolean validate()
    {
        Boolean result=false;
        name= username.getText().toString();
        password=userpassword.getText().toString();
        email=useremail.getText().toString();
        address=useraddress.getText().toString();
        Fullname=fullname.getText().toString();


        int pwd_length=password.length();

        if (name.isEmpty()| password.isEmpty()|email.isEmpty()|address.isEmpty()|Fullname.isEmpty())
        {
            Toast.makeText(this,"Please Enter required details completely!",Toast.LENGTH_SHORT).show();
        }
        else if (pwd_length<6)
        {
            Toast.makeText(this,"Password must contain at least six characters",Toast.LENGTH_SHORT).show();
        }
        else
        {
            result=true;
        }

        return result;
    }

    private  void  sendverificationmail()
    {
        final FirebaseUser firebaseUser= firebaseAuth.getCurrentUser();
        if (firebaseUser!=null)
        {
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful())
                    {

                        Toast.makeText(register.this,"Verification email sent to your email address",Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(register.this,MainActivity.class));

                    }
                    else
                    {
                        Toast.makeText(register.this,"Registration Failed,Try again later",Toast.LENGTH_SHORT).show();

                    }

                }
            });
        }
    }

    private void senduserdata()
    {
        FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
        DatabaseReference myref=firebaseDatabase.getReference().child("Users").child(firebaseAuth.getUid());
        Userprofile userprofile=new Userprofile(email,Fullname,address);
        myref.setValue(userprofile);

    }

}




