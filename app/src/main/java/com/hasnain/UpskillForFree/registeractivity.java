package com.hasnain.UpskillForFree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.groupchat.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registeractivity extends AppCompatActivity {
    private Button regbutton;
    private EditText regusername,regpassword;
    private FirebaseAuth mAuth;
    private TextView newuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mAuth = FirebaseAuth.getInstance();
        regusername = findViewById(R.id.regusername);
        regpassword = findViewById(R.id.regpassword);
        newuser = findViewById(R.id.newuser);
        regbutton = findViewById(R.id.regbutton);
        if (mAuth.getCurrentUser()!= null)
        {
            Intent intent= new Intent(registeractivity.this, homeactivity.class);
            startActivity(intent);
            finish();
        }
        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(registeractivity.this,loginactivity.class));
                finish();
            }
        });

        regbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registeruser();
            }
        });


    }

    private void registeruser() {

        String user = regusername.getText().toString();
        String pass = regpassword.getText().toString();
        if (!user.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(user).matches()){
            if (!pass.isEmpty()){
                mAuth.createUserWithEmailAndPassword(user,pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(registeractivity.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(registeractivity.this,loginactivity.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(registeractivity.this, "Registration Error", Toast.LENGTH_SHORT).show();
                            }
                        });

            } else {
                regpassword.setError("Empty Fields are not Allowed");
            }
        } else if(user.isEmpty()){
            regusername.setError("Empty fields Are not Allowed");
        }else{
            regusername.setError("please Enter correct email");
        }

                }
        }

