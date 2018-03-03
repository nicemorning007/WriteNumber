/*
 * Copyright (c) 2018. this file is create by nicemorning,contact email:oypebook@outlook.com
 */

package cn.nicemorning.writenumber.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import cn.nicemorning.writenumber.R;

/**
 * Created by Nicemorning on 03-Mar-18.
 */

public class CustomProgressDialog extends ProgressDialog {
    private AnimationDrawable animationDrawable;
    private Context context;
    private ImageView imageView;
    private String loadingTip;
    private TextView loadingTv;
    private int resid;

    public CustomProgressDialog(Context context, String context1, int id) {
        super(context);
        this.context = context;
        this.loadingTip = context1;
        this.resid = id;
        setCanceledOnTouchOutside(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_dialog);
        loadingTv = (TextView) findViewById(R.id.loadingTv);
        imageView = (ImageView) findViewById(R.id.loadingIv);
        if (resid == 0) {
            imageView.setBackgroundDrawable(null);
        } else {
            imageView.setBackgroundResource(resid);
        }
        animationDrawable = (AnimationDrawable) imageView.getBackground();
        imageView.post(new Runnable() {
            @Override
            public void run() {
                animationDrawable.start();
            }
        });
        loadingTv.setText(loadingTip);
    }
}
