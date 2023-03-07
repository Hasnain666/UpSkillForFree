package com.example.groupchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hasnain.UpskillForFree.adapters.GoLangAdapter;
import com.hasnain.UpskillForFree.adapters.JavaScriptAdapter;
import com.hasnain.UpskillForFree.models.GoLangResponse;
import com.hasnain.UpskillForFree.models.JavaScriptResponse;

public class goLang extends AppCompatActivity {
    private RecyclerView recyclerView;
    GoLangAdapter adapter;
    DatabaseReference mbase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_lang);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getCourseList();
    }
    public void getCourseList() {
        mbase = FirebaseDatabase.getInstance("https://groupchat-42e40-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Courses").child("GoLang");
        recyclerView = findViewById(R.id.goLangRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<GoLangResponse> options
                = new FirebaseRecyclerOptions.Builder<GoLangResponse>()
                .setQuery(mbase, GoLangResponse.class)
                .build();
        adapter = new GoLangAdapter(options,this);
        recyclerView.setAdapter(adapter);

    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override protected void onStart()
    {
        super.onStart();
        adapter.startListening();
    }

    @Override protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }

}