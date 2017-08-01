package top.jinyifei.hopes.activitys.viewPagerFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import top.jinyifei.hopes.R;
import top.jinyifei.hopes.activitys.AnimationActivity;
import top.jinyifei.hopes.activitys.BaseUi;
import top.jinyifei.hopes.activitys.BroadCastActivity;
import top.jinyifei.hopes.activitys.DataActivity;
import top.jinyifei.hopes.activitys.DynamicFragmentActivity;
import top.jinyifei.hopes.activitys.EventBusActivity;
import top.jinyifei.hopes.activitys.HandlerActivity;
import top.jinyifei.hopes.activitys.LocationActivity;
import top.jinyifei.hopes.activitys.MainActivity;
import top.jinyifei.hopes.activitys.MainMenuActivity;
import top.jinyifei.hopes.activitys.MenuActivity;
import top.jinyifei.hopes.activitys.MqttActivity;
import top.jinyifei.hopes.activitys.MyChartsActivity;
import top.jinyifei.hopes.activitys.MyViewActivity;
import top.jinyifei.hopes.activitys.NetWorkActivity;
import top.jinyifei.hopes.activitys.PhotoViewActivity;
import top.jinyifei.hopes.activitys.QRActivity;
import top.jinyifei.hopes.activitys.ServiceActivity;
import top.jinyifei.hopes.activitys.StaticFragmentActivity;
import top.jinyifei.hopes.activitys.UrlJumpActivity;
import top.jinyifei.hopes.activitys.ViewPagerActivity;
import top.jinyifei.hopes.activitys.task.TaskOneActivity;
import top.jinyifei.hopes.adapter.KnowledgeAdapter;



/**
 * author: jinyifei
 * time:  Created on 2017/7/25 13:11
 * email：jyf@whu.edu.cn
 * function：知识点主界面
 */

public class MyFragment1 extends Fragment {

    private ListView listView;
    private TextView txt_content;
    private ArrayList<String> knowledgeList;
    private KnowledgeAdapter adapter;
    private Context context;
    private View view;

    public MyFragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_one, container, false);
        initView();
        Log.e("ceshi", "1");
        return view;
    }

    private void initView() {
        txt_content = (TextView) view.findViewById(R.id.txt_content);
        listView=(ListView)view.findViewById(R.id.list_view);
        knowledgeList=new ArrayList<String>();
        knowledgeList.add("activity");
        knowledgeList.add("内容提供者");
        knowledgeList.add("菜单");
        knowledgeList.add("UI控件");
        knowledgeList.add("广播接受者");
        knowledgeList.add("强制下线");
        knowledgeList.add("数据存储");
        knowledgeList.add("服务");
        knowledgeList.add("Handler");
        knowledgeList.add("网络请求");
        knowledgeList.add("动画");
        knowledgeList.add("ViewPager");
        knowledgeList.add("静态fragment");
        knowledgeList.add("动态fragment");
        knowledgeList.add("图片加载");
        knowledgeList.add("二维码");
        knowledgeList.add("图表");
        knowledgeList.add("EventBus");
        knowledgeList.add("PhotoView");
        knowledgeList.add("自定义控件");
        knowledgeList.add("定位");
        adapter=new KnowledgeAdapter(getActivity(),knowledgeList);
        listView.setAdapter(adapter);
        setListener();
    }

    private void setListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent=new Intent();
                        intent.setAction("myActivityCeshi");
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent2=new Intent();
                        intent2.setAction("myProvider");
                        intent2.addCategory("aaa");
                        startActivity(intent2);
                        break;
                    case 2:
                        startActivity(new Intent(getActivity(),MenuActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(getActivity(),BaseUi.class));
                        break;
                    case 4:
                        startActivity(new Intent(getActivity(),BroadCastActivity.class));
                        break;
                    case 5:
                        Intent intentOffLine=new Intent("top.jinyifei.forceOffLine");
                        getActivity().sendBroadcast(intentOffLine);
                        break;
                    case 6:
                        startActivity(new Intent(getActivity(),DataActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(getActivity(),ServiceActivity.class));
                        break;
                    case 8:
                        startActivity(new Intent(getActivity(),HandlerActivity.class));
                        break;
                    case 9:
                        startActivity(new Intent(getActivity(),NetWorkActivity.class));
                        break;
                    case 10:
                        startActivity(new Intent(getActivity(),AnimationActivity.class));
                        break;
                    case 11:
                        startActivity(new Intent(getActivity(),ViewPagerActivity.class));
                        break;
                    case 12:
                        startActivity(new Intent(getActivity(),StaticFragmentActivity.class));
                        break;
                    case 13:
                        startActivity(new Intent(getActivity(),DynamicFragmentActivity.class));
                        break;
                    case 14:
                        startActivity(new Intent(getActivity(),TaskOneActivity.class));
                        break;
                    case 15:
                        startActivity(new Intent(getActivity(),QRActivity.class));
                        break;
                    case 16:
                        startActivity(new Intent(getActivity(),MainMenuActivity.class));
                        break;
                    case 17:
                        startActivity(new Intent(getActivity(),EventBusActivity.class));
                        break;
                    case 18:
                        startActivity(new Intent(getActivity(),PhotoViewActivity.class));
                        break;
                    case 19:
                        startActivity(new Intent(getActivity(),MyChartsActivity.class));
                        break;
                    case 20:
                        startActivity(new Intent(getActivity(),LocationActivity.class));
                        break;

                }
            }
        });
    }
}
