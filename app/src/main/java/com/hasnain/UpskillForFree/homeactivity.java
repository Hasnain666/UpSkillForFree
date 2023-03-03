package com.hasnain.UpskillForFree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.groupchat.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class homeactivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private CardView programminglang,machinelearning,devops,imageView4,softwaredev;
    private ImageView btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mAuth = FirebaseAuth.getInstance();
        btnLogout = findViewById(R.id.btnLogout);
       machinelearning = findViewById(R.id.machinelearning);
        devops = findViewById(R.id.devops);
        softwaredev = findViewById(R.id.softwaredev);
        imageView4 = findViewById(R.id.imageView4);

        programminglang = findViewById(R.id.programminglang);

        programminglang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeactivity.this, com.hasnain.UpskillForFree.programminglang.class));

            }
        });
        softwaredev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeactivity.this, com.hasnain.UpskillForFree.softwaredev.class));
            }
        });
        machinelearning .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeactivity.this, machinelearning.class));
            }
        });
        devops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeactivity.this,devops.class));
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeactivity.this,datascience.class));
            }
        });





        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logout();

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            startActivity(new Intent(homeactivity.this, loginactivity.class));
            finish();
        }
    }

    private void Logout() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(homeactivity.this, loginactivity.class));
        finish();
    }
}