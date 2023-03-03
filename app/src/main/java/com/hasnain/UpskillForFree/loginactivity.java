package com.hasnain.UpskillForFree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.groupchat.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginactivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText loginusername, loginpassword;
    private Button loginbutton2;
    private TextView forgetpassword,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mAuth = FirebaseAuth.getInstance();
        loginusername = findViewById(R.id.loginusername);
        loginpassword = findViewById(R.id.loginpassword);
        loginbutton2 = findViewById(R.id.loginbutton2);
        register = findViewById(R.id.register);
//if user is logged in,there is no need to login again after restarting the app infinite times using this method
        //this method starts here
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(loginactivity.this, homeactivity.class));
            finish();
        }
        //ends here

        loginbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginactivity.this, registeractivity.class));
                finish();
            }
        });


    }

    private void login() {
        String user = loginusername.getText().toString().trim();
        String pass = loginpassword.getText().toString().trim();
        if (user.isEmpty()) {
            loginusername.setError("Email can not be empty");
        }
        if (pass.isEmpty()) {
            loginpassword.setError("Password can not be empty");
        } else {
            mAuth.signInWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(loginactivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(loginactivity.this, homeactivity.class));
                        finish();

                    } else {
                        Toast.makeText(loginactivity.this, "Login Failed,Please Verify your email address " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
        finish();
    }
}


