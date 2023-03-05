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
import com.google.android.gms.tasks.OnSuccessListener;
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
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginactivity.this, registeractivity.class));
                finish();
            }
        });

        //ends here

        loginbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        if (mAuth.getCurrentUser() != null)
        {
            Intent intent= new Intent(loginactivity.this, homeactivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void login() {
        String user = loginusername.getText().toString(); //.trim
        String pass = loginpassword.getText().toString();

        if (!user.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(user).matches()){
            if (!pass.isEmpty()){
                mAuth.signInWithEmailAndPassword(user,pass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(loginactivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(loginactivity.this,homeactivity.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(loginactivity.this, "Login Failed!!", Toast.LENGTH_SHORT).show();
                            }
                        });

            } else {
                loginpassword.setError("Empty Fields are not Allowed");
            }
        } else if(user.isEmpty()){
            loginusername.setError("Empty fields Are not Allowed");
        }else{
            loginusername.setError("please Enter correct email");
        }
    }
}


