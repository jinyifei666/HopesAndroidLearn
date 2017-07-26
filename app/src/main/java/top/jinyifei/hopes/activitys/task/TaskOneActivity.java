package top.jinyifei.hopes.activitys.task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import top.jinyifei.hopes.R;
import top.jinyifei.hopes.adapter.ImageAdapter;

public class TaskOneActivity extends AppCompatActivity {
   // private ImageLoader imageLoader=ImageLoader.getInstance();
    private ListView listView;
    private ArrayList<String> imageList;
    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_one);
        listView=(ListView)findViewById(R.id.list_view);
        AsyncHttpClient client=new AsyncHttpClient();
        RequestParams params=new RequestParams();
        params.put("keyword","美女");
        params.put("num","20");
        client.get("http://hopes.yrish.com/api",params,new JsonHttpResponseHandler(){
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                for (Header header:headers){
                    Log.w("JsonHttpRH", header.toString());
                }
                Log.w("JsonHttpRH", response.toString());
                try {
                    String state=response.getString("state");
                    if (state.equals("1")){
                        JSONArray array=response.getJSONArray("results");
                        Log.d("arrar",array.toString());
                        int len=array.length();
                        imageList=new ArrayList<String>();
                        for (int i=0;i<len;i++){
                            imageList.add(String.valueOf(array.get(i)));
                        }
                        adapter=new ImageAdapter(TaskOneActivity.this,imageList);
                        listView.setAdapter(adapter);
                    }else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.w("JsonHttpRH", "onFailure");
            }
        });

//        ImageView imageView=(ImageView)findViewById(R.id.image);
//        ImageLoader.getInstance().displayImage("https://gss1.bdstatic.com/5eN1dDebRNRTm2_p8IuM_a/res/img/richanglogo168_24.png",imageView);
    }
}
