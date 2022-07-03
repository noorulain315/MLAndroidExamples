package com.example.mlandroidexamples;

import android.content.Intent;
import android.os.Bundle;

import com.example.mlandroidexamples.catsdogs.CatsDogsActivity;
import com.example.mlandroidexamples.digitRecognizer.DigitRecognizerActivity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mlandroidexamples.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();
    }

    private void setListeners() {
        binding.btnFirst.setOnClickListener(view -> {
            Intent i = new Intent(this, FirstExampleActivity.class);
            startActivity(i);
        });

        binding.btnSecond.setOnClickListener(view -> {
            Intent i = new Intent(this, FuelEfficiencyActivity.class);
            startActivity(i);
        });

        binding.btnThird.setOnClickListener(view -> {
            Intent i = new Intent(this, DigitRecognizerActivity.class);
            startActivity(i);
        });

        binding.btnCatsDogs.setOnClickListener(view -> {
            Intent i = new Intent(this, CatsDogsActivity.class);
            startActivity(i);
        });
    }

}