package com.example.groupchat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hasnain.UpskillForFree.adapters.CplusplusAdapter;
import com.hasnain.UpskillForFree.adapters.PythonAdapter;
import com.hasnain.UpskillForFree.models.CplusplusResponse;
import com.hasnain.UpskillForFree.models.PythonResponse;

import android.os.Bundle;
import android.view.WindowManager;

public class python extends AppCompatActivity {
    private RecyclerView recyclerView;
    PythonAdapter adapter;
    DatabaseReference mbase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getCourseList();
    }

    public void getCourseList() {
        mbase = FirebaseDatabase.getInstance("https://groupchat-42e40-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Courses").child("Python");
        recyclerView = findViewById(R.id.pythonRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<PythonResponse> options
                = new FirebaseRecyclerOptions.Builder<PythonResponse>()
                .setQuery(mbase, PythonResponse.class)
                .build();
        adapter = new PythonAdapter(options,this);
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