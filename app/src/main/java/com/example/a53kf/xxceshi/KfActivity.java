package com.example.a53kf.xxceshi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import cn.xsdzq.kf.activity.MainActivity;
/*
* @author danny
* @emil
* create at 2018/11/16 15:47
* description:
*/

public class KfActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kf);
        webView = (WebView) findViewById(R.id.webView);
        //加载网页而不调用外部浏览器
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

//        webView.loadUrl("https://tb.53kf.com/code/app/10189955/1?device=android1");
        webView.loadUrl("https://tb.53kf.com/code/client/10189955/1?device=android&u_cust_name=胡铁花&u_cust_id=1232");
        /* 设置支持Js,必须设置的,基本大多数网页都涉及js */
        webView.getSettings().setJavaScriptEnabled(true);
        /* 设置为true时表示支持使用js打开新的窗口 */
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        /* 当网页需要保存数时据,设置下面属性 */
        webView.getSettings().setDomStorageEnabled(true);
        /* 设置为使用webview推荐的窗口，主要是为了配合下一个属性 */
        webView.getSettings().setUseWideViewPort(true);
        /* 设置网页自适应屏幕大小，该属性必须和上一属性配合使用 */
        webView.getSettings().setLoadWithOverviewMode(true);
        /* 启用还H5的地理定位服务 */
        webView.getSettings().setGeolocationEnabled(true);
        /* 设置是否允许webview使用缩放的功能 */
        webView.getSettings().setBuiltInZoomControls(false);
        /* 提高网页渲染的优先级 */
        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        /* 设置是否显示水平滚动条 */
        webView.setHorizontalScrollBarEnabled(false);
        /* 设置垂直滚动条是否有叠加样式 */
        webView.setVerticalScrollbarOverlay(true);
        /* 设置滚动条的样式 */
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // TODO Auto-generated method stub
                if (newProgress == 100) {
                    // newProgress代表网页加载进度，到达100完成加载

                } else {
                    // 正在加载中

                }

            }
        });
        webView.addJavascriptInterface(new JSAndroid(),"Android");
    }

    private final class JSAndroid{
        @SuppressLint("JavascriptInterface")
        @JavascriptInterface
        public void openAndroid(String userInfo){
//            Toast.makeText(KfActivity.this, userInfo, Toast.LENGTH_LONG).show();
//            Toast.makeText(KfActivity.this, "返回按钮监控22", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
                webView.goBack();//返回上个页面
            } else {
                finish();
            }
        }
        return true;
    }




}
