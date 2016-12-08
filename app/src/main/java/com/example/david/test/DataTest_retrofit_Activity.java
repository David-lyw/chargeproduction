package com.example.david.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.david.app.Contants;
import com.example.david.chargeproduction.R;
import com.example.david.dialog.CommonDialog;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by David on 16/9/7.
 */
public class DataTest_retrofit_Activity extends Activity {
    public String mUserName = "squre";
    public String mRepo = "retrofit";
    public Button button_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_test_retrofit);
        String value = getIntent().getStringExtra("value");
        button_dialog = (Button) findViewById(R.id.button_dialog);
        button_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonDialog.showDialog(DataTest_retrofit_Activity.this, new CommonDialog.ViewClick() {
                    @Override
                    public void onClick(int tag) {
                        switch (tag) {
                            case 1:
                                Log.i(Contants.share, "qq 分享");
                                Toast.makeText(getApplicationContext(),tag+"",Toast.LENGTH_SHORT).show();

                                break;
                            case 2:
                                Log.i(Contants.share, "微信好友 分享");
                                Toast.makeText(DataTest_retrofit_Activity.this,tag+"",Toast.LENGTH_SHORT).show();

                                break;
                            case 3:
                                Log.i(Contants.share, "朋友圈 分享");
                                Toast.makeText(DataTest_retrofit_Activity.this,tag+"",Toast.LENGTH_SHORT).show();

                                break;
                            case 4:
                                Log.i(Contants.share, "取消");
                                Toast.makeText(DataTest_retrofit_Activity.this,tag+"",Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                    }
                });
            }
        });

//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.github.com/")
//                .build();
//
//        RetrofitApi repo = retrofit.create(RetrofitApi.class);
//        Call<ResponseBody> call = repo.contributorsBySimpleGetCall(mUserName, mRepo);
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                try {
//                    Log.i("lyw", "onResponse");
////                    Gson gson = new Gson();
////                    ArrayList<Contributor> contributorsList = gson.fromJson(response.body().string(), new TypeToken<List<Contributor>>(){}.getType());
////                    for (Contributor contributor : contributorsList){
////                        Log.i("login", contributor.getLogin());
////                        Log.i("contributions",contributor.getContributions()+"");
////                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.i("lyw", "onFailure");
//            }
//        });

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date time = null;
        try {
            time = df.parse("2011-09-17");
        } catch (ParseException e) {
            e.printStackTrace();
        }


        RequestBody projectCode = RequestBody.create(MediaType.parse("multipart/form-data"), "1");
        RequestBody groupsCode = RequestBody.create(MediaType.parse("multipart/form-data"), "1");
        RequestBody deviceCode = RequestBody.create(MediaType.parse("multipart/form-data"), "1000-DDDD");
        RequestBody faultName = RequestBody.create(MediaType.parse("multipart/form-data"), value);
        RequestBody deptCode = RequestBody.create(MediaType.parse("multipart/form-data"), "22");
        RequestBody faultDate = RequestBody.create(MediaType.parse("multipart/form-data"), "1991-11-09");
        RequestBody remark = RequestBody.create(MediaType.parse("multipart/form-data"), "ahahah备注");
        RequestBody status = RequestBody.create(MediaType.parse("multipart/form-data"), "1");


        //构建要上传的文件
        String filename = "/storage/sdcard0/Pictures/Screenshots/Screenshot_2016-08-11-14-57-49.png";
        File file = new File(filename);
        RequestBody requestFile =//multipart/form-data  application/otcet-stream
                RequestBody.create(MediaType.parse("multipart/form-data"), file);

        MultipartBody.Part body =
                MultipartBody.Part.createFormData("file1", file.getName(), requestFile);


        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://120.27.25.74:8989/").addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitApi repo = retrofit.create(RetrofitApi.class);
        Call<ResponseBody> call = repo.postAsk(projectCode, groupsCode, deviceCode, faultName, deptCode, faultDate, remark, status, body);
        //Call<ResponseBody> call = repo.postAsk("1","1","1000-DDDD","cc","22","1991-11-09","ahahah备注","1");
        call.enqueue(new Callback<ResponseBody>() {//enqueue:异步
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //response.
                Log.i("lyw", "onResponse");
                try {
                    Log.i("lyw", "Headers:  " + response.headers());
                    Log.i("lyw", "message:  " + response.message());
                    Log.i("lyw", "isSuccessful:  " + response.isSuccessful());
                    Log.i("lyw", "raw:  " + response.raw());
                    Log.i("lyw", "status code:  " + response.code());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i("lyw", "onFailure");
                Log.i("lyw", t.getMessage());
            }
        });

    }
}
