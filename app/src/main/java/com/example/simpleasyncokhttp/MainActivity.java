package com.example.simpleasyncokhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doMagic(View view) {
        String url = "http://www.espn.com";

        OkHttpClient client = new OkHttpClient();
        Request request = new  Request.Builder()
                .url(url)
                .build();

        //Synch call to AsyncTask
        // client.newCall(request).execute();

        //Async using Okhttp - craete an intenet service n=by itself - triggered automatically
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
        //required with callback
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "onTResponse: " + response.body().string());
            }
        });

        /*try {
            Response response = client.newCall(request).execute();
            Log.d(TAG, "doMagic: " + response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
