package com.example.david.function;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridView;
import android.widget.Toast;

import com.example.david.adapter.ImageGridAdapter;
import com.example.david.chargeproduction.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 16/12/1.
 */
public class ImageGridActivity extends AppCompatActivity {

    GridView gridView;
    ImageGridAdapter imageGridAdapter;
    List<ImageItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagegird);
        gridView = (GridView) findViewById(R.id.gridView);

        list = new ArrayList<>();

        Uri mImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Log.i("lyw", "相册图片Uri:" + mImageUri);
        ContentResolver contentResolver = ImageGridActivity.this.getContentResolver();
        //只查询jpeg 和png 图片
        Cursor cursor = contentResolver.query(mImageUri, null,
                // MediaStore.Images.Media.MIME_TYPE + "=? or" + MediaStore.Images.Media.MIME_TYPE + "=?",//注意语法:or 后面应该有空格。
                MediaStore.Images.Media.MIME_TYPE + "=? or " + MediaStore.Images.Media.MIME_TYPE + "=?",
                new String[]{"image/jpeg", "image/pgn"},
                MediaStore.Images.Media.DATE_MODIFIED);

        while (cursor.moveToNext()) {
            //获取图片路径
            String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            ImageItem imageItem = new ImageItem();
            imageItem.path = path;
            imageItem.tag = 0;
            imageItem.uri = mImageUri;
            Log.i("lyw", cursor.getPosition() + ":相册图片路径:" + path);
            list.add(imageItem);
        }
        imageGridAdapter = new ImageGridAdapter(this, list);
        imageGridAdapter.setCheckImage(new ImageGridAdapter.CheckImage() {
            @Override
            public void chose(int position) {
                if (imageGridAdapter.getChosedDataListSize() < 9) {
                    if (list.get(position).tag == 1) {
                        list.get(position).tag = 0;
                    } else {
                        list.get(position).tag = 1;
                    }
                } else {
                    if (list.get(position).tag == 0) {
                        Toast.makeText(getApplicationContext(), "最多选中9张", Toast.LENGTH_SHORT).show();
                    } else if (list.get(position).tag == 1) {
                        list.get(position).tag = 0;
                    }
                }

                imageGridAdapter.notifyDataSetChanged();
            }
        });
        gridView.setAdapter(imageGridAdapter);
    }
}
