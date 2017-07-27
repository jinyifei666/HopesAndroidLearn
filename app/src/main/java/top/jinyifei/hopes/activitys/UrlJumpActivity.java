package top.jinyifei.hopes.activitys;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import top.jinyifei.hopes.R;

public class UrlJumpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url_jump);
        Intent intent = getIntent();
        String scheme = intent.getScheme();
        Uri uri = intent.getData();
        System.out.println("scheme:"+scheme);
        if (uri != null) {
            String host = uri.getHost();
            String dataString = intent.getDataString();
            String id = uri.getQueryParameter("id");
            String path = uri.getPath();
            String path1 = uri.getEncodedPath();
            String queryString = uri.getQuery();
            Log.w("host:",host);
            Log.w("dataString:",dataString);
            Log.w("id:",id);
            Log.w("path:",path);
            Log.w("path1:",path1);
            Log.w("queryString:",queryString);
        }
    }
}
