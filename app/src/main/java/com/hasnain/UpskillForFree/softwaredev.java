package com.hasnain.UpskillForFree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.groupchat.R;
import com.google.firebase.auth.FirebaseAuth;

public class softwaredev extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private CardView frontend, backend,fullstack,mobiledev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_softwaredev);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mAuth = FirebaseAuth.getInstance();
        frontend = findViewById(R.id.frontend);
        backend = findViewById(R.id.backend);
        fullstack = findViewById(R.id.fullstack);
        mobiledev = findViewById(R.id.mobiledev);
        frontend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(softwaredev.this,com.hasnain.UpskillForFree.frontend.class));
            }
        });


    }
}