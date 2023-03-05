package com.hasnain.UpskillForFree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.groupchat.R;

public class programminglang extends AppCompatActivity {
    CardView cplusplus,python,java;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programminglang);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        cplusplus = findViewById(R.id.cplusplusprogramming);
        python = findViewById(R.id.pythonprogramming);
        java = findViewById(R.id.javaprogramming);
        cplusplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(programminglang.this,com.example.groupchat.cplusplus.class));
            }
        });
    }
}