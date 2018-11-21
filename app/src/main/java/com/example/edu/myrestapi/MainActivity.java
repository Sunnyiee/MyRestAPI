package com.example.edu.myrestapi;

import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickWeather(View view) {
        OpenWeatherAPITask task = new OpenWeatherAPITask();
        try {
            String weather = task.execute("London").get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    class OpenWeatherAPITask extends AsyncTask<String, Void, String>{

        @Override
        public String doInBackground(String... strings) {
            String[] params;
            String id = params[0];
            String urlString="http://api.openweathermap.org/data/2.5/weather"
                    +"?q="+id+"&appid=796361fc6ea2771457b108e8ddb17f23";
            URL url=new URL(urlString);
            HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection();
            InputStream in=urlConnection.getInputStream();
            byte[] buffer=new byte[1000]
                    String weather=in.read(buffer);
            return weather;
        }
    }
}
