package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.net.URL;

public class NatisImplicIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_natis_implic_intent);




        //Intent receivedIntent = getIntent();
        Uri uri = Uri.parse("https://online.natis.gov.za/");
        URL webPageURL = null;

        if(uri != null){
            try{
                webPageURL = new URL(uri.getScheme(),uri.getHost(),uri.getPath());
            }
            catch (Exception e){
                Toast.makeText(this,"error occured check our network connection or report issue",Toast.LENGTH_LONG).show();
            }

            WebView webViewNatis= (WebView) findViewById(R.id.webViewNatis);
            webViewNatis.setWebViewClient(new WebViewClient());
            webViewNatis.loadUrl(webPageURL.toString());
        }

    }
}