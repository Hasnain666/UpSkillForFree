package com.hasnain.UpskillForFree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.groupchat.R;

public class programminglang extends AppCompatActivity {
    CardView cplusplus,python,java,JavaScript,goLang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programminglang);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        cplusplus = findViewById(R.id.cplusplusprogramming);
        python = findViewById(R.id.pythonprogramming);
        java = findViewById(R.id.javaprogramming);
        JavaScript = findViewById(R.id.jsprogramming);
        goLang = findViewById(R.id.goLang);
        cplusplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(programminglang.this,com.example.groupchat.cplusplus.class));
            }
        });
        python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(programminglang.this, com.example.groupchat.python.class));
            }
        });
        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(programminglang.this,com.example.groupchat.java.class));

            }
        });
        JavaScript.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(programminglang.this,com.example.groupchat.JavaScript.class));
            }
        });
    }
}