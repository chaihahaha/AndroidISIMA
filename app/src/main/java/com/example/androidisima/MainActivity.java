package com.example.androidisima;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    TextView textView;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);

        MyViewModel model = new ViewModelProvider(this).get(MyViewModel.class);
        final Observer<CatFact> observer = new Observer<CatFact>() {
            @Override
            public void onChanged(CatFact catFact) {
                progressBar.setVisibility(View.INVISIBLE);
                textView.setText(catFact.fact);
            }
        };
        model.getFact().observe(this, observer);
    }

}
