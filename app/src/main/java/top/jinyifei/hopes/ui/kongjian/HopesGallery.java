package top.jinyifei.hopes.ui.kongjian;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Gallery.LayoutParams;

import top.jinyifei.hopes.R;

public class HopesGallery extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.gallery);

        setTitle("Gallery");

        Gallery gallery = (Gallery) findViewById(R.id.gallery);
        // 为缩略图浏览器指定一个适配器
        gallery.setAdapter(new ImageAdapter(this));
        // 响应 在缩略图列表上选中某个缩略图后的 事件
        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v,
                                       int position, long id) {
                Toast.makeText(HopesGallery.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }

    // 继承 BaseAdapter 用以实现自定义的图片适配器
    public class ImageAdapter extends BaseAdapter {

        private Context mContext;

        public ImageAdapter(Context context) {
            mContext = context;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView image = new ImageView(mContext);

            image.setImageResource(mThumbIds[position]);
            image.setAdjustViewBounds(true);
            image.setLayoutParams(new Gallery.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

            return image;
        }
    }

    // 需要显示的图片集合
    private Integer[] mThumbIds = { R.drawable.icon1, R.drawable.icon2,
            R.drawable.icon3, R.drawable.icon4, R.drawable.icon5 };
}
