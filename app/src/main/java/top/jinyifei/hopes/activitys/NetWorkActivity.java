package top.jinyifei.hopes.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import cz.msebera.android.httpclient.Header;

import org.json.JSONObject;

import top.jinyifei.hopes.R;

public class NetWorkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_work);
        requestNet();
    }

    public void requestNet(){
        AsyncHttpClient client=new AsyncHttpClient();
        RequestParams params=new RequestParams();
        params.put("keyword","风景");
        params.put("num",20);
        client.get("http://hopes.yrish.com/imgsearch",params,new JsonHttpResponseHandler(){
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                for (Header header:headers){
                    Log.w("JsonHttpRH", header.toString());
                }
                Log.w("JsonHttpRH", response.toString());

            }
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.w("JsonHttpRH", "onFailure");
            }
        });





    }
}
