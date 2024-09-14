package com.example.timer;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
public class StopwatchActivity extends AppCompatActivity {
    private int seconds = 0;
    private boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }
}