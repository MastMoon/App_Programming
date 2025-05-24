package com.example.mobiledoctor;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_symptom)
                .setOnClickListener(v ->
                        startActivity(new Intent(this, SymptomSearchActivity.class)));

        findViewById(R.id.btn_map)
                .setOnClickListener(v ->
                        startActivity(new Intent(this, MapActivity.class)));
    }
}
