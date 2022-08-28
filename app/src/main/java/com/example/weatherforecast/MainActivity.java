 package com.example.weatherforecast;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import kotlin.text.UStringsKt;

 public class MainActivity extends AppCompatActivity {
     private EditText didi;
   private Button main_btn;
         private TextView rezyltat;
     private View user_field;
     private Object e;

     @SuppressLint({"SetTextI18n", "MissingSuperCall"})
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    user_field = findViewById(R.id.didi);
    main_btn= findViewById(R.id.main_btn);
    rezyltat = findViewById(R.id.rezyltat);
    main_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(user_field.getRootView().toString().trim().equals(""))
                Toast.makeText(MainActivity.this, R.string.reks,Toast.LENGTH_LONG).show();
      else {
          String city = user_field.getRootView().toString();
          String key ="8824e6efaad13bf422295d83f0d492b3";
         String url = "https://api.openweathermap.org/data/2.5/weather?q= + city + &appid= + key + 8824e6efaad13bf422295d83f0d492b3&units=metric&lang=ru}";
       new GetURLData().execute(url);
        }
    });



    };
    private class GetURLData extends AsyncTask<String, String, String> {
   protected void onPreExecute() {
        super.onPreExecute ();
        rezyltat.setText("Ожидайте...");

    }


    @Override

    protected String doInBackGround (String...String) strings {
          {
    HttpURLConnection connection = null;
    BufferedReader reader = null;

             try {
                 URL url = new URL(strings[0]);
           connection = (HttpURLConnection)url.openConnection();
            connection.connect();

                 InputStream stream = connection.getInputStream();
             reader = new BufferedReader( new InputStreamReader(stream));

        StringBuffer buffer = new StringBuffer();
         String line = "";
while ((line = reader.readLine() ) != null)
      buffer.append("\n");
         return buffer.toString();

             } catch (MalformedURLException e) {
                 e.printStackTrace();
             } catch (IOException e) {
                 e.printStackTrace();
             } finally {

                 if(connection != null)
            connection.disconnect();
         if(reader != null) {
             try {
                 reader.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
        return null;

         @Override
         protected void onPostExecute(String Object result;
                 result){
      super.onPostResume(result);
      try {
          JSONObject jsonObject = new JSONObject(result);
          rezyltat.setText("Температура: " +jsonObject.getJSONObject("main").getDouble("temp"));
      } catch (IOException e) {
          e.printStackTrace();
      }
      }








             }




         }


        }

     private class GetURLData {
         public void execute(String url) {
         }
     }
 }

     private class GetURLData {
     }.