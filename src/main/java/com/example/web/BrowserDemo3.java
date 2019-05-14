package com.example.web;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class BrowserDemo3 extends AppCompatActivity {

    WebView webview1;
    EditText editUrl;
    Button btnOk, btnBack, btnNext, btnCancel;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web2);

        webview1=(WebView)findViewById(R.id.webview1);
        editUrl=(EditText)findViewById(R.id.editUrl);
        btnOk=(Button)findViewById(R.id.btnOk);
        btnBack=(Button)findViewById(R.id.btnBack);
        btnNext=(Button)findViewById(R.id.btnNext);
        btnCancel=(Button)findViewById(R.id.btnCancel);
        pb=(ProgressBar)findViewById(R.id.pb);

        WebSettings set=webview1.getSettings();
        set.setJavaScriptEnabled(true); //자바스크립트 사용
        set.setBuiltInZoomControls(true); //줌컨트롤 사용
        webview1.loadUrl("http://google.com");
        webview1.setWebViewClient(new WebViewClient()); //현재 화면에 구동
        webview1.setWebChromeClient(new WebChromeClient(){ //진행률 표시
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                pb.setProgress(newProgress);
                if(newProgress==100)
                    pb.setVisibility(View.GONE);
                else
                    pb.setVisibility(View.VISIBLE);
                super.onProgressChanged(view, newProgress);
            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url=editUrl.getText().toString();
                if(url.indexOf("http://")==-1){ //http 안붙였으면 붙여줘라
                    url="http://"+url;
                }
                webview1.loadUrl(url); //웹브라우저 구동
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editUrl.setText(""); //주소를 clear
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(webview1.canGoBack()){ //이전페이지가 있는가?
                    webview1.goBack(); //있으면 go
                }
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //다음페이지가 있는가?
                webview1.goForward(); //있으면 go
            }
        });
    }
}
