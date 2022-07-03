package com.example.mlandroidexamples.catsdogs;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mlandroidexamples.R;


import java.io.IOException;
import java.util.List;

public class CatsDogsActivity extends AppCompatActivity implements View.OnClickListener {

    private int mInputSize = 224;
    private String mModelPath = "converted_model.tflite";
    private String mLabelPath = "label.txt";
    private ClassifierCatDog classifier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cats_dogs_classifier);
        try {
            initClassifier();
            initViews();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initClassifier() throws IOException {
        classifier = new ClassifierCatDog(getAssets(), mModelPath, mLabelPath, mInputSize);
    }

    private void initViews() {
        findViewById(R.id.iv_1).setOnClickListener(this);
        findViewById(R.id.iv_2).setOnClickListener(this);
        findViewById(R.id.iv_3).setOnClickListener(this);
        findViewById(R.id.iv_4).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Bitmap bitmap = ((BitmapDrawable) ((ImageView) v).getDrawable()).getBitmap();

        List<ClassifierCatDog.Recognition> result = classifier.recognizeImage(bitmap);

        Toast.makeText(this, result.get(0).toString(), Toast.LENGTH_SHORT).show();
    }
}
