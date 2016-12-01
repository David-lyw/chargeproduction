package com.example.david.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.david.chargeproduction.R;

/**
 * Created by David on 16/11/7.
 */
public class AlbumOrPhotoDialog extends Dialog {

    public AlbumOrPhotoDialog(Context context) {
        super(context);
    }

    public AlbumOrPhotoDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected AlbumOrPhotoDialog(Context context, boolean cancelable, DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }


    public static class Builder {
        private Context context;//此处可以定义诸多的点击事件。
        private OnClickListener albumButtonClickListener;
        private OnClickListener photoButtonClickListener;
        private OnClickListener cancelButtonClickListener;
        public Builder(Context context) {
            this.context = context;
        }

        public Builder setAlbumButtonClickListener(OnClickListener onClickListener) {
            this.albumButtonClickListener = onClickListener;
            return this;
        }


        public Builder setPhotoButtonClickListener(OnClickListener onClickListener) {
            this.photoButtonClickListener = onClickListener;
            return this;
        }

        public Builder setCancelButtonClickListener(OnClickListener onClickListener) {
            this.cancelButtonClickListener = onClickListener;
            return this;
        }

        public AlbumOrPhotoDialog create() {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            final AlbumOrPhotoDialog dialog = new AlbumOrPhotoDialog(context, R.style.Dialog);
            dialog.setCanceledOnTouchOutside(false);
            View layout = inflater.inflate(R.layout.dialog_albumorphoto, null);
            dialog.setContentView(layout);

            WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.height = WindowManager.LayoutParams.MATCH_PARENT;
            Window window = dialog.getWindow();
            window.setAttributes(params);
            window.getDecorView().setPadding(0, 0, 0, 0);


            TextView tv_album = (TextView) layout.findViewById(R.id.tv_album);
            TextView tv_photo = (TextView) layout.findViewById(R.id.tv_photo);
            Button btn_cancel = (Button) layout.findViewById(R.id.btn_cancel);


            if (albumButtonClickListener != null) {
                tv_album.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        albumButtonClickListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
                    }
                });
            }

            if (photoButtonClickListener != null) {
                tv_photo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        photoButtonClickListener.onClick(dialog, DialogInterface.BUTTON_NEGATIVE);
                    }
                });
            }

            if (cancelButtonClickListener != null) {
                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cancelButtonClickListener.onClick(dialog, DialogInterface.BUTTON_NEUTRAL);
                    }
                });
            }
            return dialog;
        }

    }
}
