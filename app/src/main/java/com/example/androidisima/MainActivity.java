package com.example.androidisima;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView textView = (TextView) findViewById(R.id.textView);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                TextView textView = v.getRootView().findViewById(R.id.textView);
                EditText editText = v.getRootView().findViewById(R.id.editText);
                if(textView!=null)
                {
                    textView.setText(editText.getText());
                }
            }
        });
    }
}
