package com.example.fbw_tanks_guide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Credits extends AppCompatActivity implements View.OnClickListener {
private FloatingActionButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        button = findViewById(R.id.backButton);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intentBack = new Intent(getApplicationContext(), HeadActivity.class);
        startActivity(intentBack);
        finish();
    }
}