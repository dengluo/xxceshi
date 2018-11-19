package com.example.a53kf.xxceshi;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import cn.xsdzq.kf.util.ConfigerManagner;

/**
 * Created by danny on 2018/11/14.
 */

public class JSAndroid extends Object {
    private Context context;

    public JSAndroid(Context context) {
        this.context = context;
    }

    private ConfigerManagner configerManagner;

    @JavascriptInterface
    public void openAndroid(String msg) {
        Toast.makeText(context, "返回按钮监控", Toast.LENGTH_SHORT).show();
        context.startActivity(new Intent(context,TesActivity.class));
    }

    @JavascriptInterface
    public void writeData(String msg) {
        configerManagner = ConfigerManagner.getInstance(context);
        configerManagner.setString("js", msg);
    }

    @JavascriptInterface
    public String giveInformation(String msg) {
        configerManagner = ConfigerManagner.getInstance(context);
        String msg1 = configerManagner.getString("js");
        return msg1;
    }
}