package com.td.yang_gichang.jsouptesting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

public class NoticeDetail extends AppCompatActivity {

    TextView textView;
    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_detail);

        textView=(TextView)findViewById(R.id.Title);
        webview=(WebView)findViewById(R.id.wb);
        setWebview();


        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("title"));


        DetailParser parser=new DetailParser();
        parser.setUrl(intent.getStringExtra("url"));
        parser.setContext(this);
        parser.setWebView(webview);
        parser.execute();

    }

    void setWebview(){
        webview.getSettings().setSupportZoom(true);
        webview.getSettings().setBuiltInZoomControls(true);
        webview.getSettings().setDisplayZoomControls(false);

    }
}
