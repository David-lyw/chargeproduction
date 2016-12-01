package com.example.david.chargeproduction;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.david.fragment.oneFragment;
import com.example.david.fragment.threeFragment;
import com.example.david.fragment.twoFragment;

/**
 * v4.app.FragmentTabHost.
 * TabHost.
 */
public class MainActivity extends AppCompatActivity {

    private FragmentTabHost tabHost;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initTabHost();
        initRadioGroup();
    }

    private void initView() {
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
    }

    private void initTabHost() {
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        // 必须先调用FragmentTabHost的setup()方法
        tabHost.setup(MainActivity.this, getSupportFragmentManager(),
                R.id.realTabcontent);


        // 为FragmentTabHost添加标签页
        // 第一个标签页
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("标签1"), // 设置该标签页标签部分所显示的文本和图标
                oneFragment.class, // 设置该标签页标签内容所来自的Fragment类
                null // 如果该标签页的Fragment初始化时需要传参，将参数放入Bundle，此处为Bundle对象
        );

        // 第二个标签页
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("标签2"),
                twoFragment.class, null);

        // 第三个标签页
//        View view = LayoutInflater.from(this).inflate(R.layout.fragment_tab,
//                null);
//        Bundle bundle = new Bundle();
//        bundle.putString("txt", "FragmentTabHost");
//        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator(view),
//                Fragment3.class, bundle);

        // 第四个标签页
        tabHost.addTab(tabHost.newTabSpec("tab4").setIndicator("标签4"),
                threeFragment.class, null);

        //tabHost.addTab(tabHost.newTabSpec("tab4").setIndicator("标签4").setContent(new Intent(this,activity_tab_4.class)));
        //tabHost.addTab(tabHost.newTabSpec("tab4").setIndicator("标签4").setContent(new Intent(activity_fragmenttabhost.this,activity_tab_4.class)));


        // FragmentTabHost 的监听器
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Toast.makeText(MainActivity.this, tabId, Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    private void initRadioGroup() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.one: //点评
                        tabHost.setCurrentTab(0);
                        break;
                    case R.id.two: //糯米
                        tabHost.setCurrentTab(1);
                        break;
                    case R.id.three: //我的
                        tabHost.setCurrentTab(2);
                        break;
                    default:
                        break;
                }
            }
        });
    }

}
