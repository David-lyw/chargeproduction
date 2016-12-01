package com.example.david.adapter;

import android.content.Context;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by David on 16/11/7.
 */
public abstract class CommonAdapter<T> extends BaseAdapter{
    protected Context mContext;
    protected List<T> mData;

    public CommonAdapter(Context context,List<T> list){
        this.mContext=mContext;
        this.mData=list;
    }

}
