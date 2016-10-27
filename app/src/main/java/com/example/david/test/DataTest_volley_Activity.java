package com.example.david.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.david.chargeproduction.R;

/**
 * Created by David on 16/9/7.
 */
public class DataTest_volley_Activity extends Activity {
    public String url = "http://wodm.9mobi.cn/api/v1/column?page=1&resourceType=2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_test_volley);

        RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());

        //"http://www.baidu.com"
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("lyw", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("lyw", error.getMessage(), error);
            }
        });

        mQueue.add(stringRequest);

    }
}
