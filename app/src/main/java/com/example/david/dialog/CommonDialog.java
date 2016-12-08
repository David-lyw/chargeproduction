package com.example.david.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.david.chargeproduction.R;

/**
 * Created by David on 16/12/8.
 */
public class CommonDialog {
    public interface ViewClick {
        void onClick(int tag);
    }

    public CommonDialog() {
    }

    public static Dialog showDialog(final Context context, final ViewClick viewClick) {
        final Dialog dialog = new Dialog(context, R.style.Dialog);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.dialog_common, null);
        dialog.setContentView(layout);

        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        Window window = dialog.getWindow();
        window.setAttributes(params);
        window.getDecorView().setPadding(0, 0, 0, 0);

        TextView tv_qq = (TextView) layout.findViewById(R.id.tv_qq);
        TextView tv_weixin = (TextView) layout.findViewById(R.id.tv_weixin);
        TextView tv_friend = (TextView) layout.findViewById(R.id.tv_friend);
        Button btn_cancel = (Button) layout.findViewById(R.id.btn_cancel);
        tv_qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewClick.onClick(1);
                dialog.dismiss();
            }
        });
        tv_weixin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewClick.onClick(2);
                dialog.dismiss();
            }
        });

        tv_friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewClick.onClick(3);
                dialog.dismiss();
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewClick.onClick(4);
                dialog.dismiss();
            }
        });

        dialog.show();

        return dialog;
    }

}
