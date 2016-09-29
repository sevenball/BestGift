package com.wangshiqi.bestgift.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.wangshiqi.bestgift.R;

/**
 * Created by dllo on 16/9/29.
 */
public class GiftDetailActivity extends AbsBaseActivity {
    private WebView giftDetailWb;
    private Button goToTaobao;
    @Override
    protected int setLayout() {
        return R.layout.activity_giftdetail;
    }

    @Override
    protected void initViews() {
        giftDetailWb = byView(R.id.giftdetail_wb);
        goToTaobao = byView(R.id.taobao_btn);
    }

    @Override
    protected void initDatas() {
        giftDetailWb.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
                return super.shouldOverrideKeyEvent(view, event);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        final String taobaoUrl = intent.getStringExtra("taobaoUrl");
        giftDetailWb.loadUrl(url);
        goToTaobao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("taobao", taobaoUrl);
                goTo(GiftDetailActivity.this, TaobaoShoppingActivity.class, bundle);
            }
        });
    }

}