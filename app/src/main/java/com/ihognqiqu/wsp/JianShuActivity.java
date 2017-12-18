package com.ihognqiqu.wsp;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.ihognqiqu.wsp.target.jianshu.JSConstants;
import com.ihognqiqu.wsp.target.jianshu.JianShuFacade;
import com.ihongqiqu.webactivity.WebActivity;

public class JianShuActivity extends AppCompatActivity {

    protected EditText etKeyword;
    protected EditText etPage;
    protected TextView tvResult;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_jian_shu);
        initView();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void onClickJianshuLogin(View view) {
        WebActivity.launch(this, JSConstants.JSLoginURL, "");
    }

    public void onClickJianshu(View view) {
        String keyword = "";
        int page = 1;

        if (TextUtils.isEmpty(keyword)) {
            Toast.makeText(this, "关键字不能为空!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!TextUtils.isEmpty(keyword)) {
            keyword = etKeyword.getText().toString();
        }

        if (!TextUtils.isEmpty(etPage.getText().toString())) {
            page = Integer.parseInt(etPage.getText().toString());
        }

        final String keywordTmp = keyword;
        final int pageTmp = page;

        new Thread(new Runnable() {
            @Override
            public void run() {
                final String msg = new JianShuFacade().autoCommment(keywordTmp, pageTmp);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        tvResult.setText(msg);
                    }
                });
            }
        }).start();
    }

    public void onClickVerifyComment(View view) {
        String keyword = "";
        int page = 1;


        if (!TextUtils.isEmpty(keyword)) {
            keyword = etKeyword.getText().toString();
        }
        if (!TextUtils.isEmpty(etPage.getText().toString())) {
            page = Integer.parseInt(etPage.getText().toString());
        }
        String url = String.format(JSConstants.JSSearchH5URL, keyword, page);
        WebActivity.launch(this, url, "");
    }

    private void initView() {
        etKeyword = (EditText) findViewById(R.id.et_keyword);
        etPage = (EditText) findViewById(R.id.et_page);
        tvResult = (TextView) findViewById(R.id.tv_result);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
