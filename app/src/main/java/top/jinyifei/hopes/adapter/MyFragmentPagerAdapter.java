package top.jinyifei.hopes.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import top.jinyifei.hopes.activitys.viewPagerFragment.MyFragment1;
import top.jinyifei.hopes.activitys.viewPagerFragment.MyFragment2;
import top.jinyifei.hopes.activitys.viewPagerFragment.MyFragment3;
import top.jinyifei.hopes.activitys.viewPagerFragment.MyFragment4;
import top.jinyifei.hopes.activitys.viewPagerFragment.ViewPagerFragmentActivity;

/**
 * author: jinyifei
 * time:  Created on 2017/7/25 13:23
 * email：jyf@whu.edu.cn
 * function：
 */


public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 4;
    private MyFragment1 myFragment1 = null;
    private MyFragment2 myFragment2 = null;
    private MyFragment3 myFragment3 = null;
    private MyFragment4 myFragment4 = null;


    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        myFragment1 = new MyFragment1();
        myFragment2 = new MyFragment2();
        myFragment3 = new MyFragment3();
        myFragment4 = new MyFragment4();
    }


    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position Destory" + position);
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case ViewPagerFragmentActivity.PAGE_ONE:
                fragment = myFragment1;
                break;
            case ViewPagerFragmentActivity.PAGE_TWO:
                fragment = myFragment2;
                break;
            case ViewPagerFragmentActivity.PAGE_THREE:
                fragment = myFragment3;
                break;
            case ViewPagerFragmentActivity.PAGE_FOUR:
                fragment = myFragment4;
                break;
        }
        return fragment;
    }


}

