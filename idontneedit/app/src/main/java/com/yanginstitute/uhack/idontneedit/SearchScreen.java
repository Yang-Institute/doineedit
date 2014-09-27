package com.yanginstitute.uhack.idontneedit;

import android.app.Activity;

import java.net.MalformedURLException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

/**
 * Created by Lathie and MrAndrewYang on 9/27/14.
 */

public class SearchScreen extends Activity {

    EditText sEditText;

    private static final String ATTRIBUTE  = "Attribute";
    private static final String NAME = "name";
    private static final String DESC = "description";
    private static final String DPCI = "DPCI";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchscreen);

        sEditText = (EditText) findViewById(R.id.editText2);
        Intent intent = getIntent();
        String str = intent.getStringExtra("searchString");
        sEditText.setText(str);

        Concater c = new Concater(str);
        //String url = c.constructSearchURL();

        /*
        try {
            url = URLEncoder.encode(url, "UTF-8");
        }
        catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        */


        try {
            URL gurl = new URL("https://api.target.com/v2/products/search?searchTerm=patio&key=J5PsS2XGuqCnkdQq0Let6RSfvU7oyPwF");

            new DownloadFilesTask(str).execute(gurl);
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
        //sEditText.setText(URL); //Testline



        /*
        JSONParser jpar = new JSONParser();
        JSONArray Jaar = jpar.getJSONArray(URL);

        try {
            for (int i = 0; i < Jaar.length(); i++) {
                JSONObject obj = Jaar.getJSONObject(0);
                Log.d("JSONArray", obj.toString());

            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        */


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
