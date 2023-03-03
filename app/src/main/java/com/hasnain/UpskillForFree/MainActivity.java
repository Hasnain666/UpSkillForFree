package com.hasnain.UpskillForFree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.groupchat.R;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread td = new Thread(){
            public void run(){
                try {
                    sleep(3700);

                }catch (Exception ex){
                    ex.printStackTrace();

                }
                finally {
                    Intent intent = new Intent(MainActivity.this , loginactivity.class);
                    startActivity(intent);
                    finish();


                }
            }


        };td.start();
        }
    }
