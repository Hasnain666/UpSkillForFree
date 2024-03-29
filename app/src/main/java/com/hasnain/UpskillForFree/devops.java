package com.hasnain.UpskillForFree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.groupchat.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hasnain.UpskillForFree.adapters.DevOpsAdapter;
import com.hasnain.UpskillForFree.adapters.MachineLearningAdapter;
import com.hasnain.UpskillForFree.models.DevOpsResponse;
import com.hasnain.UpskillForFree.models.MachineLearningResponse;

public class devops extends AppCompatActivity {
    private RecyclerView recyclerView;
    DevOpsAdapter adapter;
    DatabaseReference mbase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devops);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getCourseList();

    }
    public void getCourseList() {
        mbase = FirebaseDatabase.getInstance("https://groupchat-42e40-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Courses").child("DevOps");
        recyclerView = findViewById(R.id.devOpsRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<DevOpsResponse> options
                = new FirebaseRecyclerOptions.Builder<DevOpsResponse>()
                .setQuery(mbase, DevOpsResponse.class)
                .build();
        adapter = new DevOpsAdapter(options,this);
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