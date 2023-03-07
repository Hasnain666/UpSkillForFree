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
import com.hasnain.UpskillForFree.adapters.JavaScriptAdapter;
import com.hasnain.UpskillForFree.models.JavaResponse;
import com.hasnain.UpskillForFree.models.JavaScriptResponse;

public class JavaScript extends AppCompatActivity {
    private RecyclerView recyclerView;
    JavaScriptAdapter adapter;
    DatabaseReference mbase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_script);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getCourseList();
    }
    public void getCourseList() {
        mbase = FirebaseDatabase.getInstance("https://groupchat-42e40-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Courses").child("JavaScript");
        recyclerView = findViewById(R.id.JsRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<JavaScriptResponse> options
                = new FirebaseRecyclerOptions.Builder<JavaScriptResponse>()
                .setQuery(mbase, JavaScriptResponse.class)
                .build();
        adapter = new JavaScriptAdapter(options,this);
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