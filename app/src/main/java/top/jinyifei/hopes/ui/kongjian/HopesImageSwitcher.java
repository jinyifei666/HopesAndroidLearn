package top.jinyifei.hopes.ui.kongjian;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import top.jinyifei.hopes.R;

// 图片转换器的使用基本同文字转换器
//以下是一个用 ImageSwitcher + Gallery 实现的经典的图片浏览器的 Demo

public class HopesImageSwitcher extends Activity implements ViewSwitcher.ViewFactory{
    private ImageSwitcher mSwitcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.imageswitcher);

        setTitle("ImageSwithcer");
        mSwitcher = (ImageSwitcher) findViewById(R.id.imageswitcher);
        mSwitcher.setFactory(this);
        mSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in));
        mSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out));

        Gallery gallery = (Gallery) findViewById(R.id.gallery);
        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v,
                                       int position, long id) {
                mSwitcher.setImageResource(mImageIds[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }

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

    private Integer[] mThumbIds = { R.drawable.icon1, R.drawable.icon2,
            R.drawable.icon3, R.drawable.icon4, R.drawable.icon5 };

    private Integer[] mImageIds = { R.drawable.icon1, R.drawable.icon2,
            R.drawable.icon3, R.drawable.icon4, R.drawable.icon5 };

    @Override
    public View makeView() {
        ImageView image = new ImageView(this);
        image.setMinimumHeight(200);
        image.setMinimumWidth(200);
        image.setScaleType(ImageView.ScaleType.FIT_CENTER);
        image.setLayoutParams(new ImageSwitcher.LayoutParams(
                LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        return image;
    }
}
