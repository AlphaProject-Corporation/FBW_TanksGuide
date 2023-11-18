package com.example.fbw_tanks_guide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HeadActivity extends AppCompatActivity implements View.OnClickListener {
    private Button array;
    private Button credits;
    private Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);

        array = findViewById(R.id.arrayButton);
        credits = findViewById(R.id.creditsButton);
        update = findViewById(R.id.updateButton);

        array.setOnClickListener(this);
        credits.setOnClickListener(this);
        update.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.arrayButton) {
            Intent intentToArray = new Intent(getApplicationContext(), ViewActivity.class);
            startActivity(intentToArray);
            finish();
        } else if (view.getId() == R.id.creditsButton) {
            Intent intentToCredits = new Intent(getApplicationContext(), Credits.class);
            startActivity(intentToCredits);
            finish();
        } else if (view.getId() == R.id.updateButton){
            Intent intentToUpdateScreen = new Intent(getApplicationContext(), Updates.class);
            startActivity(intentToUpdateScreen);
            finish();
        }
    }
}