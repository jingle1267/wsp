package com.ihognqiqu.wsp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.ihognqiqu.wsp.target.jianshu.JSConstants;
import com.ihognqiqu.wsp.target.jianshu.JianShuFacade;
import com.ihongqiqu.webactivity.WebActivity;

public class JianShuActivity extends AppCompatActivity {

    protected EditText etKeyword;
    protected EditText etPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_jian_shu);
        initView();
    }

    public void onClickJianshuLogin(View view) {
        WebActivity.launch(this, JSConstants.JSLoginURL, "");
    }

    public void onClickJianshu(View view) {
        final String keyword = etKeyword.getText().toString();
        final int page = Integer.parseInt(etPage.getText().toString());
        if (TextUtils.isEmpty(keyword)) {
            Toast.makeText(this, "关键字不能为空!", Toast.LENGTH_SHORT).show();
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                new JianShuFacade().autoCommment(keyword, page);
            }
        }).start();
    }

    public void onClickVerifyComment(View view) {
        final String keyword = etKeyword.getText().toString();
        final int page = Integer.parseInt(etPage.getText().toString());
        String url = String.format(JSConstants.JSSearchH5URL, keyword, page);
        WebActivity.launch(this, url, "");
    }

    private void initView() {
        etKeyword = (EditText) findViewById(R.id.et_keyword);
        etPage = (EditText) findViewById(R.id.et_page);
    }
}
