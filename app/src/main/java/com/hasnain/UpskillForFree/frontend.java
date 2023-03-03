package com.hasnain.UpskillForFree;

import androidx.appcompat.app.AppCompatActivity;
import com.example.groupchat.R;

import android.os.Bundle;
import android.view.WindowManager;

public class frontend extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontend);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}