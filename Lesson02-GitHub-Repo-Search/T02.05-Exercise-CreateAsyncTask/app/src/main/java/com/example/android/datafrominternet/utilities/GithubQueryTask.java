package com.example.android.datafrominternet.utilities;

import android.os.AsyncTask;

import com.example.android.datafrominternet.MainActivity;

import java.io.IOException;
import java.net.URL;

/**
 * Created by cnguogua on 2017-06-28.
 */

public class GithubQueryTask extends AsyncTask<URL,Void, String> {
    private MainActivity hostActivity;

    public GithubQueryTask(MainActivity activity)
    {
        hostActivity = activity;
    }
    @Override
    protected String doInBackground(URL... params) {
        URL githubSearchURL = params[0];
        String githubSearchResults = null;
        try
        {
            githubSearchResults = NetworkUtils.getResponseFromHttpUrl(githubSearchURL);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return githubSearchResults;
    }

    @Override
    protected void onPostExecute(String s) {
        hostActivity.UpdateResultText(s);
        //super.onPostExecute(s);
    }
}
