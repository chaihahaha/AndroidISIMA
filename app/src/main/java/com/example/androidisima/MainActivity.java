package com.example.androidisima;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private CatFacts myDataset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);


        MyViewModel model = new ViewModelProvider(this).get(MyViewModel.class);
        final Observer<CatFacts> observer = new Observer<CatFacts>() {
            @Override
            public void onChanged(CatFacts catFacts) {
                progressBar.setVisibility(View.INVISIBLE);
                myDataset = catFacts;
                mAdapter = new MyAdapter(myDataset);
                recyclerView.setAdapter(mAdapter);
            }
        };
        model.getFact().observe(this, observer);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));


    }

}
