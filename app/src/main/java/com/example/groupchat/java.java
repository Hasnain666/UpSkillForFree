package com.example.groupchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hasnain.UpskillForFree.adapters.JavaAdapter;
import com.hasnain.UpskillForFree.adapters.PythonAdapter;
import com.hasnain.UpskillForFree.models.JavaResponse;
import com.hasnain.UpskillForFree.models.PythonResponse;

public class java extends AppCompatActivity {
    private RecyclerView recyclerView;
    JavaAdapter adapter;
    DatabaseReference mbase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getCourseList();
    }

    public void getCourseList() {
        mbase = FirebaseDatabase.getInstance("https://groupchat-42e40-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Courses").child("Java");
        recyclerView = findViewById(R.id.javaRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<JavaResponse> options
                = new FirebaseRecyclerOptions.Builder<JavaResponse>()
                .setQuery(mbase, JavaResponse.class)
                .build();
        adapter = new JavaAdapter(options,this);
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