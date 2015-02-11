package com.rnbros.getdata;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    Button bt;
    TextView tw;
    EditText et;
    @SuppressLint("NewApi") @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        tw=(TextView) findViewById(R.id.textView1);
        et=(EditText) findViewById(R.id.editText);
        
    }
    public void getdata(View V)
    {
    	 String link=et.getText().toString();
    	 HttpClient client=new DefaultHttpClient();
         HttpGet get=new HttpGet("http://"+link+"/rnbros/get/data");
         
         try {


               HttpResponse response=client.execute(get);
               BufferedReader reader=new BufferedReader(new InputStreamReader(response.getEntity().getContent(),"UTF-08"));
               String jsonString=reader.readLine();
               JSONObject json=new JSONObject(jsonString);
               //Toast.makeText(this,json.getString("Message"),Toast.LENGTH_SHORT).show();
               tw.setText(json.getString("Message"));
          }catch(Exception e){
             Toast.makeText(this,"Error"+e,Toast.LENGTH_SHORT).show();
             }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
