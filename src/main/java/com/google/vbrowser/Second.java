package com.google.vbrowser;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class Second extends AppCompatActivity {

    EditText urlEdit;
    WebView brow;
    Button go,forward,back,clear,reload;
    ProgressBar pbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

            brow = (WebView) findViewById(R.id.wv_brow);
            urlEdit = (EditText) findViewById(R.id.edit_url);
            go = (Button) findViewById(R.id.btn_go) ;
            forward = (Button) findViewById(R.id.fwd) ;
            back = (Button) findViewById(R.id.back) ;
            clear = (Button) findViewById(R.id.clear) ;
            reload = (Button) findViewById(R.id.reload) ;
            pbar = (ProgressBar) findViewById(R.id.progressBar);


            brow.setWebViewClient(new ourViewClient());

            brow.setWebChromeClient(new WebChromeClient(){
                @Override
                public void onProgressChanged(WebView view, int newProgress) {
                    pbar.setProgress(newProgress);
                    if (newProgress==100){
                        pbar.setVisibility(view.GONE);
                    }
                    else {
                        pbar.setVisibility(view.VISIBLE);
                    }
                }
            });


            WebSettings webSettings = brow.getSettings();
            webSettings.setJavaScriptEnabled(true);


            String url = "http://www.google.com";
            brow.loadUrl(url);
            go.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String editTextValue = urlEdit.getText().toString();
                    if(!editTextValue.startsWith("http://"))
                        editTextValue = "http://" + editTextValue;


                    String url = editTextValue;

                    brow.loadUrl(url);

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromInputMethod(urlEdit.getWindowToken(),0);
                }
            });

            forward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(brow.canGoForward())
                        brow.goForward();

                }
            });

            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(brow.canGoBack())
                        brow.goBack();

                }
            });

            reload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    brow.reload();

                }
            });

            clear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    brow.clearHistory();

                }
            });
        }


    }

