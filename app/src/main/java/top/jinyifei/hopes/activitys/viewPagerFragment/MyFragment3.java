package top.jinyifei.hopes.activitys.viewPagerFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import top.jinyifei.hopes.R;

/**
 * author: jinyifei
 * time:  Created on 2017/7/25 13:25
 * email：jyf@whu.edu.cn
 * function：
 */
public class MyFragment3 extends Fragment {

    public MyFragment3() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content,container,false);
        TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
        txt_content.setText("Third Fragment");
        Log.e("ceshi", "3");
        return view;
    }
}
