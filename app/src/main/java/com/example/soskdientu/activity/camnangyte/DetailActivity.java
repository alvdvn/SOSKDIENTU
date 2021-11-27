package com.example.soskdientu.activity.camnangyte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.soskdientu.R;

public class DetailActivity extends AppCompatActivity {
    WebView webView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        webView = findViewById(R.id.demo52Webview);

        intent = getIntent();
        String link = intent.getStringExtra("linkBaiViet");
        webView.loadUrl(link);
        webView.setWebViewClient(new WebViewClient());
    }
}