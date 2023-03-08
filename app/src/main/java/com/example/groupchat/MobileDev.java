package com.example.groupchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MobileDev extends AppCompatActivity {
    private CardView android,ios,cpmd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_dev);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        android = findViewById(R.id.androDev);
        ios = findViewById(R.id.iosDev);
        cpmd = findViewById(R.id.cpmd);
        android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MobileDev.this,com.example.groupchat.AndroDev.class));
            }
        });
        ios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MobileDev.this,com.example.groupchat.iosDev.class));
            }
        });
        cpmd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MobileDev.this,com.example.groupchat.cpmd.class));
            }
        });


    }
}