package com.example.e_biro;

import android.annotation.SuppressLint;
import android.app.AppComponentFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class Oglasi extends AppCompatActivity {

    private WebView myWebView;


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oglasi);
        myWebView = (WebView)findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("http://www.nsz.gov.rs/live/trazite-posao/svi-poslovi");
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().getBuiltInZoomControls();
        WebView browser = (WebView) findViewById(R.id.webView);
        browser.getSettings().setLoadWithOverviewMode(true);
        browser.getSettings().setUseWideViewPort(true);
        this.myWebView.getSettings().setBuiltInZoomControls(true);
        this.myWebView.getSettings().setDisplayZoomControls(true);
    }

    @Override
    public void onBackPressed() {
        if(myWebView.canGoBack()){
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }



}