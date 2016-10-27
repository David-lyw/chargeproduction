package com.example.david.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.david.chargeproduction.R;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.util.PreferencesCookieStore;

/**
 * Created by David on 16/9/5.
 */
public class DataTest_xUtils_Activity extends Activity {
    public String url = "http://wodm.9mobi.cn/api/v1/column?page=1&resourceType=2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_test_xutils);
        HttpUtils http = new HttpUtils(1000);
        http.configResponseTextCharset("UTF-8");
        http.configCurrentHttpCacheExpiry(0L);
        http.configDefaultHttpCacheExpiry(0L);
        http.configRequestThreadPoolSize(10);
        PreferencesCookieStore cookieStore = new PreferencesCookieStore(getApplicationContext());
        cookieStore.clear();
        http.configCookieStore(cookieStore);

        http.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack<String>() {
            @Override
            public void onStart() {
                super.onStart();
                Log.i("lyw", "onStart");
            }

            @Override
            public void onLoading(long total, long current, boolean isUploading) {
                super.onLoading(total, current, isUploading);
                Log.i("lyw", "onLoading");
            }

            @Override
            public void onSuccess(ResponseInfo responseInfo) {
                Log.i("lyw", "onSuccess");
            }

            @Override
            public void onFailure(HttpException error, String msg) {
                Log.i("lyw", "onFailure" + msg);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
