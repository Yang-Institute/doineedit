package com.yanginstitute.uhack.idontneedit;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import  java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by MrAndrewYang on 9/27/14.
 */
public class JSONParser {

    static InputStream is = null; //Receives the data stream
    static JSONArray jsonAr = null; //Holds the json object
    static String jayson = "";

    public JSONParser() {

    }


    public JSONArray getJSONArray(String URL) {
        StringBuilder builder = new StringBuilder();
        HttpClient httpclient = new DefaultHttpClient();
        Log.d("URL", URL.toString());
        HttpGet httpGet = new HttpGet(URL);
        //HttpPost httppost = new HttpPost(URL); //stores the request locally

        try {
            HttpResponse response = httpclient.execute(httpGet);

            Log.d("Response", response.toString());

            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {
                Log.d("hi","200 status code");
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));

                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);

                }


            } else {
                Log.e("==>", "Check your internet connection");

            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            jsonAr = new JSONArray(builder.toString());

        }
        catch (JSONException e ){
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }

        return jsonAr;

    }

}
