package com.example.david.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by David on 16/12/1.
 */
public class TabPagerAdapter extends PagerAdapter {
    private List<View> pageViews;

    public TabPagerAdapter(List<View> pagerViews) {
        this.pageViews = pagerViews;
    }

    @Override
    public int getCount() {
        return pageViews.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = pageViews.get(position);
        container.addView(view);
        //return super.instantiateItem(container, position);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
        if(position>=0&&position<getCount()){
            container.removeView(pageViews.get(position));
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getItemPosition(Object object) {

        return super.getItemPosition(object);
    }
}
