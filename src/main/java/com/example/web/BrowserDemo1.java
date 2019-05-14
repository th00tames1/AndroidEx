package com.example.web;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BrowserDemo1 extends AppCompatActivity {

    private WebView webview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web1);

        webview1=(WebView)findViewById(R.id.webview1); //현재 화면이 출력되도록 설정

        webview1.getSettings().setJavaScriptEnabled(true); //자바스크립트 실행 허용
        webview1.setWebViewClient(new WebViewClient());
        webview1.loadUrl("http://m.naver.com");

    }

}
