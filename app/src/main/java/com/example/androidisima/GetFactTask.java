package com.example.androidisima;

import android.os.AsyncTask;

import java.io.IOException;

public class GetFactTask extends AsyncTask<MyViewModel, Integer, String> {
    private OnTaskCompleted listener;
    public GetFactTask(OnTaskCompleted listener){
        this.listener = listener;
    }

    @Override
    protected String doInBackground(MyViewModel... models){
        try {
            return models[0].getFact();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ERROR";
    }

    @Override
    protected void onPostExecute(String fact){
        listener.onTaskCompleted(fact);
    }
}
