package com.example.androidisima;

import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


public class MyViewModel extends ViewModel {
    private CatFact catFact = null;
    public String getFact() throws IOException {
        if(catFact == null) {
            // request fact only when it's not requested yet
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url("https://catfact.ninja/fact").build();
            Response response = client.newCall(request).execute();
            if(!response.isSuccessful()){
                throw new IOException(response.toString());
            } else {
                ResponseBody responseBody = response.body();
                if (responseBody != null) {
                    Gson gson = new Gson();
                    catFact = gson.fromJson(responseBody.string(), CatFact.class);
                    System.out.println("===============" + catFact.fact);
                }
            }
        }
        if(catFact != null) {
            return catFact.fact;
        }
        else {
            return "ERROR";
        }
    }
}
