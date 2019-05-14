package com.example.web;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BrowserDemo4 extends AppCompatActivity {

    WebView webview1;
    TextView txtRecieve;
    EditText editinput;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web3);

        webview1=(WebView)findViewById(R.id.webview1);
        txtRecieve=(TextView)findViewById(R.id.txtReceive);
        editinput=(EditText)findViewById(R.id.editInput);
        btnSend=(Button)findViewById(R.id.btnSend);

        webview1.getSettings().setJavaScriptEnabled(true);
        webview1.loadUrl("file:///android_asset/html/test.html");

        webview1.addJavascriptInterface(new AndroidBridge(),"android");

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webview1.loadUrl("javascript:setMessage('"+editinput.getText()+"')");
            }
        });
    }
    Handler handler=new Handler();
    //안드로이드에서 메인스레드 외 다른 스레드가 메인화면을 변경할 수 없음. 백그라운드에서 데이터 통신
    private class AndroidBridge {  // 앱과 웹 연결하는 클래스
        @JavascriptInterface
        public void setMessage(final String arg){ // 반드시 final로 선언
            //핸들러에게 메세지 전달
            handler.post(new Runnable() {
                @Override
                public void run() {
                    //핸들러가 메세지를 받아서 메인화면 변경
                    txtRecieve.setText("받은 메시지"+arg);
                }
            });
        }
    }
}
