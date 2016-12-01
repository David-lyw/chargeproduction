package com.example.david.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.david.chargeproduction.R;

import java.util.List;

/**
 * Created by David on 16/9/2.
 */
public class oneFragmentAdapter extends BaseAdapter {
    public Context context;
    public List list;
    //public TextView tv;
    public oneFragmentAdapter(Context context,List list){
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView==null){
            viewHolder = new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.item_fragment_one,null);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.tv=(TextView)convertView.findViewById(R.id.tv);
        viewHolder.tv.setText("我是在适配器中设置的数据。。。。。");



        return convertView;
    }


    class ViewHolder {
        public TextView tv;

    }


}
