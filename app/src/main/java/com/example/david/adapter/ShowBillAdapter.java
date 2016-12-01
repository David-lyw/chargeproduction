package com.example.david.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.david.chargeproduction.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

/**
 * Created by David on 16/11/7.
 */
public class ShowBillAdapter extends BaseAdapter {

    public Context mContext;
    public List<String> list;
    public LayoutInflater inflater;
    public ImageView iv;


    public ShowBillAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size() + 1;
    }


    public int getDataListSize() {
        return list.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_showbillimageview, null);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.iv= (ImageView) convertView.findViewById(R.id.iv);


        if (position == list.size()) {
            Picasso.with(mContext).load("ddd").error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(viewHolder.iv);
        } else {
            String str = list.get(position);
            Log.i("lyw", "图片路径：" + position + ":" + str);
            //Picasso.with(mContext).load(new File(str)).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(iv);
            Picasso.with(mContext).load("file:///" + str).resize(100, 100).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(viewHolder.iv);
        }

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }


    public void appendList(List<String> datalist) {
        list.addAll(datalist);
        notifyDataSetChanged();
    }

    class ViewHolder {
        public ImageView iv;

    }

}
