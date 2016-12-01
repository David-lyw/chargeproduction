package com.example.david.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.david.chargeproduction.R;
import com.example.david.function.ImageItem;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by David on 16/12/1.
 * <p>
 * 浏览相册图片适配器。
 */
public class ImageGridAdapter extends BaseAdapter {
    public Context mContext;
    public List<ImageItem> list;
    public LayoutInflater inflater;

    public ImageGridAdapter(Context context, List<ImageItem> list) {
        this.mContext = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_imagegird, null);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.iv = (ImageView) convertView.findViewById(R.id.iv);
        viewHolder.iv_choose = (ImageView) convertView.findViewById(R.id.iv_choose);
        viewHolder.rl_item = (RelativeLayout) convertView.findViewById(R.id.rl_item);
        ImageItem imageItem = list.get(position);

        if (imageItem.path != null) {
            Log.i("lyw", "图片路径：" + position + ":" + imageItem.path);
            Picasso.with(mContext).load("file:///" + imageItem.path).resize(100, 100).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(viewHolder.iv);
        } else {
            Picasso.with(mContext).load("ddd").error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(viewHolder.iv);
        }

        if (imageItem.tag == 0) {
            viewHolder.iv_choose.setImageResource(R.mipmap.icon_unchoose);
        } else if (imageItem.tag == 1) {
            viewHolder.iv_choose.setImageResource(R.mipmap.icon_choose);
        }

        viewHolder.rl_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkImage != null) {
                    checkImage.chose(position);
                }
            }
        });


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

    class ViewHolder {
        public RelativeLayout rl_item;
        public ImageView iv;
        public ImageView iv_choose;

    }


    public CheckImage checkImage;

    public interface CheckImage {
        public void chose(int position);
    }

    public void setCheckImage(CheckImage checkImage) {
        this.checkImage = checkImage;
    }


    //返回选中条目的数量值
    public int getChosedDataListSize() {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).tag == 1) {
                count++;
            }
        }
        return count;
    }

}
