package com.td.yang_gichang.jsouptesting;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by yang-gichang on 2017. 5. 27..
 */

public class DetailParser extends AsyncTask<ArrayList<String>,Integer,Void> {
    String url;
    WebView webView;
    Context context;
    String el;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setWebView(WebView webView) {
        this.webView = webView;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    protected Void doInBackground(ArrayList<String>... params) {
        try {
            Document doc= Jsoup.connect(url).get();
           el=doc.select(".xed").toString();

            Log.d("linkD",el);
            el=el.replace("<img","<img width=400 ");
        } catch (IOException e) {
            Log.d("detail","fucked");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        onProgressUpdate();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.d("pg update","pg");
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.loadDataWithBaseURL(null, el, "text/html", "utf-8", null);

    }




}
