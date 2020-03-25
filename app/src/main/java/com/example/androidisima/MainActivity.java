package com.example.androidisima;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements OnTaskCompleted{
    TextView textView;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);

        MyViewModel model = new ViewModelProvider(this).get(MyViewModel.class);

        // execute async task
        GetFactTask task = new GetFactTask(this);
        task.execute(model);
    }
    @Override  // called in GetFactTask.onPostExecute()
    public void onTaskCompleted(String fact){
        textView.setText(fact);
        progressBar.setVisibility(View.INVISIBLE);
    }
}
