package com.example.david.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.david.chargeproduction.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by David on 16/9/7.
 */
public class DataTest_okHttp_Activity extends Activity {
    public String url = "http://wodm.9mobi.cn/api/v1/column?page=1&resourceType=2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_test_okhttp);

        //HTTP GET
        Request request = new Request.Builder()
                //.url("http://publicobject.com/helloworld.txt")
                .url(url)
                .build();
        new OkHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("lyw", "onFailure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                if (!response.isSuccessful())
//                    throw new IOException("Unexpected code " + response);
//                Headers responseHeaders = response.headers();
//                for (int i = 0, size = responseHeaders.size(); i < size; i++) {
//                    System.out.println(responseHeaders.name(i) + ": "
//                            + responseHeaders.value(i));
//                }
//                System.out.println(response.body().string());

                Log.i("lyw", "onResponse");
            }
        });


    }
}
