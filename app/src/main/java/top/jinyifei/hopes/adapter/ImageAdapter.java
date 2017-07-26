package top.jinyifei.hopes.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import top.jinyifei.hopes.R;

/**
 * author: jinyifei
 * time:  Created on 2017/7/26.
 * email：jyf@whu.edu.cn
 * function：
 */

public class ImageAdapter extends BaseAdapter {

    private ArrayList<String> imageList;
    private Context context;

    public ImageAdapter(Context context,ArrayList<String> imageList){
        this.context=context;
        this.imageList=imageList;
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public String getItem(int position) {
        return imageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        String knowledgeName = getItem(position);
        // 当convertView为空的时候，创建一个ViewHolder对象，
        // 并将控件的实例都存放在ViewHolder里，然后调用View的setTag()方法，
        // 将ViewHolder对象存储在View中
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.image_item, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.imageItem);
            view.setTag(viewHolder);    // 将ViewHolder存储在View中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();    // 重新获取ViewHolder
        }
        ImageLoader.getInstance().displayImage(imageList.get(position),viewHolder.imageView);
        return view;
    }

    class ViewHolder {
        ImageView imageView;
    }
}
