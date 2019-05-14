package com.example.web;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class BrowserDemo2 extends AppCompatActivity {

    WebView webview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //웹뷰 생성
        setContentView(R.layout.web1);

        //html code를 웹뷰에 출력시킴
        webview1=(WebView)findViewById(R.id.webview1);

//        String html="<html><body>안녕하세요</body></html>";
//        webview1.loadData(html,"text/html; charset=utf-8",null);
        webview1.loadUrl("file:///android_asset/html/hello.html");
    }
}
