package com.example.androidisima;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.util.Arrays;

public class FactDetailActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
        ImageView imageView = findViewById(R.id.imageView);
        assert message != null;
        String[] first5words = Arrays.copyOfRange(message.split(" ", 200),0,5);
        String words = String.join(" ", first5words)+"...";
        System.out.println(words);
        RequestCreator rc = Picasso.get().load("https://cataas.com/cat/says/"+words);
        final ProgressBar progressBar1 = findViewById(R.id.progressBar1);
        rc.into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                progressBar1.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}
