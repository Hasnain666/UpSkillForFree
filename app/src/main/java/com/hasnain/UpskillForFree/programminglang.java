package com.hasnain.UpskillForFree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.groupchat.R;

public class programminglang extends AppCompatActivity {
    CardView cardView,cardView1,cardView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programminglang);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        cardView = findViewById(R.id.cplusplusprogramming);
        cardView1 = findViewById(R.id.pythonprogramming);
        cardView2 = findViewById(R.id.javaprogramming);





    }
}