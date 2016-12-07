package com.example.david.chargeproduction;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;


import com.example.david.fragment.appOneFragment;
import com.example.david.fragment.appThreeFragment;
import com.example.david.fragment.appTwoFragment;
import com.example.david.utils.ReflectionUtil;

/**
 * Created by David on 16/8/31.
 * android.app.Fragment;
 * 自己实现的Tab.
 */
public class MainActivity_1 extends AppCompatActivity {
    private static final SparseArray<SurfaceParam> mSurfaceParams = new SparseArray<>();
    private FragmentManager mFragmentManager;
    private int mFragmantIndex = 0;

    private FrameLayout content;
    private RadioGroup bottom_layout; //最底部布局。

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_1);
        content = (FrameLayout) findViewById(R.id.content);
        bottom_layout = (RadioGroup) findViewById(R.id.bottom_layout);
        mFragmentManager = getFragmentManager();
        for (int i = 0; i < 3; i++) {
            mSurfaceParams.put(i, new SurfaceParam(getFragmentClass(i)));
        }
        initRadioGroup();
        bottom_layout.check(R.id.one);
        setTabSelection(0);

    }


    private void initRadioGroup() {
        bottom_layout.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.one: //点评
                        if (mFragmantIndex == 0) {
                        } else {
                            setTabSelection(0);
                        }
                        break;
                    case R.id.two: //糯米
                        if (mFragmantIndex == 1) {
                        } else {
                            setTabSelection(1);
                        }
                        break;
                    case R.id.three: //我的
                        if (mFragmantIndex == 2) {
                        } else {
                            setTabSelection(2);
                        }
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }


    private Class getFragmentClass(int index) {
        //点评、糯米、我的
        Class classes[] = {appOneFragment.class, appTwoFragment.class, appThreeFragment.class};
        return classes[index];
    }

    private void setTabSelection(int index) {
        if (index == 0) {
        }
        if (index == 1) {
        }
        if (index == 2) {
        }

        mFragmantIndex = index;
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        int size = mSurfaceParams.size();
        for (int i = 0; i < size; i++) {
            Fragment f = mSurfaceParams.valueAt(i).fragment;
            if (f != null) {
                transaction.hide(f);
            }
        }
        if (mSurfaceParams.get(index).fragment == null) {
            mSurfaceParams.get(index).fragment = (Fragment) ReflectionUtil.generateObject(mSurfaceParams.get(index).clazz);
           // transaction.add(R.id.content, mSurfaceParams.get(index).fragment);
            transaction.replace(R.id.content, mSurfaceParams.get(index).fragment);//防止页面重叠。
        } else {
            transaction.show(mSurfaceParams.get(index).fragment);
        }
        transaction.commit();
    }

    public static class SurfaceParam {
        private Class clazz;
        private View layout;
        private String titleId;
        private Fragment fragment;

        public SurfaceParam(Class clazz) {
            this.clazz = clazz;
        }

        public SurfaceParam(Class clazz, String titleId) {
            this.clazz = clazz;
            this.titleId = titleId;

        }

        public SurfaceParam(Class clazz, String titleId, View layout) {
            this.clazz = clazz;
            this.titleId = titleId;
            this.layout = layout;
        }
    }


}
