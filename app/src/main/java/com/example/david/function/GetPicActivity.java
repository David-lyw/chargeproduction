package com.example.david.function;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.david.adapter.ShowBillAdapter;
import com.example.david.chargeproduction.R;
import com.example.david.dialog.AlbumOrPhotoDialog;
import com.example.david.utils.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 16/10/27.
 * 获取图片－拍照 相册
 * 功能都正常,相册选中,返回时,没有把数据带回来。
 * <p>
 */
public class GetPicActivity extends AppCompatActivity {
    public GridView gridView;
    public ShowBillAdapter adapter;
    public ArrayList<String> list;

    public String mPhotoPath;
    public String mPhotoPath2;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getpic);
        gridView = (GridView) findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new ShowBillAdapter(GetPicActivity.this, list);


        gridView.setOnItemClickListener((parent, view, position, id) -> {
            if (position == adapter.getDataListSize()) {
                AlbumOrPhotoDialog.Builder builder = new AlbumOrPhotoDialog.Builder(GetPicActivity.this);
                //相册
                builder.setAlbumButtonClickListener((dialog, which) -> {
                    Intent intent = new Intent(this, ImageGridActivity.class);
                    startActivity(intent);
                    dialog.dismiss();
                });
                //拍照
                builder.setPhotoButtonClickListener(((dialog, which) -> {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    mPhotoPath = "img_" + System.currentTimeMillis() + ".jpg";
                    mPhotoPath2 = mPhotoPath;
                    if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                        File destDir = new File(Environment.getExternalStorageDirectory().getPath() + "/chargeproduction/formats/");//创建拍照的路径
                        if (!destDir.exists()) {
                            destDir.mkdirs();
                        }
                        mPhotoPath = destDir.getPath() + "/" + mPhotoPath;
                        Log.i("lyw", "新拍照,生成的路径:" + mPhotoPath);
                    } else {
                        Toast.makeText(getApplicationContext(), "请确认SD插入", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    uri = Uri.fromFile(new File(mPhotoPath));
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                    startActivityForResult(intent, 1);
                    dialog.dismiss();
                }));
                //弹出框取消
                builder.setCancelButtonClickListener(((dialog, which) -> {
                    dialog.dismiss();
                }));
                builder.create().show();
            } else {//进入浏览页

                Intent intent = new Intent(this, ImageBrowseActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("tag", 1 + "");
                intent.putExtra("imgs", list);
                startActivity(intent);
            }
        });
        gridView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        List<String> datas = new ArrayList<>();
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == 1) {//拍照
            if (uri != null) {
                Bitmap photo = getBitmapFromUri(uri);
                String path = FileUtil.saveBitmap(photo, mPhotoPath2);
                Log.i("lyw", "新拍照保存的路径:" + path);
                datas.add(path);
            } else {
                Toast.makeText(this, "err*****", Toast.LENGTH_SHORT).show();
                return;
            }
            mPhotoPath = "";
            mPhotoPath2 = "";
            adapter.appendList(datas);
        }
    }


    private Bitmap getBitmapFromUri(Uri uri) {
        try {
            // 读取uri所在的图片
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
            return bitmap;
        } catch (Exception e) {
            Log.e("[Android]", e.getMessage());
            Log.e("[Android]", "目录为：" + uri);
            e.printStackTrace();
            return null;
        }
    }
}
