package top.jinyifei.hopes.ui.kongjian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import top.jinyifei.hopes.R;

public class HopesWebView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.webview);

        setTitle("WebView");

        WebView webview=(WebView)findViewById(R.id.webview);

        // 配置浏览器，使其可支持 JavaScript
        WebSettings webSettings=webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // 清除浏览器缓存
        webview.clearCache(true);
        // 指定浏览器需要解析的 url 地址
        webview.loadUrl("http://www.hopes-tech.com/");
        // 指定浏览器需要解析的 html 数据
        //webview.loadData("<http://www.hopes-tech.com/'>Hopes</a>", "text/html", "utf-8");
    }
}
