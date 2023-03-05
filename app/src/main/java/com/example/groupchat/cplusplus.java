package com.example.groupchat;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.FirebaseDatabase;
import com.hasnain.UpskillForFree.adapters.CplusplusAdapter;
import com.hasnain.UpskillForFree.models.CplusplusResponse;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import android.os.Bundle;
import android.view.WindowManager;

import com.google.firebase.database.DatabaseReference;

import java.util.Objects;

public class cplusplus extends AppCompatActivity {
    private RecyclerView recyclerView;
    CplusplusAdapter adapter;
    DatabaseReference mbase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cplusplus);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getCourseList();
    }

    public void getCourseList() {
        mbase = FirebaseDatabase.getInstance("https://groupchat-42e40-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Courses").child("C++");
        recyclerView = findViewById(R.id.cplusplusRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<CplusplusResponse> options
                = new FirebaseRecyclerOptions.Builder<CplusplusResponse>()
                .setQuery(mbase, CplusplusResponse.class)
                .build();

        adapter = new CplusplusAdapter(options,this);
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