package com.example.mlandroidexamples.digitRecognizer;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mlandroidexamples.R;

import java.io.IOException;

public class DigitRecognizerActivity extends AppCompatActivity {

    FingerPaintView mFpvPaint;
    TextView mTvPrediction;
    TextView mTvProbability;
    TextView mTvTimeCost;

    private Classifier mClassifier;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digit_recognizer);

        try {
            mClassifier = new Classifier(this);
        } catch (IOException e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();

        }


        mFpvPaint = findViewById(R.id.fpv_paint);
        mTvPrediction = findViewById(R.id.prediction);
        mTvProbability = findViewById(R.id.probability);
        mTvTimeCost = findViewById(R.id.timecost);

        Button detect = findViewById(R.id.btn_detect);
        Button clear = findViewById(R.id.btn_clear);

        detect.setOnClickListener(view -> {
            Bitmap bitmap = mFpvPaint.exportToBitmap(Classifier.IMG_WIDTH, Classifier.IMG_HEIGHT);
            Result res = mClassifier.classify(bitmap);
            mTvProbability.setText("Probability: " + res.getProbability() + "");
            mTvPrediction.setText("Prediction: " + res.getNumber() + "");
            mTvTimeCost.setText("TimeCost: " + res.getTimeCost() + "");
        });

        clear.setOnClickListener(view -> {
            mFpvPaint.clear();
            mTvPrediction.setText("");
            mTvProbability.setText("");
            mTvTimeCost.setText("");

        });
    }
}
