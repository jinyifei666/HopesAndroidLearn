package top.jinyifei.hopes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import top.jinyifei.hopes.R;
import top.jinyifei.hopes.models.Contact;

/**
 * Created by acera on 2017/7/24.
 */

public class ContactsAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Contact> list;

    public ContactsAdapter(Context context, ArrayList<Contact> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Contact getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        Contact contact = getItem(position);
        // 当convertView为空的时候，创建一个ViewHolder对象，
        // 并将控件的实例都存放在ViewHolder里，然后调用View的setTag()方法，
        // 将ViewHolder对象存储在View中
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.contacts_item, null);
            viewHolder = new ViewHolder();
            viewHolder.nameText = (TextView) view.findViewById(R.id.name);
            viewHolder.phoneNum = (TextView) view.findViewById(R.id.number);
            view.setTag(viewHolder);    // 将ViewHolder存储在View中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();    // 重新获取ViewHolder
        }
        viewHolder.nameText.setText(contact.getDisplayName());
        viewHolder.phoneNum.setText(contact.getNumber());
        return view;
    }

    class ViewHolder {
        TextView nameText;
        TextView phoneNum;
    }
}
