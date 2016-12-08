package com.example.david.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.adapter.oneFragmentAdapter;
import com.example.david.app.Contants;
import com.example.david.chargeproduction.R;
import com.example.david.dialog.CommonDialog;
import com.example.david.test.DataTest_retrofit_Activity;
import com.example.david.test.DataTest_volley_Activity;
import com.example.david.test.DataTest_xUtils_Activity;
import com.example.david.test.DataTest_okHttp_Activity;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.HttpHandler;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 16/8/31.
 */
public class oneFragment extends Fragment {

    private ListView lv;
    private oneFragmentAdapter oneAdapter;
    private String url = "http://wodm.9mobi.cn/api/v1/column?page=1&resourceType=2";

    private Button button_test;
    private EditText et_faultName;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HttpUtils http = new HttpUtils();
        http.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack() {
            @Override
            public void onSuccess(ResponseInfo responseInfo) {
                Log.i("lyw", "onSuccess");

            }

            @Override
            public void onFailure(HttpException error, String msg) {
                Log.i("lyw", "onFailure");
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container,false);
        return view;
        // return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List list=new ArrayList<String>();
        list.add("");
        list.add("");
        list.add("");
        oneAdapter = new oneFragmentAdapter(getActivity(),list);
        lv = (ListView) getActivity().findViewById(R.id.lv);
        et_faultName= (EditText) getActivity().findViewById(R.id.et_faultName);
        button_test = (Button) getActivity().findViewById(R.id.button_test);
        lv.setAdapter(oneAdapter);
//        button_test.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i("lyw", "DataTestActivity");
//                Intent intent = new Intent(getActivity(), DataTestActivity.class);
//                startActivity(intent);
//            }
//        });

        button_test.setOnClickListener((v)->{
            Log.i("lyw", "开启 DataTestActivity");
            //DataTest_xUtils_Activity、DataTest_okHttp_Activity、DataTest_retrofit_Activity、DataTest_volley_Activity
            Intent intent = new Intent(getActivity(), DataTest_retrofit_Activity.class);
            intent.putExtra("value",et_faultName.getText().toString());
            startActivity(intent);
        });


    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        // 当Fragment不可见时保存数据
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
