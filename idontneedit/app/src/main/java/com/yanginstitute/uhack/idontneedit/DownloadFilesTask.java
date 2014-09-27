package com.yanginstitute.uhack.idontneedit;

/**
 * Created by Lathie on 9/27/14.
 */

import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

public class DownloadFilesTask extends AsyncTask<URL, Integer, Long> {
    protected Long doInBackground(URL... urls) {

        JSONParser jpar = new JSONParser();
        JSONArray Jaar = jpar.getJSONArray(urls.toString());

        try {
            for (int i = 0; i < Jaar.length(); i++) {
                JSONObject obj = Jaar.getJSONObject(0);
                Log.d("JSONArray", obj.toString());

            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }

        /*
        int count = urls.length;
        long totalSize = 0;
        for (int i = 0; i < count; i++) {
            totalSize += Downloader.downloadFile(urls[i]);
            publishProgress((int) ((i / (float) count) * 100));
            // Escape early if cancel() is called
            if (isCancelled()) break;
        }
        return totalSize;
        */

        long totalSize = 0;
        return totalSize;
    }

    /*
    protected void onProgressUpdate(Integer... progress) {
        setProgressPercent(progress[0]);
    }

    protected void onPostExecute(Long result) {
        showDialog("Downloaded " + result + " bytes");
    }
    */
}
