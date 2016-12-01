package com.example.david.function;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.david.adapter.TabPagerAdapter;
import com.example.david.chargeproduction.R;
import com.example.david.utils.FileUtil;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by David on 16/12/1.
 */
public class ImageBrowseActivity extends AppCompatActivity {


    ViewPager viewPager;
    ArrayList<View> listViews = new ArrayList<>();//来回滑动的视图。
    ArrayList<String> list = new ArrayList<>();//存储图片路径。

    TabPagerAdapter tabPagerAdapter;
    public String tag = "";
    public int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagebrowse);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tag = getIntent().getStringExtra("tag");//1:有删除功能 0:无删除功能。
        position = getIntent().getIntExtra("position", 0);


        list = (ArrayList<String>) getIntent().getSerializableExtra("imgs");
        for (String path : list) {
            initListViews(path);
        }
        tabPagerAdapter = new TabPagerAdapter(listViews);
        viewPager.setAdapter(tabPagerAdapter);
        viewPager.setCurrentItem(position);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    private void initListViews(String path) {
        if (listViews == null)
            listViews = new ArrayList<View>();
        ImageView img = new ImageView(this);// 构造textView对象
        img.setBackgroundColor(0xff000000);

        if (tag.equals("1")) {
            String paths = FileUtil.SDPATH + path.substring(path.lastIndexOf("/"));
            if (new File(paths).exists()) {
                path = paths;
            }
            //Picasso.with(getApplicationContext()).load(new File(path)).error(R.mipmap.loading_adapter_two).placeholder(R.mipmap.loading_adapter_two).into(img);
            Picasso.with(getApplicationContext()).load("file:///" + path).resize(1000, 1000).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(img);

        } else {
            Picasso.with(getApplicationContext()).load(path).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(img);

        }


        img.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.FILL_PARENT));
        listViews.add(img);// 添加view
    }


}
